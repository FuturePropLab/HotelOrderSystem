package businesslogic.customer;

import java.rmi.RemoteException;

import businesslogic.discount.DiscountDealController;
import businesslogicservice.CustomerSignupService;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;

public class CustomerSignupController implements CustomerSignupService{
	private Customer customer;
	private static CustomerSignupController signupController;
	private CustomerSignupController (){
		customer = new Customer();
	
	}
	
	public static CustomerSignupController getInstance(){
		if(signupController==null) signupController=new CustomerSignupController();
		return signupController;
	}
	
	
	public ResultMessage_signUp addCustomer(CustomerInputVO customerInput) {
		// TODO Auto-generated method stub
		//Customer cus=new Customer();
		
		try {
			return customer.addCustomer(customerInput);
		} catch (RemoteException e) {
			System.out.println("it is wrong");
			return ResultMessage_signUp.Wrong;
		}
	}

}
