package ui.customer;



import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

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
import javafx.scene.paint.Color;
import tools.ResultMessage;
import tools.RoomType;
import tools.TypeRoomInfo;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import ui.order.OrderPreviewController;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import ui.utils.DoubleFormate;
import ui.utils.TextFieldUtil;
import vo.CustomerVO;
import vo.HotelbriefVO;
import vo.OrderInputCalVO;
import vo.OrderInputVO;
import vo.StrategyVO;
import vo.StrategyVO_hotel;

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
	private Label hotelDiscount;
	@FXML
	private Label webDiscount;
	@FXML
	private Label originalPrice;
	@FXML
	private Label realPrice;
	@FXML
	private ComboBox<String> roomType;
	@FXML
	private JFXTextField roomNumber;
	@FXML
	private DatePicker lastDate;
	@FXML
	private JFXDatePicker lastDate_time;
	@FXML
	private DatePicker planedLeaveDate;
	@FXML
	private JFXDatePicker planedLeaveDate_time;
	@FXML
	private JFXTextField people;
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
	private void initialize() {
		TextFieldUtil.setNumberValidator(roomNumber);
		TextFieldUtil.setNumberValidator(people);
	}
	@FXML
	private void handleHotelName(){
		try {
			rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
			HotelDetailController hotelDetailController = 
					(HotelDetailController) rootLayoutController.getDetailsController();
			hotelDetailController.initValue(hotelbriefVO.hotelID);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handlePreview(){
		
		if(this.lastDate.getValue()==null || this.realPrice.getText()==null || 
					this.originalPrice.getText()==null|| lastDate_time.getTime()==null
					|| planedLeaveDate_time.getTime()==null )  return;
		
		if(getRoomType()==null)  return ;
		
		//start time deal
		LocalDate startDate = this.lastDate.getValue() ;
		LocalTime startTime = this.lastDate_time.getTime();		
		LocalDateTime lasttime = startDate.atTime
				(startTime.getHour(), startTime.getMinute(), startTime.getSecond());
		Date datestart = Date.from(lasttime.atZone(ZoneId.systemDefault()).toInstant()); 
		
		//leve time deal
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		LocalTime endTime = this.planedLeaveDate_time.getTime();
		LocalDateTime timeend = endDate.atTime
				(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
		Date dateend = Date.from(timeend.atZone(ZoneId.systemDefault()).toInstant());
		
		int planedPeopleNumber = Integer.valueOf(this.people.getText());
		double reprice = Double.valueOf(realPrice.getText());
		int numberOfRoom = Integer.valueOf(this.roomNumber.getText());
		
		OrderInputVO orderInputVO = new OrderInputVO
				(customerID, this.hotelbriefVO.hotelID, 
						new Date(), datestart, dateend,
						getRoomType(), 
						numberOfRoom,
						planedPeopleNumber, isChild(), reprice);
		
		try {
			rootLayoutController.changeDetails("../order/OrderPreview.fxml");
			OrderPreviewController orderPreviewController = (OrderPreviewController)rootLayoutController.getDetailsController();
			orderPreviewController.initVaule(orderInputVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@FXML
	private void handleConfirm(){

		if(this.lastDate.getValue()==null || this.realPrice.getText()==null || 
					this.originalPrice.getText()==null)  return;
		if(getRoomType()==null)  return ;
		
		
		LocalDate latestTimex = lastDate_time.getValue();
		
		//start time deal
		LocalDate startDate = this.lastDate.getValue() ;
		LocalTime startTime = this.lastDate_time.getTime();		
		LocalDateTime lasttime = startDate.atTime
				(startTime.getHour(), startTime.getMinute(), startTime.getSecond());
		Date datestart = Date.from(lasttime.atZone(ZoneId.systemDefault()).toInstant()); 
				
		//leve time deal
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		LocalTime endTime = this.planedLeaveDate_time.getTime();
		LocalDateTime timeend = endDate.atTime
				(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
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
		ResultMessage resultMessage = null;
		try {
			 resultMessage=orderController.createOrders(orderInputVO);
		} catch (CustomerCreditNotEnoughException e) {
			Dialogs.showMessage("你的信用值是："+e.credit,"你的信用值不足，不能下单，请联系网站促销人员进行充值");
			return;
		}
		if(resultMessage.equals(ResultMessage.Exist)){
			try {
				Dialogs.showMessage("预定成功");
				rootLayoutController.changeDetails("../order/OrderList.fxml");
				//OrderListController orderListController = (OrderListController) rootLayoutController.getDetailsController();
				//orderListController.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			Dialogs.showMessage("下单失败");
		}
		
		
		
	}
	@FXML
	private void handlePrice(){
		//:计算当前的价格，更改组件的值
		
		LocalDate startDate = this.lastDate.getValue() ;
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		
		if(startDate == null || endDate==null ) return ;
		//if(lastDate_time.getValue()==null || planedLeaveDate_time.getValue()==null) return;
		
		//简单计算天数

		int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());//@lwy 修复跨年订单计算出错
		
		StrategyController strategyController  =StrategyController.getInstance();
		List<TypeRoomInfo> typeRoomInfos  = hotelbriefVO.hotelRoom.getTypeRoomInfo();
		double singlePrice = 0;
		for (int i = 0; i < typeRoomInfos.size(); i++) {
			if(typeRoomInfos.get(i).getRoomtype()== getRoomType()){
				singlePrice = typeRoomInfos.get(i).getPrice();
				break;
			}
		}
		//number of room
		int numberofRoom=1;
		try {
			numberofRoom = Integer.valueOf(this.roomNumber.getText());
		} catch (NumberFormatException e) {
			System.out.println(this.roomNumber.getText()+" is not a number");
		}
		double OriginValue =  days * singlePrice *numberofRoom;
		
		//set origin
		this.originalPrice.setText(String.valueOf(OriginValue));
		
		//get discout info
		OrderInputCalVO orderInputCalVO  = new OrderInputCalVO
				(singlePrice, this.customerID, hotelbriefVO.hotelID, startDate, endDate, 
						LocalDate.now(), getRoomType(), numberofRoom);
		
		try {
			StrategyVO strategyVO  =strategyController.CalculateBestStrategy(orderInputCalVO);
			this.realPrice.setText(String.valueOf(DoubleFormate.formateto(strategyVO.price)));
			this.discount.setText(String.valueOf(DoubleFormate.formateto((10*strategyVO.price)/OriginValue)));
			//显示酒店折扣
			if(strategyVO.hotel!=null && !strategyVO.hotel.isEmpty()){
				String discount_hotel="";
				for(StrategyVO_hotel strategyVO_hotel:strategyVO.hotel){
					discount_hotel+=strategyVO_hotel.type.show()+":"+
							DoubleFormate.formateto(strategyVO_hotel.discount*10)+"折\r\n";
				}
				this.hotelDiscount.setText(discount_hotel);
				this.hotelDiscount.setTextFill(Color.GREEN);
			}else {
				this.hotelDiscount.setText("没有可用的酒店的折扣");
				this.hotelDiscount.setTextFill(Color.BLACK);
			}
			//显示网站折扣
			if(strategyVO.web!=null && strategyVO.web.type!=null){
				this.webDiscount.setText(strategyVO.web.type.show()+":"+
						DoubleFormate.formateto(strategyVO.web.discount*10)+"折");
				this.webDiscount.setTextFill(Color.GREEN);
			}else {
				this.webDiscount.setText("没有可用的网站的折扣");
				this.hotelDiscount.setTextFill(Color.BLACK);
			}
			
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
		if(startDate==null)  return ;
		//LocalDate latestTime = lastDate_time.getValue();
		//LocalDateTime lasttime = startDate.atTime(12, 0, 0);
		//Date datestart = Date.from(lasttime.atZone(ZoneId.systemDefault()).toInstant()); 
		
		LocalDate endDate = this.planedLeaveDate.getValue() ;
		if(endDate==null)  return ;
		//LocalDate endTime = this.planedLeaveDate_time.getValue();
		//LocalDateTime timeend = startDate.atTime(12, 0, 0);
		//Date dateend = Date.from(timeend.atZone(ZoneId.systemDefault()).toInstant());
		handlePrice();

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
			Dialogs.showMessage("啊咧", "好像网络连接断开了……");
		}
		String customerName = customerVO.customerName;
		this.customerName.setText(customerName);
		DateFormat.initDatePicker(lastDate, planedLeaveDate);
		
		//Change it oto JF field
		//TextFieldUtil.setValidator(this.roomNumber);
		
		
	}
	
	public void setRoomType(RoomType roomType) {
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

