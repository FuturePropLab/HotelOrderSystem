package businesslogic.customer;

import businesslogicservice.CustomerSignupService;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;

public class CustomerSignupController implements CustomerSignupService{

	public ResultMessage_signUp addCustomer(CustomerInputVO customerInput) {
		// TODO Auto-generated method stub
		Customer cus=new Customer();
		
		return ((CustomerSignupService) cus).addCustomer(customerInput);
	}

}
