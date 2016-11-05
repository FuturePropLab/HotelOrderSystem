package stub;

import businesslogicservice.CustomerSignupService;
import tools.ResultMessage;
import vo.CustomerInputVO;

public class CustomerSignup_Stub implements CustomerSignupService {

	
	public ResultMessage addCustomer(CustomerInputVO customerInput) {
		if(customerInput!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

}
