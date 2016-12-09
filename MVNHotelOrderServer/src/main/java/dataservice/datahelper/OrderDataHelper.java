package dataservice.datahelper;

import java.util.Date;
import java.util.List;

import po.OrderAssessPO;
import po.OrderNotChangePO;
import po.OrderPO;
import po.OrderSearchStorePO;
import po.SearchOrderInfo;
import tools.OrderState;
import tools.ResultMessage;
import tools.RoomType;

public interface OrderDataHelper {
	
	/**
	 * 
	 * @param orderSearchStorePO
	 * @return
	 */
	public ResultMessage addOrderSearchStorePO(OrderSearchStorePO orderSearchStorePO);
	
	
	public ResultMessage addOrderNotChangePO(OrderNotChangePO orderNotChangePO);
	
	
	public ResultMessage addOrderAssessPO(OrderAssessPO orderAssessPO);
	
	
	public ResultMessage addOrderRoomPO(String OrderID , List<String> rommNumberList);
	
	
	public ResultMessage addCompleteOrderPO(OrderPO orderPO);
	
	
	public List<String> getArrangeRoom(String hotelID, RoomType roomType, int count, Date begin , Date end);
	
	
	
	/**
	 * 
	 * @param OrderID
	 * @return
	 */
	public OrderSearchStorePO getOrderSearchStorePO(String OrderID);
	
	
	public OrderNotChangePO getOrderNotChangePO(String OrderID);
	
	
	public OrderAssessPO getOrderAssessPO(String OrderID);
	
	
	public List<String> getOrderRoomPO(String OrderID);
	
	/**
	 * 通过完整的  orderid  获得完整的order信息
	 * @param orderID
	 * @return
	 */
	public OrderPO getCompleteOrderPO(String orderID);
	
	
	public ResultMessage modifyOrderSearchPO(OrderSearchStorePO orderSearchStorePO);
	
	public ResultMessage modifyOrderAssessPO(OrderAssessPO orderAssessPO);
	
	public ResultMessage changeOrderState(String orderID , OrderState orderState);
	
	
	/**
	 * 通过查找 专门为搜索订单准备的子数据库  获取搜索用信息
	 * @param orderState
	 * @param hotelID
	 * @param customerID
	 * @return
	 */
	public List<OrderSearchStorePO>  getOrderListBycondition(OrderState orderState , String hotelID , String customerID);
	
	/**
	 * 判断客户名字的模糊查找
	 * @param customerpattern
	 * @param customerID
	 * @return
	 */
	public boolean  isValidCustomerName (String customerpattern , String customerID);
	
	/**
	 * 判断酒店名字的酒店查找
	 * @param hotelpattern
	 * @param hotelID
	 * @return
	 */
	public boolean  isValidHotelName (String hotelpattern , String hotelID);
	
	
	/**
	 * 判断时间是否符合搜索的标准
	 * @param orderID
	 * @param date
	 * @return
	 */
	public boolean  isValidTime(String orderID , Date date);
	
	/**
	 * get all comment
	 * @param hotelID
	 * @return
	 */
	public List<String>  getAllComment(String hotelID);
	

}
