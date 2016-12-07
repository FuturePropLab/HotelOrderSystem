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
	 * 
	 * @param orderID
	 * @return
	 */
	public OrderPO getCompleteOrderPO(String orderID);
	
	
	public ResultMessage modifyOrderSearchPO(OrderSearchStorePO orderSearchStorePO);
	
	public ResultMessage modifyOrderAssessPO(OrderAssessPO orderAssessPO);
	
	public ResultMessage changeOrderState(String orderID , OrderState orderState);
	
	public List<String>  getOrderListBycondition(SearchOrderInfo searchOrderInfo);
	
	

}
