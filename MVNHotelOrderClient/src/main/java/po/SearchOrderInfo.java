package po;

import java.sql.Time;
import java.util.Date;

import tools.OrderState;

/**
 * 搜索订单的条件
 * @author zjy
 *
 */
public class SearchOrderInfo {
	public String accountID;
	public String orderID;
	public String customerName;
	public String hotelName;
	public Date startTime;//介于最晚到店时间和预计离开时间中的某一天
	public OrderState orderState;
	
	/**
	 * 如果某项搜索条件不限，则该项为null
	 * @param accountID 发起搜索的账户ID,如果是客户就是客户ID，如果是酒店工作人员就是酒店工作人员ID，以此类推
	 * @param orderID 订单ID
	 * @param customerName 客户姓名
	 * @param hotelName 酒店名称
	 * @param startTime 介于最晚到店时间和预计离开时间中的某一天
	 * @param orderState 订单状态
	 */
	public SearchOrderInfo(String accountID,String orderID, String customerName, String hotelName, 
			Date startTime, OrderState orderState) {
		super();
		this.accountID=accountID;
		this.orderID = orderID;
		this.customerName = customerName;
		this.hotelName = hotelName;
		this.startTime = startTime;
		this.orderState = orderState;
	}
}
