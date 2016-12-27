package ui.order;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogic.account.CustomerAccountController;
import businesslogic.hotel.HotelDealController;
import businesslogic.login.LoginController;
import businesslogic.login.State;
import businesslogic.order.OrderController;
import businesslogicservice.AccountCustomerService;
import businesslogicservice.AccountService;
import businesslogicservice.HotelDealService;
import businesslogicservice.LoginService;
import businesslogicservice.OrderService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import tools.AccountType;
import tools.HotelAddress;
import tools.OrderState;
import tools.RoomType;
import ui.customer.BookHotelController;
import ui.hotel.HotelDetailController;
import ui.main.DetailsController;
import ui.utils.DateFormat;
import vo.FuzzySearchOrderVO;
import vo.HotelbriefVO;
import vo.LogVO;
import vo.OrderVO;
import vo.SearchHotelVO;
import vo.SearchOrderInfoVO;

/**
 * 订单列表的控制器
 * 
 * @author zjy
 *
 */
public class OrderListController extends DetailsController {

	@FXML
	private TextField keyWords;
	@FXML
	private Button search;
	@FXML
	private DatePicker date;
	@FXML
	private CheckBox unexecuted;
	@FXML
	private CheckBox executed;
	@FXML
	private CheckBox exception;
	@FXML
	private CheckBox revoked;
	@FXML
	private FlowPane orderList;
	@FXML
	private StackPane spinnerPane;
	
	@FXML
	private void initialize() {
		handleSearch();
	}

	@FXML
	private void handleSearch() {
		this.orderList.getChildren().clear();
		
		HotelDealService hotelDealService = HotelDealController.getInstance();
		
		spinnerPane.setVisible(true);
		SearchService searchService =new SearchService();
		searchService.setOnSucceeded(e->{
			spinnerPane.setVisible(false);
			
			if (searchService.orderVOs != null) {
				for (OrderVO orderVO : searchService.orderVOs) {
					OrderItemController orderItemController = addItem();
					HotelbriefVO hotelbriefVO = hotelDealService.getHotelInfo(orderVO.hotelID);
					Image hotelImage = new Image(hotelbriefVO.imageuri.toString());
					String hotelName = hotelbriefVO.hotelName;
					HotelAddress hotelAddress = hotelbriefVO.hotelAddress;
					orderItemController.setValue(hotelImage, hotelName, hotelAddress, orderVO.latestTime,
							orderVO.planedLeaveTime, orderVO.roomType, orderVO.roomNumber.size(), orderVO.price,
							orderVO.orderState, orderVO.orderID, orderVO.hotelID);
				}
			}else {
				Label label=new Label("没有订单");
				label.setFont(Font.font(24));
				this.orderList.getChildren().addAll(label);
				return;
			}
		});
		searchService.start();
	}

	private Date getDate() {
		if (date.getValue() == null) {
			return null;
		}
		return new Date(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth());
	}

	private OrderItemController addItem() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("OrderItem.fxml"));
			AnchorPane orderItem = (AnchorPane) loader.load();
			orderList.getChildren().addAll(orderItem);
			OrderItemController orderItemController = loader.getController();
			orderItemController.setOrderListController(this);
			return orderItemController;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 跳转到订单相关的酒店详情界面
	 * 
	 * @param hotelID
	 *            酒店ID
	 */
	public void toHotelDetailView(String hotelID) {
		try {
			rootLayoutController.changeDetails("../hotel/HotelDetail.fxml");
			HotelDetailController hotelDetailController = (HotelDetailController) rootLayoutController
					.getDetailsController();
			hotelDetailController.initValue(hotelID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转到订单详情界面
	 * 
	 * @param orderID
	 *            订单ID
	 */
	public void toOrderDetailView(String orderID) {
		try {
			rootLayoutController.changeDetails("../order/OrderDetails.fxml");
			OrderDetailsController orderDetailsController = (OrderDetailsController) rootLayoutController
					.getDetailsController();
			orderDetailsController.initValue(orderID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发起搜索，如果某项是null，则该项条件不限
	 * @param keyWords 关键词
	 * @param date 日期
	 */
	public void search(String keyWords,LocalDate date) {
		this.keyWords.setText(keyWords);
		this.date.setValue(date);
		handleSearch();
	}
	
	
	/**
	 * 搜索订单的后台线程
	 * @author zjy
	 *
	 */
	private class SearchService extends Service<Void> {
		private List<OrderVO> orderVOs = new ArrayList<OrderVO>();
		@Override
		protected Task<Void> createTask() {
			return new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					try {
						OrderService orderService = OrderController.getInstance();
						LoginService loginService = LoginController.getInstance();

						LogVO logVO = loginService.getLogState();
						if (logVO.state.equals(businesslogic.login.State.logout)) {
							System.err.println("can't handleSearch: the login state is logout!");
							return null;
						}
						
						String tempHotelID = null;
						String tempcustomerID = null;
						if(logVO.accountType==AccountType.Customer){
							tempcustomerID = logVO.accountID;
						}else if(logVO.accountType==AccountType.Hotel){
							tempHotelID = logVO.accountID;;
						}
						
						String keywordinput = "".equals(keyWords.getText()) ? null : keyWords.getText();
						LocalDate localdate = OrderListController.this.date.getValue();
						Date date = null;
						if(localdate!=null){
							date = DateFormat.getDate(OrderListController.this.date);
						}
						
						orderVOs = orderService.CheckOrderList
								(new FuzzySearchOrderVO(tempHotelID, tempcustomerID, date, keywordinput,
										unexecuted.isSelected(), executed.isSelected(),
										revoked.isSelected(), exception.isSelected()));
						
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			};
		}
	}
}
