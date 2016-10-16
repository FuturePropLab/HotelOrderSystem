package driver;

import bussinesslogicservice.CustomerSignupService;
import tools.ResultMessage;
import vo.CustomerInputVO;

public class CustomerSignupService_Driver {
			public void drive(CustomerSignupService customerSignupService){
				CustomerInputVO customerInput = 
						new CustomerInputVO("bluebird", "123456", 
								"王帅惟", "15050522805", "男");
				ResultMessage result = customerSignupService.addCustomer(customerInput);
				
				if(ResultMessage.Exist == result)  System.out.println("add success");
				
				else  System.out.println("add fail");
				
			}
}
