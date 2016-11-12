package driver;

import businesslogicservice.CustomerSignupService;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerInputVO;

public class CustomerSignupService_Driver {
			public void drive(CustomerSignupService customerSignupService){
				CustomerInputVO customerInput = 
						new CustomerInputVO("bluebird", "123456", 
								"鐜嬪竻鎯�", "15050522805", "鐢�");
				ResultMessage2 result = customerSignupService.addCustomer(customerInput);
				
				if(ResultMessage2.success == result)  System.out.println("add success");
				
				else  System.out.println("add fail");
				
			}
}
