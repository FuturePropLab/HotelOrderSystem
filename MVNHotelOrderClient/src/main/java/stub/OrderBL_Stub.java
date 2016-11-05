package stub;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.OrderService;
import tools.OrderState;
import tools.ResultMessage;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;
import vo.SearchOrderInfoVO;

public class OrderBL_Stub implements OrderService{


	public OrderVO createOrders(OrderInputVO orderInput) {
		OrderVO orderVO=new OrderVO();
		orderVO.orderID="000000001";
		orderVO.customerID=orderInput.customerID;
		orderVO.hotelID=orderInput.hotelID;
		orderVO.startTime=orderInput.startTime;
		orderVO.latestTime=orderInput.latestTime;
		orderVO.planedLeaveTime=orderInput.planedLeaveTime;
		orderVO.roomType=orderInput.roomType;
		orderVO.numberOfRooms=orderInput.numberOfRooms;
		orderVO.planedPeopleNumber=orderInput.planedPeopleNumber;
		orderVO.child=orderInput.child;
		orderVO.orderState=OrderState.Unexecuted;
		return orderVO;
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

	
	public int calculateCreditLose(OrderVO order) {
		return order.value;
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

	
	public ResultMessage revokeBadOrderr(OrderVO badOrder) {
		if(badOrder.orderState.equals(OrderState.Exception)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

}
