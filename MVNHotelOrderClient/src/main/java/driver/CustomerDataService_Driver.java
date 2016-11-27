package driver;

import java.rmi.RemoteException;

import dataservice.CustomerDataService;
import po.CustomerPO;
import tools.ResultMessage;

public class CustomerDataService_Driver {
     public void driver(CustomerDataService customerDataService) throws Exception{
 		CustomerPO customerPO = 
				new CustomerPO("123456", "王帅惟", 
						"男", "15050522805", null,34);
 		System.out.println(customerDataService.add(customerPO));
 		System.out.println(customerDataService.modify(customerPO));
 		System.out.println(customerDataService.find("342432").getCustomerName());
     }
}
