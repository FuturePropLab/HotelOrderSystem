package dataservice.order;

import java.util.List;

import po.OrderPO;
import po.SearchOrderInfo;
import tools.ResultMessage;

public interface OrderService {
	public ResultMessage add(OrderPO order);
	public OrderPO findOrder(String order_id);
	public ResultMessage modify(OrderPO order);
	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo);

}
