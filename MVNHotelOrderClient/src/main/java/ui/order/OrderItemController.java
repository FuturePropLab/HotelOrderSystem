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
import ui.utils.DoubleFormate;

/**
 * 订单列表项的控制器
 * @author zjy
 *
 */
public class OrderItemController {
	private static String[] roomTypes={"单人间","双人间","标准间","豪华套房","总统套房"};
	private static String[] orderStates={"未入住","已入住","异常订单","已撤销"};

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
	private String hotelID;
	private OrderListController orderListController;
	
	@FXML
	private void handleDetail(){
		orderListController.toOrderDetailView(orderID);
	}
	@FXML
	private void handleHotelName(){
		orderListController.toHotelDetailView(hotelID);
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
	 * @param hotelID 酒店ID
	 */
	public void setValue(Image hotelImage,String hotelName,HotelAddress hotelAddress,Date date_from,Date date_to,
			RoomType roomType,int roomNumber,double price,OrderState orderState,String orderID,String hotelID) {
		this.hotelImage.setImage(hotelImage);
		this.hotelName.setText(hotelName);
		this.hotelAddress.setText(hotelAddress.getAddressDetail());
		this.date_from.setText((1900+date_from.getYear())+"-"+(1+date_from.getMonth())+"-"+date_from.getDate());
		this.date_to.setText((1900+date_to.getYear())+"-"+(1+date_to.getMonth())+"-"+date_to.getDate());
		this.roomType.setText(roomTypes[roomType.ordinal()]);
		this.roomNumber.setText(roomNumber+"");
		this.price.setText(DoubleFormate.formateto(price));
		this.orderState.setText(orderStates[orderState.ordinal()]);
		this.orderID=orderID;
		this.hotelID=hotelID;
	}
}
