package dataservice.datahelper;

import java.util.List;

import po.OrderAssessPO;
import po.OrderNotChangePO;
import po.OrderSearchStorePO;
import tools.ResultMessage;

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

}
