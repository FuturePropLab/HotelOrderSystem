package businesslogic.customer;

import java.rmi.RemoteException;

import vo.CustomerVO;

public class OrderCustomerInfoImpl implements businesslogic.order.CustomerInfo {

	@Override
	public CustomerVO getCustomer(String customerID) {
		Customer customer = new Customer();
		try {
			return customer.getCustomerInfo(customerID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
