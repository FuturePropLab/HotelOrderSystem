package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerSearchVO;
import vo.CustomerVO;

public interface CustomerDealService {
	
	
	public CustomerVO getCustomerInfo(String customer_id);
	
	public ResultMessage2 changeCustomerInfo (CustomerVO customerInfo);
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO);
}
