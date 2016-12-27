package ui.administor;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import businesslogic.account.CustomerAccountController;
import businesslogic.account.HotelAccountController;
import businesslogic.account.WebDesignerAccountController;
import businesslogic.customer.CustomerDealController;
import businesslogicservice.AccountCustomerService;
import businesslogicservice.AccountHotelService;
import businesslogicservice.AccountWebService;
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
import tools.ResultMessage_Account;
import ui.administor.CustomerController.Customer;
import ui.administor.HotelController.Hotel;
import ui.utils.Dialogs;
import vo.CustomerVO;
import vo.WebAccountVO;
/**
 * 网站营销人员账号管理的委托类
 * @author zjy
 *
 */
public class WebController {
	private static final String titles[]={"用户名","账户ID"};
	private static final String defaultPassword="123456";
	
	private JFXTreeTableView<Web> webList;
	private TextField filterField;
	private Button reset;
	private Button delete;
	private ObservableList<Web> webs;
	private Label count;
	private Button add;

	/**
	 * 
	 * @param webList 显示列表的TreeTableView
	 * @param filterField 过滤显示的TextField
	 * @param reset 重置密码按钮
	 * @param delete 删除账号按钮
	 * @param count 计数Lable
	 * @param add 增加账号按钮
	 */
	public WebController(JFXTreeTableView<Web> webList,TextField filterField,Button reset,
			Button delete,Label count,Button add) {
		this.webList = webList;
		this.filterField=filterField;
		this.reset=reset;
		this.delete=delete;
		this.count=count;
		this.add=add;
		initWeb();
	}
	
	
	private void initWeb(){
		webs = FXCollections.observableArrayList();
//		webs.add(new Web("userName","webName"));
//		webs.add(new Web("userName1","webName"));
		//上面是一个例子
		WebDesignerAccountController webDesignerAccountController = WebDesignerAccountController.getInstance();
		List<WebAccountVO> list = webDesignerAccountController.getWebAccount();
		//网站营销人员的名字 没有 暂时先用id 代替
		webs.addAll(list.stream().map(account -> new Web(account.name,account.id)).collect(Collectors.toList()));
		
		final TreeItem<Web> root = new RecursiveTreeItem<Web>(webs, RecursiveTreeObject::getChildren);
		webList.setRoot(root);
		webList.setEditable(true);
		//创建TreeTableView的列
		for(int index=0;index<titles.length;index++){
			setCustomerColumn(index);
		}
		//为filterField增加监听方法
		filterField.textProperty().addListener((o,oldVal,newVal)->{
			webList.setPredicate(web -> web.getValue().userName.get().contains(newVal) || 
					web.getValue().webName.get().contains(newVal));
		});
		reset.setOnAction((action)->resetPassword());
		delete.setOnAction((action)->delete());
		add.setOnAction((action)->add());
		reset.disableProperty().bind(Bindings.equal(-1, webList.getSelectionModel().selectedIndexProperty()));
		delete.disableProperty().bind(Bindings.equal(-1, webList.getSelectionModel().selectedIndexProperty()));
		//为计数器Lable绑定显示的信息来源
		count.textProperty().bind(Bindings.createStringBinding(()-> 
			"共计 " + webList.getCurrentItemsCount()+" 条", webList.currentItemsCountProperty()));
	}
	private void setCustomerColumn(int index){
		JFXTreeTableColumn<Web, String> colum=new JFXTreeTableColumn<>(titles[index]);
		colum.setPrefWidth(150);
		colum.setCellValueFactory((TreeTableColumn.CellDataFeatures<Web, String> param) ->{
			StringProperty propertys[]={param.getValue().getValue().userName,param.getValue().getValue().webName};
			if(colum.validateValue(param)) return propertys[index];
			else return colum.getComputedValue(param);
		});
		// add editors
		if(index!=1){//网站营销人员账号ID不允许网站管理人员修改
			colum.setCellFactory((TreeTableColumn<Web, String> param) -> 
			new GenericEditableTreeTableCell<Web, String>(new TextFieldEditorBuilder()));
			colum.setOnEditCommit((CellEditEvent<Web, String> t)->{
			Web web=(Web)t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue();
			StringProperty propertys[]={web.userName,web.webName};
			propertys[index].set(t.getNewValue());//t.getNewValue()是编辑后的值
			edit(web);
			});
		}
		
		webList.getColumns().add(colum);
	}
	
	
	
	
	private void edit(Web web) {
		WebDesignerAccountController webDesignerAccountController = WebDesignerAccountController.getInstance();
		String webID=webList.getSelectionModel().getSelectedItem().getValue().webName.get();
		String userName=webList.getSelectionModel().getSelectedItem().getValue().userName.get();
		ResultMessage_Account rs = webDesignerAccountController.modifyUserName(webID, userName);
		
		if(rs == ResultMessage_Account.Success){
			
		}else{
			Dialogs.showMessage("提醒","您输入的用户名可能已经存在了");
			initWeb();
		}
		//TODO:调用blservice修改账号信息，例如：web.userName.get()返回string类型的联系方式
	}
	
	
	
	
	private void resetPassword() {
		if(webList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=webList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("reset:"+userName);
		
		String id=webList.getSelectionModel().getSelectedItem().getValue().webName.get();
		WebDesignerAccountController webDesignerAccountController = 
				WebDesignerAccountController.getInstance();
		ResultMessage_Account rs = webDesignerAccountController.resetPassword(id, defaultPassword);
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("耶耶","重置密码成功！≧∇≦");
		}else{
			Dialogs.showMessage("额", "重置失败，也许是网络问题？");
		}
		
		
	}
	private void delete() {
		if(webList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=webList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("delete:"+userName);
		
		String id=webList.getSelectionModel().getSelectedItem().getValue().webName.get();
		WebDesignerAccountController webDesignerAccountController = 
				WebDesignerAccountController.getInstance();
		ResultMessage_Account rs = webDesignerAccountController.deleteAccount(id);
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("", "删除成功");
			webs.remove(webList.getSelectionModel().getSelectedItem().getValue());
		}else{
			Dialogs.showMessage("额", "删除失败，也许是网络问题？");
		}
	}
	private void add() {
		AccountWebService accountWebService = WebDesignerAccountController.getInstance();
		ResultMessage_Account result=accountWebService.addAccount("newUser", defaultPassword);
		if(ResultMessage_Account.Success.equals(result)){
			Dialogs.showMessage("", "增加账号成功");
			webs.add(new Web("newUser", accountWebService.getAccountID("newUser")));
		}else{
			Dialogs.showMessage("额", "增加账号失败，也许是用户"+"newUser"+"已经存在，或者是网络问题？");
		}
	}
	
	/**
	 * 要显示的网站营销人员属性
	 * @author zjy
	 *
	 */
	class Web extends RecursiveTreeObject<Web>{		
		StringProperty userName;
		StringProperty webName;
		
		/**
		 * 
		 * @param userName 用户名
		 * @param webName 网站营销人员的名字
		 */
		public Web(String userName, String webName) {
			super();
			this.userName = new SimpleStringProperty(userName) ;
			this.webName = new SimpleStringProperty(webName) ;
		}
	}
}
