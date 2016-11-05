package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.OrderDataService;
import po.OrderPO;
import po.SearchOrderInfo;
import tools.ResultMessage;

public class OrderDate_Stub implements OrderDataService{

	
	public ResultMessage add(OrderPO order) {
		if(order.getOrderID().equals("000000001")){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public OrderPO findOrder(String order_id) {
		if(order_id.equals("000000001")){
			return new OrderPO("000000001");
		}
		return null;
	}

	
	public ResultMessage modify(OrderPO order) {
		if(order.getOrderID().equals("000000001")){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo) {
		List<OrderPO> list=new ArrayList<OrderPO>();
		return list;
	}

}
