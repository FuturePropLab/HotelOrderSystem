package driver;

import businesslogicservice.CreditLogDealService;
import po.Order;
import tools.ActionType;
import tools.OrderState;

public class CreditLogDealService_Driver {
     public void  drive(CreditLogDealService creditLogDealService){
    	 Order order = new Order("213");
    	 order.setHotelID("aaz123");
    	 order.setOrderState(OrderState.Executed);
    	 order.setValue(100);
    	 
    	 System.out.println(creditLogDealService.addlog(order, 
    			 ActionType.RightOrder, order.getValue()));
    	 
    	 System.out.println(creditLogDealService.getLogList("asd").get(0).changeValue);
    	 
    	 
     }
}
