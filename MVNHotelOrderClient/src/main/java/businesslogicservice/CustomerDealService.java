package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_Modify;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public interface CustomerDealService {
	
	
	public CustomerVO getCustomerInfo(String customer_id);
	
	public ResultMessage_Modify changeCustomerInfo (CustomerVO customerInfo);
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO);
}
