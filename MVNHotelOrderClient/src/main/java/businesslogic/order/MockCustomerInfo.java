package businesslogic.order;

import tools.MemberType;
import vo.CustomerVO;
import vo.MemberVO;

public class MockCustomerInfo implements CustomerInfo{

	public CustomerVO getCustomer(String customerID) {
		// TODO Auto-generated method stub
		return new CustomerVO(customerID, "customerName", "gender", "telephone", new MemberVO(customerID, 
				new MemberType(customerID)));
	}

}
