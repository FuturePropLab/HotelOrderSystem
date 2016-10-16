package bussinesslogicservice;

import tools.ResultMessage;
import vo.CustomerVO;

public interface CustomerDealService {
	
	
	public CustomerVO getCustomerInfo(String customer_id);
	
	public ResultMessage changeCustomerInfo (CustomerVO customerInfo);
	
}
