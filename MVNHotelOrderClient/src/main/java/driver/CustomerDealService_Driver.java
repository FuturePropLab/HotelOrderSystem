package driver;

import businesslogicservice.CustomerDealService;
import tools.ResultMessage;
import vo.CustomerVO;

public class CustomerDealService_Driver {
	public void drive(CustomerDealService customerDealService){
		CustomerVO customerVO= customerDealService.getCustomerInfo("1234");
		System.out.println("Name:" +customerVO.customerName);
		
		
		CustomerVO customerVO1 = 
				new CustomerVO("123456", "王帅惟", 
						"男", "15050522805", null,34);
		ResultMessage result = customerDealService.changeCustomerInfo(customerVO1);
		
		if(ResultMessage.Exist == result)  System.out.println("add success");
		
		else  System.out.println("add fail");
	}
}
