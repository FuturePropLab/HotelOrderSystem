package driver;

import dataservice.CustomerDataService;
import po.CustomerPO;
import tools.ResultMessage;

public class CustomerDataService_Driver {
     public void driver(CustomerDataService customerDataService){
 		CustomerPO customerPO = 
				new CustomerPO("123456", "王帅惟", 
						"男", "15050522805", null);
 		System.out.println(customerDataService.add(customerPO));
 		System.out.println(customerDataService.modify(customerPO));
 		System.out.println(customerDataService.find("342432").getCustomerName());
     }
}
