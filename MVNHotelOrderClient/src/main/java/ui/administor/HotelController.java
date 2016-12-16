package ui.administor;

import java.util.List;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import businesslogic.account.HotelAccountController;
import businesslogic.hotel.HotelDealController;
import businesslogic.hotel.HotelManageController;
import businesslogicservice.AccountHotelService;
import businesslogicservice.HotelDealService;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import po.HotelAccount;
import tools.ResultMessage_Account;
import tools.ResultMessage_Hotel;
import tools.Star;
import ui.utils.Dialogs;
import vo.HotelInputVO;
import vo.HotelbriefVO;
/**
 * 酒店账号管理的委托类
 * @author zjy
 *
 */
public class HotelController {
	private static final String titles[]={"用户名","酒店ID","酒店名称","酒店地址","联系方式"};
	private static final String defaultPassword="woaini";
	
	private JFXTreeTableView<Hotel> hotelList;
	private TextField filterField;
	private Button reset;
	private Button delete;
	private ObservableList<Hotel> hotels;//列表项的集合
	private Label count;
	private Button add;

	/**
	 * 
	 * @param hotelList 显示列表的TreeTableView
	 * @param filterField 过滤显示的TextField
	 * @param reset 重置密码按钮
	 * @param delete 删除账号按钮
	 * @param count_hotel 计数Lable
	 * @param add_hotel 增加账号按钮
	 */
	public HotelController(JFXTreeTableView<Hotel> hotelList,TextField filterField,Button reset,
			Button delete,Label count,Button add) {
		this.hotelList = hotelList;
		this.filterField=filterField;
		this.reset=reset;
		this.delete=delete;
		this.count=count;
		this.add=add;
		initHotel();
	}
	
	
	private void initHotel(){
		hotels = FXCollections.observableArrayList();
//		hotels.add(new Hotel("userName", "hotelID", "hotelName", "hotelAddresssssssssssssssssss", "contactWay"));
//		hotels.add(new Hotel("userName1", "hotelID", "hotelName", "hotelAddress", "contactWay"));
//		上面是一个例子
		
		AccountHotelService accountHotelService = HotelAccountController.getInstance();
		List<HotelAccount> list = accountHotelService.getHotelAccount();
	
		hotels.addAll(list.stream().map(account -> new Hotel(account.getUserName(),
				account.getCustomerID(), account.getHotelName(), account.getHotelAddress(), account.getContactWay()))
				.collect(Collectors.toList()));
		
		final TreeItem<Hotel> root = new RecursiveTreeItem<Hotel>(hotels, RecursiveTreeObject::getChildren);
		hotelList.setRoot(root);
		hotelList.setEditable(true);
		//创建TreeTableView的列
		for(int index=0;index<titles.length;index++){
			setCustomerColumn(index);
		}
		//为filterField增加监听方法
		filterField.textProperty().addListener((o,oldVal,newVal)->{
			hotelList.setPredicate(hotel -> hotel.getValue().userName.get().contains(newVal) || 
					hotel.getValue().hotelID.get().contains(newVal) || 
					hotel.getValue().hotelName.get().contains(newVal) || 
					hotel.getValue().hotelAddress.get().contains(newVal) || 
					hotel.getValue().contactWay.get().contains(newVal) );
		});
		reset.setOnAction((action)->resetPassword());
		delete.setOnAction((action)->delete());
		add.setOnAction((action)->add());
		reset.disableProperty().bind(Bindings.equal(-1, hotelList.getSelectionModel().selectedIndexProperty()));
		delete.disableProperty().bind(Bindings.equal(-1, hotelList.getSelectionModel().selectedIndexProperty()));
		//为计数器Lable绑定显示的信息来源
		count.textProperty().bind(Bindings.createStringBinding(()-> 
			"共计 " + hotelList.getCurrentItemsCount()+" 条", hotelList.currentItemsCountProperty()));
	}
	private void setCustomerColumn(int index){
		JFXTreeTableColumn<Hotel, String> colum=new JFXTreeTableColumn<>(titles[index]);
		colum.setPrefWidth(150);
		colum.setCellValueFactory((TreeTableColumn.CellDataFeatures<Hotel, String> param) ->{
			StringProperty propertys[]={param.getValue().getValue().userName,param.getValue().getValue().hotelID,
					param.getValue().getValue().hotelName,param.getValue().getValue().hotelAddress,
					param.getValue().getValue().contactWay};
			if(colum.validateValue(param)) return propertys[index];
			else return colum.getComputedValue(param);
		});
		// add editors
		if(index!=1){//酒店ID不允许网站管理人员修改
			colum.setCellFactory((TreeTableColumn<Hotel, String> param) -> 
			new GenericEditableTreeTableCell<Hotel, String>(new TextFieldEditorBuilder()));
			colum.setOnEditCommit((CellEditEvent<Hotel, String> t)->{
			Hotel hotel=(Hotel)t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue();
			StringProperty propertys[]={hotel.userName,hotel.hotelID,hotel.hotelName,
					hotel.hotelAddress,hotel.contactWay};
			propertys[index].set(t.getNewValue());//t.getNewValue()是编辑后的值
			edit(hotel);
			});
		}
		
		hotelList.getColumns().add(colum);
	}
	private void edit(Hotel hotel) {
		AccountHotelService accountHotelService = HotelAccountController.getInstance();
		//TODO:调用blservice修改账号信息，例如：hotel.contactWay.get()返回string类型的联系方式
	}
	private void resetPassword() {
		if(hotelList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=hotelList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("reset:"+userName);
		
		String hotelID=hotelList.getSelectionModel().getSelectedItem().getValue().hotelID.get();
		AccountHotelService accountHotelService = HotelAccountController.getInstance();
		ResultMessage_Account rs = accountHotelService.resetPassword(hotelID, defaultPassword);
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("耶耶","重置密码成功！≧∇≦");
		}else{
			Dialogs.showMessage("额", "重置失败，也许是网络问题？");
		}	
		
	}
	private void delete() {
		if(hotelList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=hotelList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("delete:"+userName);
		
		String hotelID=hotelList.getSelectionModel().getSelectedItem().getValue().hotelID.get();
		AccountHotelService accountHotelService = HotelAccountController.getInstance();
		ResultMessage_Account rs = accountHotelService.deleteAccount(hotelID);
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("", "删除成功");
			hotels.remove(hotelList.getSelectionModel().getSelectedItem().getValue());
		}else{
			Dialogs.showMessage("额", "删除失败，也许是网络问题？");
		}
	}
	private void add() {
		AccountHotelService accountHotelService = HotelAccountController.getInstance();
		HotelManageController hotelManageController = HotelManageController.getInstance();
		HotelInputVO hotelInputVO = new HotelInputVO("newHotel", defaultPassword, "新增的酒店", Star.one);
		ResultMessage_Hotel result =hotelManageController.addHotel(hotelInputVO);
		//ResultMessage_Account result=hotelManageController.addAccount("newUser", defaultPassword);
		HotelDealService hotelDealService=HotelDealController.getInstance();
		if(ResultMessage_Hotel.success.equals(result)){
			Dialogs.showMessage("", "增加账号成功");
			HotelbriefVO hotelbriefVO=hotelDealService.getHotelInfo(
					accountHotelService.getAccountID("newHotel"));
			hotels.add(new Hotel(accountHotelService.getUsername(hotelbriefVO.hotelID), 
					hotelbriefVO.hotelID, hotelbriefVO.hotelName, hotelbriefVO.hotelAddress.toString(),
					"contackWay"));
		}else{
			Dialogs.showMessage("额", "增加账号失败，也许是用户"+"newHotel"+"已经存在，或者是网络问题？");
		}
	}
	
	/**
	 * 要显示的酒店属性
	 * @author zjy
	 *
	 */
	class Hotel extends RecursiveTreeObject<Hotel>{		
		StringProperty userName;
		StringProperty hotelID;
		StringProperty hotelName;
		StringProperty hotelAddress;
		StringProperty contactWay;
		
		/**
		 * 
		 * @param userName 用户名
		 * @param hotelID 酒店ID
		 * @param hotelName 酒店名称
		 * @param hotelAddress 酒店地址
		 * @param contactWay 联系方式
		 */
		public Hotel(String userName, String hotelID, String hotelName,
				String hotelAddress, String contactWay) {
			this.userName = new SimpleStringProperty(userName) ;
			this.hotelID = new SimpleStringProperty(hotelID) ;
			this.hotelName = new SimpleStringProperty(hotelName) ;
			this.hotelAddress = new SimpleStringProperty(hotelAddress) ;
			this.contactWay = new SimpleStringProperty(contactWay) ;
		}
//		
//		public Hotel(HotelAccount account) {
//			this.userName = new SimpleStringProperty(account.getUserName()) ;
//			this.hotelID = new SimpleStringProperty(account.getCustomerID()) ;
//			this.hotelName = new SimpleStringProperty(account.getHotelName()) ;
//			this.hotelAddress = new SimpleStringProperty(account.getHotelAddress()) ;
//			this.contactWay = new SimpleStringProperty(account.getContactWay()) ;
//		} 
	}
}
