package businesslogicservice.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.customer.Customer;
import tools.MemberType;
import tools.ResultMessage2;
import vo.CustomerInputVO;
import vo.CustomerVO;
import vo.MemberVO;

public class TestCustomer {

	@Test
	public void test() throws Exception {
		Customer cu=new Customer();
		
		CustomerInputVO test=new CustomerInputVO("xx","xxx",
				"xxx", "123456789", "xx");
		ResultMessage2 expect= ResultMessage2.Success;
		String customer_id="0000";
		MemberType memberType = new MemberType("123");
		MemberVO membervo  = new MemberVO("123", memberType);
		
		CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo,34);
		assertEquals(expect,cu.addCustomer(test));
		assertEquals(customerVO.credit,cu.getCustomerInfo(customer_id).credit);
		assertEquals(expect,cu.changeCustomerInfo(customerVO));
	}

}
/*public ResultMessage2 addCustomer(CustomerInputVO customerInput){
		CustomerSignup_Stub test=new CustomerSignup_Stub();
		
		return test.addCustomer(customerInput);
		
	}
	public CustomerVO getCustomerInfo(String customer_id){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		MockMember test2=new MockMember();
		test2.customer_ID_test=customer_id;
		return test.getCustomerInfo(customer_id);
		
	}
	public ResultMessage changeCustomerInfo(CustomerVO customerInfo){
		CustomerDeal_Stub test=new CustomerDeal_Stub();
		
		return  test.changeCustomerInfo(customerInfo);
		
	}
	MemberType memberType = new MemberType("123");
		MemberVO membervo  = new MemberVO("123", memberType);
		CustomerVO customerVO  = new CustomerVO(customer_id, "��˧Ω", "��", "15050522805", membervo);
		return customerVO;
	*/
