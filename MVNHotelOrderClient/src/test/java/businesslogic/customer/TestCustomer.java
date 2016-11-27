package businesslogic.customer;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import businesslogic.customer.Customer;
import businesslogic.customer.MockMember;
import stub.CustomerDeal_Stub;
import stub.CustomerSignup_Stub;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage2;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;
import vo.CustomerVO;
import vo.MemberVO;

public class TestCustomer {

	@Test
	public void test() throws Exception {
		Customer cu=new Customer();
		
		CustomerInputVO test=new CustomerInputVO("xx","xxx",
				"xxx", "12345678", "xx");
		CustomerInputVO test2=new CustomerInputVO("xx","xxx",
				"xxx", "1234567A", "xx");
		ResultMessage_signUp expect= ResultMessage_signUp.Success;
		String customer_id="0000";
		MemberType memberType = new MemberType("123");
		MemberVO membervo  = new MemberVO("123", memberType);
		CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo,34);
		//CustomerVO customerVO2  = new CustomerVO(customer_id, "王帅惟", "男", "1505052280A", membervo,34);
		ResultMessage_signUp expect2 = ResultMessage_signUp.Wrong;
		assertEquals(expect,cu.addCustomer(test));
		assertEquals(expect2,cu.addCustomer(test2));
		//assertEquals(customerVO.customerName,cu.getCustomerInfo(customer_id).customerName);

	}

}