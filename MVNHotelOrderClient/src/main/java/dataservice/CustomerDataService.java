package dataservice;

import po.CustomerPO;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;

public interface CustomerDataService {
	public ResultMessage_signUp add(CustomerPO customerInfo);
	
	public CustomerPO find(String customer_id);
	
	public ResultMessage_Modify  modify (CustomerPO customerInfo);
	
	
	
	
}
