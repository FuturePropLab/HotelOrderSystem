package ui.customer;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import Exception.CustomerCreditNotEnoughException;
import businesslogic.customer.CustomerDealController;
import businesslogic.hotel.HotelDealController;
import businesslogic.order.OrderController;
import businesslogic.strategy.StrategyController;
import businesslogicservice.HotelDealService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tools.ResultMessage;
import tools.RoomType;
import tools.TypeRoomInfo;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import vo.CustomerVO;
import vo.HotelbriefVO;
import vo.OrderInputCalVO;
import vo.OrderInputVO;
import vo.StrategyVO;

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
	private HotelbriefVO hotelbriefVO = null;
	private String customerID = null;
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
		
		if(this.lastDate.getValue()==null || this.realPrice.getText()==null || 
					this.originalPrice.getText()==null)  return;
		if(getRoomType()==null)  return ;
		
		LocalDate latestTime2 = lastDate_time.getValue();
		System.out.println(latestTime2);
		
		//TODO  精确到时间有问题
		LocalDate startDate = this.lastDate.getValue() ;
		LocalDate latestTime = lastDate_time.getValue();
		LocalDateTime lasttime = startDate.atTime(12, 0, 0);
		Date datestart = Date.from(lasttime.atZone(ZoneId.systemDefault()).toInstant()); 
		
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		LocalDate endTime = this.planedLeaveDate_time.getValue();
		LocalDateTime timeend = endDate.atTime(12, 0, 0);
		Date dateend = Date.from(timeend.atZone(ZoneId.systemDefault()).toInstant());
		
		int planedPeopleNumber = Integer.valueOf(this.people.getText());
		double reprice = Double.valueOf(realPrice.getText());
		int numberOfRoom = Integer.valueOf(this.roomNumber.getText());
		
		System.out.println(customerID);
		
		OrderInputVO orderInputVO = new OrderInputVO
				(customerID, this.hotelbriefVO.hotelID, 
						new Date(), datestart, dateend,
						getRoomType(), 
						numberOfRoom,
						planedPeopleNumber, isChild(), reprice);
		
		try {
			
			//TODO ????????
			rootLayoutController.changeDetails("../order/OrderPreview.fxml");
			//OrderPreviewController orderPreviewController = (OrderPreviewController)rootLayoutController.getDetailsController();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@FXML
	private void handleConfirm(){
		//TODO:调用blservice下单

		if(this.lastDate.getValue()==null || this.realPrice.getText()==null || 
					this.originalPrice.getText()==null)  return;
		if(getRoomType()==null)  return ;
		
		
		LocalDate latestTimex = lastDate_time.getValue();
		//System.out.println(latestTimex.toString());
		
		//TODO  精确到时间有问题
		LocalDate startDate = this.lastDate.getValue() ;
		LocalDate latestTime = lastDate_time.getValue();
		LocalDateTime lasttime = startDate.atTime(12, 0, 0);
		Date datestart = Date.from(lasttime.atZone(ZoneId.systemDefault()).toInstant()); 
		
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		LocalDate endTime = this.planedLeaveDate_time.getValue();
		LocalDateTime timeend = endDate.atTime(12, 0, 0);
		Date dateend = Date.from(timeend.atZone(ZoneId.systemDefault()).toInstant());
		
		int planedPeopleNumber = Integer.valueOf(this.people.getText());
		double reprice = Double.valueOf(realPrice.getText());
		int numberOfRoom = Integer.valueOf(this.roomNumber.getText());
		
		OrderInputVO orderInputVO = new OrderInputVO
				(customerID, this.hotelbriefVO.hotelID, 
						new Date(), datestart, dateend,
						getRoomType(), 
						numberOfRoom,
						planedPeopleNumber, this.children.isSelected(), reprice);
		
		OrderController orderController  = OrderController.getInstance();
		try {
			ResultMessage resultMessage  = orderController.createOrders(orderInputVO);
			if(resultMessage== ResultMessage.Exist){
				// 提示客户成
				System.out.println("success");
			}
		} catch (CustomerCreditNotEnoughException e) {
			//提示客户信用不足
			System.out.println("not good credit");
		}
		
		
		
	}
	@FXML
	private void handlePrice(){
		//:计算当前的价格，更改组件的值
		LocalDate startDate = this.lastDate.getValue() ;
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		
		
		//简单计算天数
		int days = endDate.getDayOfYear() - startDate.getDayOfYear();
		System.out.println(days);
		System.out.println(days);
		if(days < 0 )  days+= startDate.isLeapYear()? 1:0;
		
		if(days == 0)  days = 1;
		
		StrategyController strategyController  =StrategyController.getInstance();
		List<TypeRoomInfo> typeRoomInfos  = hotelbriefVO.hotelRoom.getTypeRoomInfo();
		double singlePrince = 0;
		for (int i = 0; i < typeRoomInfos.size(); i++) {
			if(typeRoomInfos.get(i).getRoomtype()== getRoomType()){
				singlePrince = typeRoomInfos.get(i).getPrice();
				break;
			}
		}
		//number of room
		int numberofRoom = Integer.valueOf(this.roomNumber.getText());
		double OriginValue =  days * singlePrince *numberofRoom;
		
		//set origin
		this.originalPrice.setText(String.valueOf(OriginValue));
		
		OrderInputCalVO orderInputCalVO  = new OrderInputCalVO
				(OriginValue, this.customerID, hotelbriefVO.hotelID, startDate, endDate, 
						LocalDate.now(), getRoomType(), Integer.valueOf(this.roomNumber.getText()));
		
		try {
			StrategyVO strategyVO  =strategyController.CalculateBestStrategy(orderInputCalVO);
			this.realPrice.setText(String.valueOf(strategyVO.price));
			this.discount.setText(String.valueOf((10*strategyVO.price)/OriginValue));
		} catch (RemoteException e) {
			System.out.println("rmi fail");
			this.realPrice.setText(String.valueOf(OriginValue));
			this.discount.setText("10.0");
		}
		
		
	}
	
	
	
	@FXML
	private void handleDate(){
		if(getRoomType() == null)
			return ;
		
		LocalDate startDate = this.lastDate.getValue() ;
		
		//TODO
		if(startDate==null)  return ;
		LocalDate latestTime = lastDate_time.getValue();
		LocalDateTime lasttime = startDate.atTime(12, 0, 0);
		Date datestart = Date.from(lasttime.atZone(ZoneId.systemDefault()).toInstant()); 
		
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		if(endDate==null)  return ;
		LocalDate endTime = this.planedLeaveDate_time.getValue();
		LocalDateTime timeend = startDate.atTime(12, 0, 0);
		Date dateend = Date.from(timeend.atZone(ZoneId.systemDefault()).toInstant());
		if(dateend.before(datestart)){
			//提示客户不行！！！！
			return ;
		}else{
			handlePrice();
		}
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
		this.roomType.getItems().clear();
		List<TypeRoomInfo>  typeRoomInfos = hotelbriefVO.hotelRoom.getTypeRoomInfo();
		if(typeRoomInfos!=null){
			for (int i = 0; i < typeRoomInfos.size(); i++) {
				TypeRoomInfo typeRoomInfo = typeRoomInfos.get(i);
				if(typeRoomInfo.getPrice()!=0){
					this.roomType.getItems().add(getRoomString(typeRoomInfo.getRoomtype()));
				}
			}
		}
		
		CustomerDealController customerDealController = CustomerDealController.getInstance();
		CustomerVO customerVO = null;
		try {
			customerVO = customerDealController.getCustomerInfo(customerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String customerName = customerVO.customerName;
		System.out.println("customerName:   "+customerName);
		this.customerName.setText(customerName);
		
		
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType.getItems().clear();
		System.out.println(roomType);
		this.roomType.setValue(getRoomString(roomType));
	}		
	public void setLastDate(Date lastDate) {
		LocalDate endLocalDate = LocalDate.of(lastDate.getYear(), lastDate.getMonth(), lastDate.getDate());
		this.lastDate.setValue(endLocalDate);
	}
	public void setLastDate(LocalDate lastDate) {
		this.lastDate.setValue(lastDate);
	}	
	public void setPlanedLeaveDate(Date planedLeaveDate) {
		LocalDate endLocalDate = LocalDate.of(planedLeaveDate.getYear(),
				planedLeaveDate.getMonth(), planedLeaveDate.getDate());
		this.lastDate.setValue(endLocalDate);
	}
	public void setPlanedLeaveDate(LocalDate planedLeaveDate) {
		this.planedLeaveDate.setValue(planedLeaveDate);
	}	
	
	private RoomType getRoomType() {
		if(roomType.getValue()==null){
			return null;
		}
		RoomType[] types={RoomType.Standard,RoomType.Single,RoomType.Double,RoomType.Suites,RoomType.EluxeSuite};
		String[] texts={"标准间","单人间","双人间","豪华套房","总统套房"};
		int index;
		for(index=0;index<texts.length;index++){
			if(roomType.getValue().equals(texts[index])){
				return types[index];
			}
		}
		return null;
		//throw new NoSuchValueException();
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
	
	private boolean  isChild(){
		String str = this.children.getText();
		if(str!= null  && "是".equals(str))   return true;
		else return false;
	}
}
