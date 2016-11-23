package dataservice;

import java.util.List;

import po.CustomerPO;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;
import vo.CustomerVO;

public interface CustomerDataService {
	public ResultMessage_signUp add(CustomerPO customerInfo);
	
	public CustomerPO find(String customer_id);
	
	public ResultMessage_Modify  modify (CustomerPO customerInfo);
	
	/**
	 * @author chenyuyan 11/22
	 * 返回所有客户
	 */
	public List<CustomerPO> searchCustomer();
	
	
}
