package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public interface CustomerDealService {
	
	
	public CustomerVO getCustomerInfo(String customer_id);
	
	public ResultMessage changeCustomerInfo (CustomerVO customerInfo);
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO);
}
