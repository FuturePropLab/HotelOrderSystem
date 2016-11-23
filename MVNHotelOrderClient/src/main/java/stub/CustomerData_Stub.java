package stub;

import dataservice.CustomerDataService;
import po.CustomerPO;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;
import vo.MemberVO;

public class CustomerData_Stub implements CustomerDataService {

	
	public ResultMessage_signUp add(CustomerPO customerInfo) {
		if(customerInfo!=null)  return ResultMessage_signUp.Success;
				return ResultMessage_signUp.Wrong;
	}

	
	public CustomerPO find(String customer_id) {
		MemberType memberType = new MemberType("123");
		MemberVO membervo = new MemberVO("123",memberType);
		CustomerPO customerPO = new CustomerPO(customer_id, "王帅惟", 
				"男", "15055022805", membervo,123);
		
		return customerPO;
	}

	
	public ResultMessage_Modify modify(CustomerPO customerInfo) {
		if(customerInfo!=null)  return ResultMessage_Modify.Success;
				return ResultMessage_Modify.Failure;
	}

}
