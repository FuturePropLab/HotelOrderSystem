package ui.administor;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
/**
 * 酒店账号管理的委托类
 * @author zjy
 *
 */
public class HotelController {
	private JFXTreeTableView<Hotel> hotelList;
	private TextField filterField;
	private Button reset;
	private Button delete;
	private ObservableList<Hotel> hotels;//列表项的集合

	/**
	 * 
	 * @param hotelList 显示列表的TreeTableView
	 * @param filterField 过滤显示的TextField
	 * @param reset 重置密码按钮
	 * @param delete 删除账号按钮
	 */
	public HotelController(JFXTreeTableView<Hotel> hotelList,TextField filterField,Button reset,Button delete) {
		this.hotelList = hotelList;
		this.filterField=filterField;
		this.reset=reset;
		this.delete=delete;
		initHotel();
	}
	
	
	private void initHotel(){
		hotels = FXCollections.observableArrayList();
		hotels.add(new Hotel("userName", "hotelID", "hotelName", "hotelAddresssssssssssssssssss", "contactWay"));
		hotels.add(new Hotel("userName1", "hotelID", "hotelName", "hotelAddress", "contactWay"));
		//上面时一个例子
		//TODO:调用blservice添加酒店账号信息
		final TreeItem<Hotel> root = new RecursiveTreeItem<Hotel>(hotels, RecursiveTreeObject::getChildren);
		hotelList.setRoot(root);
		
		for(int index=0;index<5;index++){
			setCustomerColumn(index);
		}
		filterField.textProperty().addListener((o,oldVal,newVal)->{
			hotelList.setPredicate(hotel -> hotel.getValue().userName.get().contains(newVal) || 
					hotel.getValue().hotelID.get().contains(newVal) || 
					hotel.getValue().hotelName.get().contains(newVal) || 
					hotel.getValue().hotelAddress.get().contains(newVal) || 
					hotel.getValue().contactWay.get().contains(newVal) );
		});
		reset.setOnAction((action)->resetPassword());
		delete.setOnAction((action)->delete());
	}
	private void setCustomerColumn(int index){
		String titles[]={"用户名","酒店ID","酒店名称","酒店地址","联系方式"};
		JFXTreeTableColumn<Hotel, String> colum=new JFXTreeTableColumn<>(titles[index]);
		colum.setPrefWidth(150);
		colum.setCellValueFactory((TreeTableColumn.CellDataFeatures<Hotel, String> param) ->{
			StringProperty propertys[]={param.getValue().getValue().userName,param.getValue().getValue().hotelID,
					param.getValue().getValue().hotelName,param.getValue().getValue().hotelAddress,
					param.getValue().getValue().contactWay};
			if(colum.validateValue(param)) return propertys[index];
			else return colum.getComputedValue(param);
		});
		hotelList.getColumns().add(colum);
	}	
	private void resetPassword() {
		if(hotelList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=hotelList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("reset:"+userName);
		//TODO:调用blservice重置密码
	}
	private void delete() {
		if(hotelList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=hotelList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("delete:"+userName);
		//TODO:调用blservice删除账号
		
		
		hotels.remove(hotelList.getSelectionModel().getSelectedItem().getValue());
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
	}
}
