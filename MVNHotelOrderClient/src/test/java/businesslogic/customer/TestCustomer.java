package businesslogic.customer;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.customer.Customer;
import businesslogic.customer.MockMember;
import stub.CustomerDeal_Stub;
import stub.CustomerSignup_Stub;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.CustomerInputVO;
import vo.CustomerVO;
import vo.MemberVO;

public class TestCustomer {

	@Test
	public void test() {
		Customer cu=new Customer();
		
		CustomerInputVO test=new CustomerInputVO("xx","xxx",
				"xxx", "123456789", "xx");
		ResultMessage2 expect= ResultMessage2.success;
		String customer_id="0000";
		MemberType memberType = new MemberType("123");
		MemberVO membervo  = new MemberVO("123", memberType);
		CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo,34);
		assertEquals(expect,cu.addCustomer(test));
		assertEquals(customerVO.customerName,cu.getCustomerInfo(customer_id).customerName);

	}

}