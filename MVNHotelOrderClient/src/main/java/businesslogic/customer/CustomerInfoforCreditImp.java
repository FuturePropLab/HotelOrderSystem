package businesslogic.customer;

import java.rmi.RemoteException;

import businesslogic.credit.CustomerInfoforCredit;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import vo.CustomerVO;

public class CustomerInfoforCreditImp implements CustomerInfoforCredit{

	

	Customer customer;
	private static CustomerInfoforCreditImp customerImp = null;
	private CustomerInfoforCreditImp(){
		 this.customer = new Customer();
	}
	
	public static CustomerInfoforCreditImp getInstance(){
		if(customerImp == null)
			customerImp = new CustomerInfoforCreditImp();
		return customerImp;		
	}
	
	
	
	public CustomerVO getCustomerInfo(String customer_id) {
		// TODO Auto-generated method stub
		
		
		try {
			return customer.getCustomerInfo(customer_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ResultMessage changeCustomerInfo(CustomerVO customerInfo) {
		// TODO Auto-generated method stub
		
		
		return customer.changeCustomerInfoAboutCredit(customerInfo);
	}

}
