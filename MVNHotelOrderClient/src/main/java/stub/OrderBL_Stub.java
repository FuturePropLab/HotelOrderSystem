package stub;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.OrderService;
import tools.OrderState;
import tools.RecoverValue;
import tools.ResultMessage;
import vo.AssessVO;
import vo.ExecutionInfoVO;
import vo.FuzzySearchOrderVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchOrderInfoVO;

public class OrderBL_Stub implements OrderService{


	public ResultMessage createOrders(OrderInputVO orderInput) {
		return orderInput==null?ResultMessage.NotExist:ResultMessage.Exist;
	}

	
	public ResultMessage saveOrder(OrderVO preorder) {
		if(preorder!=null){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}


	public List<OrderVO> CheckOrderList(SearchOrderInfoVO searchOrderInfo) {
		List<OrderVO> list=new ArrayList<OrderVO>();
		return list;
	}

	
	public OrderVO checkSingleOrder(String order_id) {
		if(order_id.equals("000000001")){
			return new OrderVO();
		}
		return null;
	}

	
	public ResultMessage revokeCurrentOrder(OrderVO order) {
		if(order.orderState.equals(OrderState.Unexecuted)){
			order.orderState=OrderState.Revoked;
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public int calculateCreditLose(String orderID) {
		return 101;
	}


	public ResultMessage executionModify(ExecutionInfoVO executionInfo) {
		if(executionInfo!=null){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public ResultMessage AutoToBad(OrderVO Order) {
		if(Order.orderState.equals(OrderState.Unexecuted)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public ResultMessage revokeBadOrderr(String orderID,RecoverValue recoverValue) {
		if(orderID!=null){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}


	@Override
	public List<OrderVO> CheckOrderList(FuzzySearchOrderVO fuzzySearchOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage assessOrder(AssessVO assessVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
