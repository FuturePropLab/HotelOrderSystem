package stub;

import dataservice.CustomerDataService;
import po.CustomerPO;
import tools.ResultMessage;
import vo.MemberVO;

public class CustomerData_Stub implements CustomerDataService {

	@Override
	public ResultMessage add(CustomerPO customerInfo) {
		if(customerInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	@Override
	public CustomerPO find(String customer_id) {
		MemberVO membervo = new MemberVO();
		CustomerPO customerPO = new CustomerPO(customer_id, "王帅惟", 
				"男", "15055022805", membervo);
		
		return customerPO;
	}

	@Override
	public ResultMessage modify(CustomerPO customerInfo) {
		if(customerInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

}
