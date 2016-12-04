package vo;

import java.util.Date;

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
	public String customerName;
	public String hotelName;
	public Date date;
	public OrderState orderState;
	
	/**
	 * 如果某项搜索条件不限，则该项为null
	 * @param orderID 订单ID
	 * @param customerID 客户ID
	 * @param hotelID 酒店ID
	 * @param customerName 客户姓名
	 * @param hotelName 酒店名称
	 * @param date 日期
	 * @param orderState 订单状态
	 */
	public SearchOrderInfoVO(String orderID, String customerID, String hotelID, String customerName, String hotelName,
			Date date, OrderState orderState) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.hotelID = hotelID;
		this.customerName = customerName;
		this.hotelName = hotelName;
		this.date = date;
		this.orderState = orderState;
	}
}
