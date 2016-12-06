package ui.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import businesslogic.customer.CustomerDealController;
import businesslogic.hotel.HotelDealController;
import businesslogic.login.LoginController;
import businesslogic.order.OrderController;
import businesslogicservice.CustomerDealService;
import businesslogicservice.HotelDealService;
import businesslogicservice.LoginService;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.AccountType;
import tools.DateFormat;
import tools.HotelAddress;
import tools.Mark;
import tools.OrderState;
import tools.ResultMessage;
import tools.RoomType;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import vo.CustomerVO;
import vo.HotelbriefVO;
import vo.OrderVO;
/**
 * 订单详情的控制器
 * @author zjy
 *
 */
public class OrderDetailsController extends DetailsController{
	private static Image yellowStar=new Image("file:./target/resources/images/star__selected.png");
	private static Image greyStar=new Image("file:./target/resources/images/star_unselected.png");

	@FXML
	private Hyperlink hotelName;
	@FXML
	private Label orderState;
	@FXML
	private Label orderID;
	@FXML
	private Label placingOrderDate;
	@FXML
	private Label date_from;
	@FXML
	private Label date_to;
	@FXML
	private Label roomType;
	@FXML
	private Label roomNumber;//房间数量
	@FXML
	private Label price;
	@FXML
	private Label latestDate;
	@FXML
	private Label planedLeaveDate;
	@FXML
	private Label people;//预计入住人数
	@FXML
	private Label children;//有无儿童
	@FXML
	private Label customerName;
	@FXML
	private Label hotelAddress;
	@FXML
	private Label contactInformation;
	@FXML
	private Label roomNumbers;//房间号码
	@FXML
	private Label checkInDate;
	@FXML
	private Label planedCheckOutDate;//这个是入住信息里的那个时间
	@FXML
	private Label checkOutDate;
	@FXML
	private Label mark;
	@FXML
	private ImageView star_1;
	@FXML
	private ImageView star_2;
	@FXML
	private ImageView star_3;
	@FXML
	private ImageView star_4;
	@FXML
	private ImageView star_5;
	@FXML
	private Label assess;
	@FXML
	private Hyperlink revoke;
	private String hotelID;
	
	
	@FXML
	private void handleHotelName(){
		try {
			rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
			HotelDetailController hotelDetailController=(HotelDetailController)rootLayoutController.getDetailsController();
			hotelDetailController.initValue(hotelID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleRevoke(){
		//TODO:调用blservice撤销订单
		OrderService orderService=OrderController.getInstance();
		OrderVO orderVO=orderService.checkSingleOrder(orderID.getText());
		ResultMessage resultMessage = orderService.revokeCurrentOrder(orderVO);
		
		
		
	}
	
	/**
	 * 初始化各组件的值
	 * @param orderID 订单ID
	 */
	public void initValue(String orderID){
		OrderService orderService=OrderController.getInstance();
		OrderVO orderVO=orderService.checkSingleOrder(orderID);
		HotelDealService hotelDealService=HotelDealController.getInstance();
		HotelbriefVO hotelbriefVO=hotelDealService.getHotelInfo(orderVO.hotelID);
		CustomerDealService customerDealService=CustomerDealController.getInstance();
		CustomerVO customerVO = null;
		try {
			customerVO = customerDealService.getCustomerInfo(orderVO.customerID);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CustomerVO is null!");
		}
		LoginService loginService=LoginController.getInstance();
		
		String orderStates[]={"未入住","已入住","异常订单","已撤销"};
		String roomTypes[]={"单人间","双人间","标准间","豪华套房","总统套房"};
		
		this.hotelName.setText(hotelbriefVO.hotelName);
		this.orderState.setText(orderStates[orderVO.orderState.ordinal()]);
		this.orderID.setText(orderVO.orderID);
		this.placingOrderDate.setText(DateFormat.format(orderVO.startTime));
		this.date_from.setText(DateFormat.format(orderVO.latestTime));
		this.date_to.setText(DateFormat.format(orderVO.planedLeaveTime));
		this.roomType.setText(roomTypes[orderVO.roomType.ordinal()]);
		this.roomNumber.setText(orderVO.roomNumber.size()+"");
		this.price.setText(orderVO.price+"");
		this.latestDate.setText(DateFormat.format_includingTime(orderVO.latestTime));
		this.planedLeaveDate.setText(DateFormat.format_includingTime(orderVO.planedLeaveTime));
		this.people.setText(people+"");
		this.children.setText(orderVO.child?"有":"无");
		this.customerName.setText(customerVO.customerName);
		this.hotelAddress.setText(hotelbriefVO.hotelAddress.toString());
		this.contactInformation.setText("contactInformation");//TODO
		String roomNumbers="";
		for(String string:orderVO.roomNumber){
			roomNumbers=roomNumbers+string+" ";
		}
		this.roomNumbers.setText(roomNumbers);
		this.checkInDate.setText(DateFormat.format_includingTime(orderVO.checkInTime));
		this.planedCheckOutDate.setText(DateFormat.format_includingTime(orderVO.planedCheckOutTime));
		this.checkOutDate.setText(DateFormat.format_includingTime(orderVO.checkInTime));
		this.mark.setText(orderVO.mark.getValue()+"");
		this.star_1.setImage(orderVO.mark.getValue()>=1? yellowStar:greyStar);
		this.star_2.setImage(orderVO.mark.getValue()>=2? yellowStar:greyStar);
		this.star_3.setImage(orderVO.mark.getValue()>=3? yellowStar:greyStar);
		this.star_4.setImage(orderVO.mark.getValue()>=4? yellowStar:greyStar);
		this.star_5.setImage(orderVO.mark.getValue()>=5? yellowStar:greyStar);
		this.assess.setText(orderVO.assessment);
		
		if(loginService.getLogState().accountType.equals(AccountType.Customer) && 
				orderVO.orderState.equals(OrderState.Unexecuted)){
			revoke.setVisible(true);
		}
		this.hotelID=orderVO.hotelID;
	}
}
