package ui.administor;

import java.rmi.RemoteException;
import java.util.ArrayList;
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
import businesslogicservice.AccountCustomerService;
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
import po.CustomerAccount;
import tools.ResultMessage_Account;
import ui.utils.Dialogs;
import vo.CustomerVO;
/**
 * 客户管理的委托类
 * @author zjy
 *
 */
public class CustomerController {
	private static final String titles[]={"用户名","客户ID","客户姓名","性别","联系方式"};
	private static final String defaultPassword="hibernate";
	
	private JFXTreeTableView<Customer> customerList;
	private TextField filterField;
	private Button reset;
	private Button delete;
	private ObservableList<Customer> customers;//列表项的集合
	private Label count;
	private Button add;
	
	/**
	 * 
	 * @param customerList 显示列表的TreeTableView
	 * @param filterField 过滤显示的TextField
	 * @param reset 重置密码按钮
	 * @param delete 删除账号按钮
	 * @param count 计数Lable
	 * @param add 增加账号按钮
	 */
	public CustomerController(JFXTreeTableView<Customer> customerList,TextField filterField,Button reset,
			Button delete,Label count,Button add) {
		this.customerList = customerList;
		this.filterField=filterField;
		this.reset=reset;
		this.delete=delete;
		this.count=count;
		this.add=add;
		initCustomer();
	}
	
	
	private void initCustomer(){
		customers = FXCollections.observableArrayList();
//		customers.add(new Customer("userName", "customerID", "customerName", "gender", "contactWay"));
//		customers.add(new Customer("userName1", "customerID", "customerName", "gender", "contactWay"));
//		上面时一个例子
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		List<CustomerAccount> list = null;
		try {
			 list  = accountCustomerService.getCustomerAccount();
		} catch (RemoteException e) {
			Dialogs.showMessage("阿欧", "网络连接好像断开了……");
			list  = new ArrayList<>();
		}
		customers.addAll(list.stream().map(account -> new Customer(account.getUserName(),
				account.getCustomerID(), account.getCustomerName(), account.getGender(), account.getContactWay()))
				.collect(Collectors.toList()));
		
		final TreeItem<Customer> root = new RecursiveTreeItem<Customer>(customers, RecursiveTreeObject::getChildren);
		customerList.setRoot(root);
		customerList.setEditable(true);
		//创建TreeTableView的列
		for(int index=0;index<titles.length;index++){
			setCustomerColumn(index);
		}
		//为filterField增加监听方法
		filterField.textProperty().addListener((o,oldVal,newVal)->{
			customerList.setPredicate(customer -> customer.getValue().userName.get().contains(newVal) || 
					customer.getValue().customerID.get().contains(newVal) || 
					customer.getValue().customerName.get().contains(newVal) || 
					customer.getValue().gender.get().contains(newVal) || 
					customer.getValue().contactWay.get().contains(newVal) );
		});
		reset.setOnAction((action)->resetPassword());
		delete.setOnAction((action)->delete());
		add.setOnAction((action)->add());
		reset.disableProperty().bind(Bindings.equal(-1, customerList.getSelectionModel().selectedIndexProperty()));
		delete.disableProperty().bind(Bindings.equal(-1, customerList.getSelectionModel().selectedIndexProperty()));
		//为计数器Lable绑定显示的信息来源
		count.textProperty().bind(Bindings.createStringBinding(()-> 
			"共计 " + customerList.getCurrentItemsCount()+" 条", customerList.currentItemsCountProperty()));
	}
	private void setCustomerColumn(int index){
		JFXTreeTableColumn<Customer, String> colum=new JFXTreeTableColumn<>(titles[index]);
		colum.setPrefWidth(150);
		colum.setCellValueFactory((TreeTableColumn.CellDataFeatures<Customer, String> param) ->{
			StringProperty propertys[]={param.getValue().getValue().userName,param.getValue().getValue().customerID,
					param.getValue().getValue().customerName,param.getValue().getValue().gender,
					param.getValue().getValue().contactWay};
			if(colum.validateValue(param)) return propertys[index];
			else return colum.getComputedValue(param);
		});
		// add editors
		if(index!=1){//客户ID不允许网站管理人员修改
			colum.setCellFactory((TreeTableColumn<Customer, String> param) -> 
			new GenericEditableTreeTableCell<Customer, String>(new TextFieldEditorBuilder()));
			colum.setOnEditCommit((CellEditEvent<Customer, String> t)->{
			Customer customer=(Customer)t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue();
			StringProperty propertys[]={customer.userName,customer.customerID,customer.customerName,
					customer.gender,customer.contactWay};
			propertys[index].set(t.getNewValue());//t.getNewValue()是编辑后的值
			edit(customer);
			});
		}
		
		customerList.getColumns().add(colum);
	}	
	private void edit(Customer customer) {
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		//TODO:调用blservice修改账号信息，例如：customer.contactWay.get()返回string类型的联系方式
	}
	private void resetPassword() {
		if(customerList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=customerList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("reset:"+userName);
		
		String customerID=customerList.getSelectionModel().getSelectedItem().getValue().customerID.get();
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		ResultMessage_Account rs = accountCustomerService.resetPassword(customerID, defaultPassword);
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("耶耶","重置密码成功！≧∇≦");
		}else{
			Dialogs.showMessage("额", "重置失败，也许是网络问题？");
		}
	}
	private void delete() {
		if(customerList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=customerList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("delete:"+userName);
		
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		String customerID=customerList.getSelectionModel().getSelectedItem().getValue().customerID.get();
		ResultMessage_Account rs = accountCustomerService.deleteAccount(customerID);		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("", "删除成功");
			customers.remove(customerList.getSelectionModel().getSelectedItem().getValue());
		}else{
			Dialogs.showMessage("额", "删除失败，也许是网络问题？");
		}
	}
	private void add() {
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		ResultMessage_Account result=accountCustomerService.addAccount("newUser", defaultPassword);
		if(ResultMessage_Account.Success.equals(result)){
			try {
				CustomerVO customerVO=accountCustomerService.getCustomerDetail(
						accountCustomerService.getAccountID("newUser"));
				customers.add(new Customer(accountCustomerService.getUsername(customerVO.customerID), 
						customerVO.customerID, customerVO.customerName, customerVO.gender, customerVO.telephone));
				Dialogs.showMessage("", "增加账号成功");
			} catch (RemoteException e) {
				Dialogs.showMessage("额", "增加账号失败，也许是用户"+"newUser"+"已经存在，或者是网络问题？");
			}
		}else{
			Dialogs.showMessage("额", "增加账号失败，也许是网络问题？");
		}
	}
	
	/**
	 * 要显示的客户属性
	 * @author zjy
	 *
	 */
	class Customer extends RecursiveTreeObject<Customer>{		
		StringProperty userName;
		StringProperty customerID;
		StringProperty customerName;
		StringProperty gender;
		StringProperty contactWay;
		
		/**
		 * 
		 * @param userName 用户名
		 * @param customerID 客户ID
		 * @param customerName 客户姓名
		 * @param gender 性别
		 * @param contactWay 联系方式
		 */
		public Customer(String userName, String customerID, String customerName,
				String gender, String contactWay) {
			this.userName = new SimpleStringProperty(userName) ;
			this.customerID = new SimpleStringProperty(customerID) ;
			this.customerName = new SimpleStringProperty(customerName) ;
			this.gender = new SimpleStringProperty(gender) ;
			this.contactWay = new SimpleStringProperty(contactWay) ;
		}
//		
//		public Customer(CustomerAccount account){
//			this.userName = new SimpleStringProperty(account.getUserName()) ;
//			this.customerID = new SimpleStringProperty(account.getCustomerID()) ;
//			this.customerName = new SimpleStringProperty(account.getCustomerName()) ;
//			this.gender = new SimpleStringProperty(account.getGender()) ;
//			this.contactWay = new SimpleStringProperty(account.getContactWay()) ;
//		}
	}
}
