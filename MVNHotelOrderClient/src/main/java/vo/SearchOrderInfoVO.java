package vo;

import java.sql.Time;
import tools.OrderState;
/**
 * 搜索订单信息
 * @author zjy
 *
 */
public class SearchOrderInfoVO {
	public String orderID;
	public String customerID;
	public String hotelID;
	public Time startTime;//未定time用什么类
	public OrderState orderState;
	
	public SearchOrderInfoVO(String orderID, String customerID, String hotelID, Time startTime, OrderState orderState) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.hotelID = hotelID;
		this.startTime = startTime;
		this.orderState = orderState;
	}
}
