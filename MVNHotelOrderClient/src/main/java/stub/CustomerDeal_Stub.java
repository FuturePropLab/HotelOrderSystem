package stub;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.CustomerDealService;
import tools.MemberBelongType;
import tools.MemberType;
import tools.ResultMessage_Modify;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.MemberVO;

public class CustomerDeal_Stub implements CustomerDealService {

	
	public CustomerVO getCustomerInfo(String customer_id) {
		MemberType memberType = new MemberType("000000009");
		MemberVO membervo  = new MemberVO("000000009", memberType);
		CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo,1550);
		return customerVO;
	}

	
	public ResultMessage_Modify changeCustomerInfo(CustomerVO customerInfo) {
		if(customerInfo!=null)  return ResultMessage_Modify.Success;
				return ResultMessage_Modify.Failure;
	}
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		MemberType memberType = new MemberType("0000");
		 memberType.setType(MemberBelongType.None);
		MemberVO membervo  = new MemberVO("0000", memberType);
		CustomerVO customerVO  = new CustomerVO("0000", "王帅惟", "男", "15050522805", membervo,34);
		List<CustomerVO> list=new ArrayList();
		list.add(customerVO);
		return list;
	}
}
