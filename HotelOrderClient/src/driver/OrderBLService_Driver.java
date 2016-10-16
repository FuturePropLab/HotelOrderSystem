package driver;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.OutOfBoundsException;
import blservice.OrderService;
import tools.DateRange;
import tools.OrderState;
import tools.PriceRange;
import tools.ResultMessage;
import tools.RoomType;
import tools.Star;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;

public class OrderBLService_Driver {
	public boolean drive(OrderService orderService) {
		OrderInputVO orderInput=new OrderInputVO("001", "002", new Time(0), new Time(0), 
				new Time(0), RoomType.Single, 1, 1, false);
		OrderVO order=orderService.createOrders(orderInput);
		if(order==null){
			return false;
		}
		
		ResultMessage result=orderService.saveOrder(order);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		SearchHotelVO searchOrderInfo;
		try {
			searchOrderInfo = new SearchHotelVO("address", "district", "hotelName", 
					RoomType.Single, new PriceRange(0, 1), new DateRange(new Date(), new Date()), Star.one, false);
			List<OrderVO> list=orderService.CheckOrderList(searchOrderInfo);
			if(list==null){
				return false;
			}
		} catch (OutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		lose=orderService.calculateCreditLose(order);
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
		result=orderService.revokeBadOrderr(order);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		return true;
	}

}
