package stub;

import businesslogicservice.CustomerSignupService;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerInputVO;

public class CustomerSignup_Stub implements CustomerSignupService {

	
	public ResultMessage2 addCustomer(CustomerInputVO customerInput) {
		if(customerInput!=null)  return ResultMessage2.success
				;
				return ResultMessage2.fail;
	}

}
