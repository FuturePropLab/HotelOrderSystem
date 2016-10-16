package dataservice;

import java.util.List;

import po.OrderPO;
import po.SearchOrderInfo;
import tools.ResultMessage;
import vo.SearchHotelVO;

public interface OrderDataService {
	public ResultMessage add(OrderPO order);
	public OrderPO findOrder(String order_id);
	public ResultMessage modify(OrderPO order);
	public List<OrderPO> searchOrder(SearchOrderInfo searchOrderInfo);

}
