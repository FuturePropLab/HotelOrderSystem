package driver;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.OutOfBoundsException;
import dataservice.OrderDataService;
import po.OrderPO;
import po.SearchOrderInfo;
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

public class OrderDataService_Driver {
	public boolean drive(OrderDataService orderService) {
		OrderPO order=new OrderPO("000000001");
		ResultMessage result=orderService.add(order);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		order=orderService.findOrder("000000001");
		if(order==null){
			return false;
		}
		
		result=orderService.modify(order);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		SearchOrderInfo searchOrderInfo=new SearchOrderInfo();
		List<OrderPO> list=orderService.searchOrder(searchOrderInfo);
		if(list==null){
			return false;
		}
		
		return true;
	}

}
