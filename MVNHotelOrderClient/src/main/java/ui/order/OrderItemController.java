package ui.order;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tools.HotelAddress;
import tools.OrderState;
import tools.RoomType;

/**
 * 订单列表项的控制器
 * @author zjy
 *
 */
public class OrderItemController {

	@FXML
	private ImageView hotelImage;
	@FXML
	private Hyperlink hotelName;
	@FXML
	private Label hotelAddress;
	@FXML
	private Label date_from;//预计入住时间
	@FXML
	private Label date_to;//预计退房时间
	@FXML
	private Label roomType;
	@FXML
	private Label roomNumber;
	@FXML
	private Label price;//订单总价
	@FXML
	private Label orderState;
	@FXML
	private Hyperlink detail;
	private String orderID;
	private OrderListController orderListController;
	
	@FXML
	private void handleDetail(){
		//TODO:跳转到订单详情界面
	}
	@FXML
	private void handleHotelName(){
		//TODO:跳转到酒店详情界面
	}
	
	
	public void setOrderListController(OrderListController orderListController) {
		this.orderListController = orderListController;
	}
	
	/**
	 * 
	 * @param hotelImage 酒店图片
	 * @param hotelName	酒店名称
	 * @param hotelAddress 酒店详细地址
	 * @param date_from 预计入住时间
	 * @param date_to 预计退房时间（下单时的）
	 * @param roomType 房间类型
	 * @param roomNumber 房间数量
	 * @param price 价格
	 * @param orderState 订单状态
	 * @param orderID 订单ID
	 */
	public void setValue(Image hotelImage,String hotelName,HotelAddress hotelAddress,Date date_from,Date date_to,
			RoomType roomType,int roomNumber,double price,OrderState orderState,String orderID) {
		
	}
}
