package ui.customer;

import java.util.Date;

import com.sun.javafx.scene.control.skin.HyperlinkSkin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tools.RoomType;
import ui.main.DetailsController;

/**
 * 预订酒店界面的控制器
 * @author zjy
 *
 */
public class BookHotelController extends DetailsController{
	@FXML
	private Label customerName;
	@FXML
	private Hyperlink hotelName;
	@FXML
	private Label discount;
	@FXML
	private Label originalPrice;
	@FXML
	private Label realPrice;
	@FXML
	private ComboBox<String> roomType;
	@FXML
	private TextField roomNumber;
	@FXML
	private DatePicker lastDate;
	@FXML
	private DatePicker lastDate_time;
	@FXML
	private DatePicker planedLeaveDate;
	@FXML
	private DatePicker planedLeaveDate_time;
	@FXML
	private TextField people;
	@FXML
	private CheckBox children;
	@FXML
	private Button preview;
	@FXML
	private Button confirm;
	
	@FXML
	private void handleHotelName(){
		//TODO:跳转到酒店详情界面
	}
	@FXML
	private void handlePreview(){
		//TODO:跳转到订单预览界面
	}
	@FXML
	private void handleConfirm(){
		//TODO:调用blservice下单
	}
	@FXML
	private void handlePrice(){
		//TODO:计算当前的价格，更改组件的值
	}
	@FXML
	private void handleDate(){
		//TODO:如果预计离开时间早于最晚到店时间，提示用户，否则handlePrice()
	}
	
	/**
	 * 设置组件的值
	 * @param customerID 客户ID
	 * @param hotelID 酒店ID
	 */
	public void setValue(String customerID,String hotelID) {
		//TODO:设置组件的值
	}
	
	public void setRoomType(RoomType roomType) {
		System.out.println(roomType);
		//TODO:设置组件的值
	}	
	public void setLastDate(Date lastDate) {
		//TODO:设置组件的值
	}
	public void setPlanedLeaveDate(Date planedLeaveDate) {
		//TODO:设置组件的值
	}
}
