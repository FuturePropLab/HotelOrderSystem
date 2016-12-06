package dataservice.datahelper;

import java.util.Date;
import java.util.List;

import po.OrderAssessPO;
import po.OrderNotChangePO;
import po.OrderPO;
import po.OrderSearchStorePO;
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

}
