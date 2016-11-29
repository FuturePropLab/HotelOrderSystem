package businesslogic.customer;

import java.rmi.RemoteException;

import businesslogicservice.CustomerSignupService;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;

public class CustomerSignupController implements CustomerSignupService{

	public ResultMessage_signUp addCustomer(CustomerInputVO customerInput) {
		// TODO Auto-generated method stub
		Customer cus=new Customer();
		
		try {
			return cus.addCustomer(customerInput);
		} catch (RemoteException e) {
			System.out.println("it is wrong");
			return ResultMessage_signUp.Wrong;
		}
	}

}
