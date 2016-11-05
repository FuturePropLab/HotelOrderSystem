package businesslogicservice;

import tools.ResultMessage;
import vo.CustomerInputVO;

public interface CustomerSignupService {
	public ResultMessage addCustomer(CustomerInputVO customerInput);
}
