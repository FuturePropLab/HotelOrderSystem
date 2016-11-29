package testHibernate;

import java.rmi.RemoteException;

import dataservice.CustomerDataService;
import dataservice.impl.CustomerDataServiceImpl;
import po.CustomerPO;

public class testDataBase {
		public static void main(String[] args)  {
			CustomerDataService customerDataService = new CustomerDataServiceImpl();
			CustomerPO customerPO = null;
			try {
				customerPO = customerDataService.find("CS001");
			} catch (RemoteException e) {
				System.out.println("rmi");
			}
			System.out.println(customerPO==null);
			System.out.println(customerPO.getCustomerName());
			System.out.println(customerPO.getGender());
			System.out.println(customerPO.getCredit());
			System.out.println(customerPO.getMemberpo().getMemberType().getType());
		}
}
