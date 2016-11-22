package businesslogicservice;

import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;

public interface CustomerSignupService {
	public ResultMessage_signUp addCustomer(CustomerInputVO customerInput);
}
