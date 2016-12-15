package ui.administor;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import ui.administor.CustomerController.Customer;
import ui.administor.HotelController.Hotel;
import ui.administor.WebController.Web;
import ui.main.DetailsController;

/**
 * 用户、酒店管理界面的控制器，管理酒店即管理酒店工作人员账号
 * 这个模块大量使用了泛型和lambada表达式，并且用的模式不是可视化编程
 * 列表支持超大量数据，亲测120000条数据同时存在时也不会卡
 * 只在初始化的时候从bl层调一次数据
 * 支持过滤、排序等功能，全部在ui层完成
 * 支持直接在列表项上修改数据，但是我把这个开关关了
 * @author zjy
 *
 */
public class UserAdminController extends DetailsController{
	
	@FXML
	private JFXTreeTableView<Customer> customerList;
	@FXML
	private Label count_customer;
	@FXML
	private TextField customerFilter;
	@FXML
	private Button reset_customer;
	@FXML
	private Button delete_customer;
	@FXML
	private JFXTreeTableView<Hotel> hotelList;
	@FXML
	private Label count_hotel;
	@FXML
	private TextField hotelFilter;
	@FXML
	private Button reset_hotel;
	@FXML
	private Button delete_hotel;
	@FXML
	private JFXTreeTableView<Web> webList;
	@FXML
	private Label count_web;
	@FXML
	private TextField webFilter;
	@FXML
	private Button reset_web;
	@FXML
	private Button delete_web;
	
	private CustomerController customerController;
	private HotelController hotelController;
	private WebController webController;
	
	@FXML
	private void initialize(){
		customerController=new CustomerController(customerList,customerFilter,reset_customer,delete_customer
				,count_customer);
		hotelController=new HotelController(hotelList, hotelFilter, reset_hotel, delete_hotel,count_hotel);
		webController=new WebController(webList, webFilter, reset_web, delete_web,count_web);
	}
	

}
