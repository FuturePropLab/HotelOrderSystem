package driver;

import businesslogicservice.CustomerDealService;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerVO;

public class CustomerDealService_Driver {
	public void drive(CustomerDealService customerDealService){
		CustomerVO customerVO= customerDealService.getCustomerInfo("1234");
		System.out.println("Name:" +customerVO.customerName);
		
		
		CustomerVO customerVO1 = 
				new CustomerVO("123456", "鐜嬪竻鎯�", 
						"鐢�", "15050522805", null,34);
		ResultMessage2 result = customerDealService.changeCustomerInfo(customerVO1);
		
		if(ResultMessage2.success == result)  System.out.println("add success");
		
		else  System.out.println("add fail");
	}
}
