package ui.order;

import java.io.IOException;

import com.sun.org.apache.regexp.internal.recompile;


import Exception.CustomerCreditNotEnoughException;
import businesslogic.customer.CustomerDealController;
import businesslogic.hotel.HotelDealController;
import businesslogic.order.OrderController;
import businesslogicservice.CustomerDealService;
import businesslogicservice.HotelDealService;
import businesslogicservice.OrderService;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.ResultMessage;
import ui.customer.BookHotelController;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import ui.main.RootLayoutController;
import ui.utils.DateFormat;
import ui.utils.Dialogs;
import vo.HotelbriefVO;
import vo.OrderInputVO;

/**
 * 订单预览界面的控制器
 * @author zjy
 *
 */
public class OrderPreviewController extends DetailsController{
	private static Image yellowStar=new Image("file:./target/resources/images/star__selected.png");
	private static Image greyStar=new Image("file:./target/resources/images/star_unselected.png");
	protected RootLayoutController rootLayoutController;
	@FXML
	private Hyperlink hotelName;
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
	private Hyperlink confirm;
	@FXML
	private Hyperlink cancel;
	
	private OrderInputVO orderInputVO;

	
	@FXML
	private void handleConfirm() {
		OrderService orderService=OrderController.getInstance();
		ResultMessage resultMessage = ResultMessage.NotExist;
		try {
			resultMessage=orderService.createOrders(orderInputVO);
		} catch (CustomerCreditNotEnoughException e) {
			Dialogs.showMessage("你的信用值是："+e.credit,"你的信用值不足，不能下单，请联系网站促销人员进行充值");
		}
		if(resultMessage.equals(ResultMessage.Exist)){
			//TODO:
			
			try {
				orderService.createOrders(orderInputVO);
			} catch (CustomerCreditNotEnoughException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Dialogs.showMessage("下单失败");
		}
	}
	@FXML
	private void handleCancel() {
		//TODO:返回填写订单界面

		try {
			rootLayoutController.changeDetails("../customer/BookHotel.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		BookHotelController bookHotelController=rootLayoutController.ge;
		
		

		
		try {
			rootLayoutController.changeDetails("../customer/BookHotel.fxml");
//			BookHotelController bookHotelController=(BookHotelController)rootLayoutController.getDetailsController();
//			 bookHotelController.setValue();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 初始化界面各组件的值
	 * @param orderInputVO
	 */
	public void initVaule(OrderInputVO orderInputVO) {
		HotelDealService hotelDealService=HotelDealController.getInstance();
		HotelbriefVO hotelbriefVO=hotelDealService.getHotelInfo(orderInputVO.hotelID);
		CustomerDealService customerDealService=CustomerDealController.getInstance();
		String roomTypes[]={"单人间","双人间","标准间","豪华套房","总统套房"};
		
		this.hotelName.setText(hotelbriefVO.hotelName);
		this.date_from.setText(DateFormat.format(orderInputVO.latestTime));
		this.date_to.setText(DateFormat.format(orderInputVO.planedLeaveTime));
		this.roomType.setText(roomTypes[orderInputVO.roomType.ordinal()]);
		this.roomNumber.setText(orderInputVO.numberOfRooms+"");
		this.price.setText(orderInputVO.price+"");
		this.latestDate.setText(DateFormat.format_includingTime(orderInputVO.latestTime));
		this.planedLeaveDate.setText(DateFormat.format_includingTime(orderInputVO.planedLeaveTime));
		this.people.setText(orderInputVO.planedPeopleNumber+"");
		this.children.setText(orderInputVO.child?"有":"无");
		try {
			this.customerName.setText(customerDealService.getCustomerInfo(orderInputVO.customerID).customerName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.hotelAddress.setText(hotelbriefVO.hotelAddress.toString());
		this.star_1.setImage(hotelbriefVO.star.ordinal()+1>=1? yellowStar:greyStar);
		this.star_2.setImage(hotelbriefVO.star.ordinal()+1>=2? yellowStar:greyStar);
		this.star_3.setImage(hotelbriefVO.star.ordinal()+1>=3? yellowStar:greyStar);
		this.star_4.setImage(hotelbriefVO.star.ordinal()+1>=4? yellowStar:greyStar);
		this.star_5.setImage(hotelbriefVO.star.ordinal()+1>=5? yellowStar:greyStar);
		this.orderInputVO=orderInputVO;
	}
}
