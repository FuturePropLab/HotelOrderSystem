package businesslogicservice;

import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerInputVO;

public interface CustomerSignupService {
	public ResultMessage2 addCustomer(CustomerInputVO customerInput);
}
