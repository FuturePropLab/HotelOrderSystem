package businesslogic.order;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.OrderService;
import tools.ResultMessage;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;

/**
 * 订单的控制器，实现OrderService
 * @author zjy
 *
 */
public class OrderController implements OrderService{

	public OrderVO createOrders(OrderInputVO orderInput) {
		
		return null;
	}

	public ResultMessage saveOrder(OrderVO preorder) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> CheckOrderList(SearchHotelVO searchOrderInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO checkSingleOrder(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage revokeCurrentOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	public int calculateCreditLose(OrderVO order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultMessage executionModify(ExecutionInfoVO executionInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage AutoToBad(OrderVO Order) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage revokeBadOrderr(OrderVO badOrder) {
		// TODO Auto-generated method stub
		return null;
	}

}
