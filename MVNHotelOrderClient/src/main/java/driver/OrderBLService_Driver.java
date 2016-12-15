package driver;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.CustomerCreditNotEnoughException;
import Exception.OutOfBoundsException;
import businesslogic.order.Order;
import businesslogicservice.OrderService;
import tools.DateRange;
import tools.OrderState;
import tools.PriceRange;
import tools.RecoverValue;
import tools.ResultMessage;
import tools.RoomType;
import tools.Star;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;
import vo.SearchOrderInfoVO;

public class OrderBLService_Driver {
	public boolean drive(OrderService orderService) {
		OrderInputVO orderInput=new OrderInputVO("001", "002", new Time(0), new Time(0), 
				new Time(0), RoomType.Single, 1, 1, false,100);
		OrderVO order=orderService.checkSingleOrder("order_id");
		try {
			ResultMessage resultMessage = orderService.createOrders(orderInput);
			if(resultMessage.equals(ResultMessage.NotExist)){
				return false;
			}
		} catch (CustomerCreditNotEnoughException e) {
			System.out.println("客户信用值为负");
		}
		
		ResultMessage result=orderService.saveOrder(order);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		SearchOrderInfoVO searchOrderInfo;
		searchOrderInfo = new SearchOrderInfoVO("keywords", new Date(), OrderState.Unexecuted);
		List<OrderVO> list=orderService.CheckOrderList(searchOrderInfo);
		if(list==null){
			return false;
		}
		
		OrderVO order_temp=orderService.checkSingleOrder("000000001");
		if(order_temp==null){
			return false;
		}
		
		order.orderState=OrderState.Unexecuted;
		result=orderService.revokeCurrentOrder(order);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		order.value=100;
		int lose=0;
//		lose=orderService.calculateCreditLose(order);
		if(lose==0){
			return false;
		}
		
		ExecutionInfoVO executionInfo=new ExecutionInfoVO("000000001", new ArrayList<String>(), new Time(0), new Time(0), new Time(0));
		result=orderService.executionModify(executionInfo);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		order.orderState=OrderState.Unexecuted;
		result=orderService.AutoToBad(order);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		order.orderState=OrderState.Exception;
//		result=orderService.revokeBadOrderr(order,RecoverValue.RecoverAll);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		return true;
	}

}
