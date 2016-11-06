package driver;

import dataservice.CreditDataService;
import po.CreditLogPO;
import po.OrderPO;
import tools.ActionType;

public class CreditDataService_Driver {
    public void drive(CreditDataService creditDataService){
		OrderPO orderPO = new OrderPO("2134");
		CreditLogPO creditLogPO2 = new CreditLogPO(ActionType.RightOrder, orderPO, 20);
		
		System.out.println(creditDataService.add(creditLogPO2));
		
		System.out.println(creditDataService.getLogList("asd").get(1).getOrderPO().getOrderID());
		
    	
    	
    }
}
