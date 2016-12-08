package ui.customer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import Exception.NoSuchValueException;
import businesslogic.customer.CustomerDealController;
import businesslogic.hotel.HotelDealController;
import businesslogicservice.HotelDealService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import tools.RoomType;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import vo.CustomerVO;
import vo.HotelbriefVO;
import vo.OrderInputVO;

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
	
	
	private static String typename[] =  {"单人间","双人间","标准间","套房","总统套房"}; 
	private static HotelbriefVO hotelbriefVO = null;
	private static String customerID = null;
	@FXML
	private void handleHotelName(){
		try {
			rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
			HotelDetailController hotelDetailController = 
					(HotelDetailController) rootLayoutController.getDetailsController();
			hotelDetailController.initValue(hotelbriefVO.hotelID);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	private void handlePreview(){
		planedLeaveDate_time.getValue();
		
//		OrderInputVO orderInputVO = new OrderInputVO
//				(customerID, this.hotelbriefVO.hotelID, 
//						this.tartTime, latestTime, planedLeaveTime, roomType, numberOfRooms, planedPeopleNumber, child, price)
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
		this.customerID = customerID;
		HotelDealService hotelDetailController = HotelDealController.getInstance();
		this.hotelbriefVO  =  hotelDetailController.getHotelInfo(hotelID);
		String hotelName = hotelbriefVO.hotelName;
		this.hotelName.setText(hotelName);
		
		CustomerDealController customerDealController = CustomerDealController.getInstance();
		CustomerVO customerVO = null;
		try {
			customerVO = customerDealController.getCustomerInfo(customerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String customerName = customerVO.customerName;
		this.customerName.setText(customerName);
		
		
	}
	
	public void setRoomType(RoomType roomType) {
		System.out.println(roomType);
		this.roomType.setValue(getRoomString(roomType));
	}	
	public void setLastDate(Date lastDate) {
		LocalDate endLocalDate = LocalDate.of(lastDate.getYear(), lastDate.getMonth(), lastDate.getDate());
		this.lastDate.setValue(endLocalDate);
	}
	public void setPlanedLeaveDate(Date planedLeaveDate) {
		LocalDate endLocalDate = LocalDate.of(planedLeaveDate.getYear(),
				planedLeaveDate.getMonth(), planedLeaveDate.getDate());
		this.lastDate.setValue(endLocalDate);
	}
	
	private RoomType getRoomType() throws NoSuchValueException{
		if(roomType.getValue()==null){
			return null;
		}
		RoomType[] types={null,RoomType.Standard,RoomType.Single,RoomType.Double,RoomType.Suites,RoomType.EluxeSuite};
		String[] texts={"所有","标准间","单人间","双人间","豪华套房","总统套房"};
		int index;
		for(index=0;index<texts.length;index++){
			if(roomType.getValue().equals(texts[index])){
				return types[index];
			}
		}
		throw new NoSuchValueException();
	}
	
	private String getRoomString(RoomType roomType) {
		RoomType[] types={RoomType.Standard,RoomType.Single,RoomType.Double,RoomType.Suites,RoomType.EluxeSuite};
		String[] texts={"标准间","单人间","双人间","豪华套房","总统套房"};
		int index;
		for(index=0;index<texts.length;index++){
			if(roomType.equals(types[index])){
				return texts[index];
			}
		}
		return "";
	}
}
