package stub;

import businesslogicservice.CustomerDealService;
import tools.MemberType;
import tools.ResultMessage;
import vo.CustomerVO;
import vo.MemberVO;

public class CustomerDeal_Stub implements CustomerDealService {

	@Override
	public CustomerVO getCustomerInfo(String customer_id) {
		MemberType memberType = new MemberType("123");
		MemberVO membervo  = new MemberVO("123", memberType);
		CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo);
		return customerVO;
	}

	@Override
	public ResultMessage changeCustomerInfo(CustomerVO customerInfo) {
		if(customerInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

}
