package stub;

import businesslogicservice.CustomerSignupService;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;

public class CustomerSignup_Stub implements CustomerSignupService {

	
	public ResultMessage_signUp addCustomer(CustomerInputVO customerInput) {
		if(customerInput!=null)  return ResultMessage_signUp.Success
				;
				return ResultMessage_signUp.Wrong;
	}

}
