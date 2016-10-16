package stub;

import java.util.ArrayList;
import java.util.List;

import blservice.OrderService;
import tools.OrderState;
import tools.ResultMessage;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;

public class OrderBL_Stub implements OrderService{

	@Override
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

	@Override
	public ResultMessage saveOrder(OrderVO preorder) {
		if(preorder!=null){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public List<OrderVO> CheckOrderList(SearchHotelVO searchOrderInfo) {
		List<OrderVO> list=new ArrayList<OrderVO>();
		return list;
	}

	@Override
	public OrderVO checkSingleOrder(String order_id) {
		if(order_id.equals("000000001")){
			return new OrderVO();
		}
		return null;
	}

	@Override
	public ResultMessage revokeCurrentOrder(OrderVO order) {
		if(order.orderState.equals(OrderState.Unexecuted)){
			order.orderState=OrderState.Revoked;
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public int calculateCreditLose(OrderVO order) {
		return order.value;
	}

	@Override
	public ResultMessage executionModify(ExecutionInfoVO executionInfo) {
		if(executionInfo!=null){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage AutoToBad(OrderVO Order) {
		if(Order.orderState.equals(OrderState.Unexecuted)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage revokeBadOrderr(OrderVO badOrder) {
		if(badOrder.orderState.equals(OrderState.Exception)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

}
