package driver;

import businesslogicservice.CustomerSignupService;
import tools.ResultMessage;
import tools.ResultMessageDiscount;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;

public class CustomerSignupService_Driver {
			public void drive(CustomerSignupService customerSignupService){
				CustomerInputVO customerInput = 
						new CustomerInputVO("bluebird", "123456", 
								"鐜嬪竻鎯�", "15050522805", "鐢�");
				ResultMessage_signUp result = customerSignupService.addCustomer(customerInput);
				
				if(ResultMessage_signUp.Success == result)  System.out.println("add success");
				
				else  System.out.println("add fail");
				
			}
}
