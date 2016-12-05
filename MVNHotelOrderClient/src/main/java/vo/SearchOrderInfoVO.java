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
	public String ID;
	public String customerName;
	public String hotelName;
	public Date date;
	public OrderState orderState;
	
	/**
	 * 如果某项搜索条件不限，则该项为null
	 * @param orderID 订单ID
	 * @param ID 客户ID或酒店ID
	 * @param customerName 客户姓名
	 * @param hotelName 酒店名称
	 * @param date 日期
	 * @param orderState 订单状态
	 */
	public SearchOrderInfoVO(String orderID, String ID, String customerName, String hotelName,
			Date date, OrderState orderState) {
		super();
		this.orderID = orderID;
		this.ID=ID;
		this.customerName = customerName;
		this.hotelName = hotelName;
		this.date = date;
		this.orderState = orderState;
	}
}
