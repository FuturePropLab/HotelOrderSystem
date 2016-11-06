package stub;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.CustomerDealService;
import tools.MemberType;
import tools.ResultMessage;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.MemberVO;

public class CustomerDeal_Stub implements CustomerDealService {

	
	public CustomerVO getCustomerInfo(String customer_id) {
		MemberType memberType = new MemberType("123");
		MemberVO membervo  = new MemberVO("123", memberType);
		CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo,34);
		return customerVO;
	}

	
	public ResultMessage changeCustomerInfo(CustomerVO customerInfo) {
		if(customerInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}
	public List<CustomerVO> searchCustomer(CustomerSearchVO customerSearchVO){
		MemberType memberType = new MemberType("123");
		MemberVO membervo  = new MemberVO("123", memberType);
		CustomerVO customerVO  = new CustomerVO("0000", "王帅惟", "男", "15050522805", membervo,34);
		List<CustomerVO> list=new ArrayList();
		list.add(customerVO);
		return list;
	}
}
