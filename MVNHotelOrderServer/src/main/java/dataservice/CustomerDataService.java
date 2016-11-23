package dataservice;

import po.CustomerPO;
import tools.ResultMessage;

public interface CustomerDataService {
	public ResultMessage add(CustomerPO customerInfo);
	
	public CustomerPO find(String customer_id);
	
	public ResultMessage modify (CustomerPO customerInfo);
	
	
}
