package ui.administor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import businesslogic.account.CustomerAccountController;
import businesslogicservice.AccountCustomerService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import po.CustomerAccount;
import tools.ResultMessage_Account;
import ui.utils.Dialogs;
/**
 * 客户管理的委托类
 * @author zjy
 *
 */
public class CustomerController {
	private JFXTreeTableView<Customer> customerList;
	private TextField filterField;
	private Button reset;
	private Button delete;
	private ObservableList<Customer> customers;//列表项的集合

	/**
	 * 
	 * @param customerList 显示列表的TreeTableView
	 * @param filterField 过滤显示的TextField
	 * @param reset 重置密码按钮
	 * @param delete 删除账号按钮
	 */
	public CustomerController(JFXTreeTableView<Customer> customerList,TextField filterField,Button reset,Button delete) {
		this.customerList = customerList;
		this.filterField=filterField;
		this.reset=reset;
		this.delete=delete;
		initCustomer();
	}
	
	
	private void initCustomer(){
		customers = FXCollections.observableArrayList();
//		customers.add(new Customer("userName", "customerID", "customerName", "gender", "contactWay"));
//		customers.add(new Customer("userName1", "customerID", "customerName", "gender", "contactWay"));
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		List<CustomerAccount> list = null;
		try {
			 list  = accountCustomerService.getCustomerAccount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list  = new ArrayList<>();
		}
		
		//TODO  以后改成lamda表达式
		Iterator<CustomerAccount>  it = list.iterator();
		while(it.hasNext()){
			customers.add(new Customer(it.next()));
		}
		
		
		
		//上面时一个例子
		//TODO:调用blservice添加酒店账号信息
		final TreeItem<Customer> root = new RecursiveTreeItem<Customer>(customers, RecursiveTreeObject::getChildren);
		customerList.setRoot(root);
		
		for(int index=0;index<5;index++){
			setCustomerColumn(index);
		}
		filterField.textProperty().addListener((o,oldVal,newVal)->{
			customerList.setPredicate(customer -> customer.getValue().userName.get().contains(newVal) || 
					customer.getValue().customerID.get().contains(newVal) || 
					customer.getValue().customerName.get().contains(newVal) || 
					customer.getValue().gender.get().contains(newVal) || 
					customer.getValue().contactWay.get().contains(newVal) );
		});
		reset.setOnAction((action)->resetPassword());
		delete.setOnAction((action)->delete());
	}
	private void setCustomerColumn(int index){
		String titles[]={"用户名","客户ID","客户姓名","性别","联系方式"};
		JFXTreeTableColumn<Customer, String> colum=new JFXTreeTableColumn<>(titles[index]);
		colum.setPrefWidth(150);
		colum.setCellValueFactory((TreeTableColumn.CellDataFeatures<Customer, String> param) ->{
			StringProperty propertys[]={param.getValue().getValue().userName,param.getValue().getValue().customerID,
					param.getValue().getValue().customerName,param.getValue().getValue().gender,
					param.getValue().getValue().contactWay};
			if(colum.validateValue(param)) return propertys[index];
			else return colum.getComputedValue(param);
		});
		customerList.getColumns().add(colum);
	}	
	private void resetPassword() {
		if(customerList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=customerList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("reset:"+userName);
		
		String userID=customerList.getSelectionModel().getSelectedItem().getValue().customerID.get();
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		ResultMessage_Account rs = accountCustomerService.resetPassword(userID, "hibernate");
		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("重置密码成功");
		}else{
			Dialogs.showMessage("重置失败 可能是连接又问题s!");
		}
		
		//TODO:调用blservice重置密码
	}
	private void delete() {
		if(customerList.getSelectionModel().getSelectedItem()==null){
			return;
		}
		String userName=customerList.getSelectionModel().getSelectedItem().getValue().userName.get();
		System.out.println("delete:"+userName);
		//TODO:调用blservice删除账号
		AccountCustomerService accountCustomerService = CustomerAccountController.getInstance();
		String userID=customerList.getSelectionModel().getSelectedItem().getValue().customerID.get();
		ResultMessage_Account rs = accountCustomerService.deleteAccount(userID);		
		if(rs.equals(ResultMessage_Account.Success)){
			Dialogs.showMessage("删除成功");
			customers.remove(customerList.getSelectionModel().getSelectedItem().getValue());
		}else{
			Dialogs.showMessage("删除失败 可能是连接又问题s!");
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
		
		public Customer(CustomerAccount account){
			this.userName = new SimpleStringProperty(account.getUserName()) ;
			this.customerID = new SimpleStringProperty(account.getCustomerID()) ;
			this.customerName = new SimpleStringProperty(account.getCustomerName()) ;
			this.gender = new SimpleStringProperty(account.getGender()) ;
			this.contactWay = new SimpleStringProperty(account.getContactWay()) ;
		}
	}
}
