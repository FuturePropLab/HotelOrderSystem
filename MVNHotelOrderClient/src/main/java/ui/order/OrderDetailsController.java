package ui.order;

import java.io.IOException;
import java.util.List;

import businesslogic.customer.CustomerDealController;
import businesslogic.hotel.HotelDealController;
import businesslogic.login.LoginController;
import businesslogic.order.OrderController;
import businesslogicservice.CustomerDealService;
import businesslogicservice.HotelDealService;
import businesslogicservice.LoginService;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.AccountType;
import tools.OrderState;
import tools.RecoverValue;
import tools.ResultMessage;
import ui.customer.OrderAssessController;
import ui.hotel.HotelDetailController;
import ui.hotelworker.CheckInAndOutInfoController;
import ui.main.DetailsController;
import ui.utils.Choice;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import ui.utils.DoubleFormate;
import vo.CustomerVO;
import vo.HotelDetailsVO;
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
	private Label customerContactInfo;
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
	private Group checkInInfo;//如果入住了就设为可见，否则不可见
	@FXML
	private Hyperlink checkIn;//如果入住了就设为不可见，否则可见，只有酒店工作人员可见
	@FXML
	private Group checkOutInfo;//如果退房不就设为可见，否则不可见
	@FXML
	private Hyperlink checkOut;//如果退房了就设为不可见，否则可见，只有酒店工作人员可见
	@FXML
	private Group assessInfo;//如果评价了就设为可见，否则不可见
	@FXML
	private Hyperlink goTOAssess;//如果评价了就设为不可见，否则可见，只有客户可见
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
		String orderID=this.orderID.getText();
		
		OrderService orderService=OrderController.getInstance();
		OrderVO orderVO=orderService.checkSingleOrder(orderID);
		LoginService loginService=LoginController.getInstance();
		//如果是客户，则提示撤销结果，如果是网站促销人员，提示选择恢复全部信用值或一半，选择后调用blservice
		if(AccountType.Customer.equals(loginService.getLogState().accountType)){
			int lose=orderService.calculateCreditLose(orderID);
			Dialogs.showChoise("现在撤销订单的话，你将会被扣除"+lose+"点信用值，确定要继续吗？", 
					new Choice("我已经想好了",e->{
						ResultMessage result = orderService.revokeCurrentOrder(orderVO);
						if(ResultMessage.Exist.equals(result)){
							Dialogs.showMessage("嗯呐", "撤销订单成功");
							try {
								rootLayoutController.changeDetails("../order/OrderDetails.fxml");
								OrderDetailsController orderDetailsController=(OrderDetailsController) 
										rootLayoutController.getDetailsController();
								orderDetailsController.initValue(orderID);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}else {
							Dialogs.showMessage("啊咧", "居然撤销订单失败了_(:з」∠)_");
						}
					}),
					new Choice("还是不了", e->{}));
		}else if (AccountType.Web.equals(loginService.getLogState().accountType)) {
			Dialogs.showChoise("要给客户恢复被扣除的全部信用值还是一半？", new Choice("全部",e->{
				orderService.revokeBadOrderr(orderID, RecoverValue.RecoverAll);
			}),new Choice("一半",e->{
				orderService.revokeBadOrderr(orderID, RecoverValue.RecoverHalf);
			}));
		}else {
			System.err.println(loginService.getLogState().accountType.toString()+" can not revoke an order.");
		}
		
	}
	@FXML
	private void handleCheckIn(){
		try {
			rootLayoutController.changeDetails("../hotelworker/CheckInAndOutInfo.fxml");
			CheckInAndOutInfoController checkInAndOutInfoController = (CheckInAndOutInfoController)
					rootLayoutController.getDetailsController();
			checkInAndOutInfoController.initValue(orderID.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleCheckOut(){ 
		try {
			rootLayoutController.changeDetails("../hotelworker/CheckInAndOutInfo.fxml");
			CheckInAndOutInfoController checkInAndOutInfoController = (CheckInAndOutInfoController)
					rootLayoutController.getDetailsController();
			checkInAndOutInfoController.initValue(orderID.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleGoTOAssess(){
		try {
			rootLayoutController.changeDetails("../customer/OrderAssess.fxml");
			OrderAssessController orderAssessController=(OrderAssessController)rootLayoutController.getDetailsController();
			orderAssessController.initValue(orderID.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 初始化各组件的值
	 * @param orderID 订单ID
	 */
	public void initValue(String orderID){
		OrderService orderService=OrderController.getInstance();
		OrderVO orderVO=orderService.checkSingleOrder(orderID);
		HotelDealService hotelDealService=HotelDealController.getInstance();
		//HotelbriefVO hotelbriefVO=hotelDealService.getHotelInfo(orderVO.hotelID);
		HotelDetailsVO hotelDetailsVO = hotelDealService.getHotelDetailsVO(orderVO.hotelID);
		CustomerDealService customerDealService=CustomerDealController.getInstance();
		CustomerVO customerVO = null;
		try {
			customerVO = customerDealService.getCustomerInfo(orderVO.customerID);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("CustomerVO is null!");
		}
		LoginService loginService=LoginController.getInstance();
		
		String orderStates[]={"未入住","已入住","异常订单","已撤销"};
		String roomTypes[]={"单人间","双人间","标准间","豪华套房","总统套房"};
		
		this.hotelName.setText(hotelDetailsVO.hotelName);
		this.orderState.setText(orderStates[orderVO.orderState.ordinal()]);
		this.orderState.setTextFill(orderVO.orderState.getColor());
		this.orderID.setText(orderVO.orderID);
		this.placingOrderDate.setText(DateFormat.format(orderVO.startTime));
		this.date_from.setText(DateFormat.format(orderVO.latestTime));
		this.date_to.setText(DateFormat.format(orderVO.planedLeaveTime));
		this.roomType.setText(roomTypes[orderVO.roomType.ordinal()]);
		this.roomNumber.setText(orderVO.roomNumber.size()+"");
		this.price.setText(DoubleFormate.formateto(orderVO.price)+"");
		this.latestDate.setText(DateFormat.format_includingTime(orderVO.latestTime));
		this.planedLeaveDate.setText(DateFormat.format_includingTime(orderVO.planedLeaveTime));
		this.people.setText(orderVO.planedPeopleNumber+"");
		this.children.setText(orderVO.child?"有":"无");
		this.customerName.setText(customerVO.customerName);
		this.hotelAddress.setText(hotelDetailsVO.hotelAddress.toString());
		this.customerContactInfo.setText(customerVO.telephone);
		List<String>  strlist = hotelDetailsVO.hotelDiscribtionsVO.discribes;
		if(strlist!=null && !strlist.isEmpty())
		this.contactInformation.setText(hotelDetailsVO.hotelDiscribtionsVO.discribes.get(0));
		else 
		this.contactInformation.setText("请拨打服务热线 999999");
		
		if(orderVO.checkInTime==null){
			this.checkInInfo.setVisible(false);
			if(AccountType.Hotel.equals(loginService.getLogState().accountType)){
				this.checkIn.setVisible(true);
			}else {
				this.checkIn.setVisible(false);
			}
			this.checkOutInfo.setVisible(false);
			this.assessInfo.setVisible(false);
		}else{
			this.checkInInfo.setVisible(true);
			String roomNumbers="";
			for(String string:orderVO.roomNumber){
				roomNumbers=roomNumbers+string+" ";
			}
			this.roomNumbers.setText(roomNumbers);
			this.checkInDate.setText(DateFormat.format_includingTime(orderVO.checkInTime));
			this.planedCheckOutDate.setText(DateFormat.format_includingTime(orderVO.planedCheckOutTime));
			this.checkIn.setVisible(false);
			
			if(orderVO.checkOutTime==null){
				this.checkOutInfo.setVisible(false);
				if(AccountType.Hotel.equals(loginService.getLogState().accountType)){
					this.checkOut.setVisible(true);
				}else {
					this.checkOut.setVisible(false);
				}
				this.assessInfo.setVisible(false);
			}else {
				this.checkOutInfo.setVisible(true);
				this.checkOutDate.setText(DateFormat.format_includingTime(orderVO.checkInTime));
				this.checkOut.setVisible(false);
				if(orderVO.assessment==null||"".equals(orderVO.assessment.trim())){
					this.assessInfo.setVisible(false);
					if(AccountType.Customer.equals(loginService.getLogState().accountType)){
						this.goTOAssess.setVisible(true);
					}
				}else {
					this.assessInfo.setVisible(true);
					this.goTOAssess.setVisible(false);
					this.mark.setText(orderVO.mark.getValue()+"");
					this.star_1.setImage(orderVO.mark.getValue()>=1? yellowStar:greyStar);
					this.star_2.setImage(orderVO.mark.getValue()>=2? yellowStar:greyStar);
					this.star_3.setImage(orderVO.mark.getValue()>=3? yellowStar:greyStar);
					this.star_4.setImage(orderVO.mark.getValue()>=4? yellowStar:greyStar);
					this.star_5.setImage(orderVO.mark.getValue()>=5? yellowStar:greyStar);
					this.assess.setText(orderVO.assessment);
				}
			}
		}
		
		if((loginService.getLogState().accountType.equals(AccountType.Customer) && 
				orderVO.orderState.equals(OrderState.Unexecuted)) || 
				(loginService.getLogState().accountType.equals(AccountType.Web) && 
						orderVO.orderState.equals(OrderState.Exception))){
			revoke.setVisible(true);
		}
		this.hotelID=orderVO.hotelID;
	}
}
