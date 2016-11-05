package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;

public interface OrderService {
	public OrderVO createOrders(OrderInputVO orderInput);
	public ResultMessage saveOrder(OrderVO preorder); 
	public List<OrderVO> CheckOrderList (SearchHotelVO searchOrderInfo);
	public OrderVO checkSingleOrder (String order_id );
	public ResultMessage revokeCurrentOrder(OrderVO order);
	public int calculateCreditLose (OrderVO order);
	public ResultMessage executionModify (ExecutionInfoVO executionInfo);
	public ResultMessage AutoToBad(OrderVO Order);
	public ResultMessage revokeBadOrderr(OrderVO badOrder);
}
