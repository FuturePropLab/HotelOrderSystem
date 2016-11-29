package businesslogic.customer;

import businesslogicservice.CustomerDealService;
import vo.CustomerSearchVO;

public class TestCustomer {

//	@Test
//	public void test() throws Exception {
//		Customer cu=new Customer();
//		
//		CustomerInputVO test=new CustomerInputVO("xx","xxx",
//				"xxx", "12345678", "xx");
//		CustomerInputVO test2=new CustomerInputVO("xx","xxx",
//				"xxx", "1234567A", "xx");
//		ResultMessage_signUp expect= ResultMessage_signUp.Success;
//		String customer_id="0000";
//		MemberType memberType = new MemberType("123");
//		MemberVO membervo  = new MemberVO("123", memberType);
//		CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo,34);
//		//CustomerVO customerVO2  = new CustomerVO(customer_id, "王帅惟", "男", "1505052280A", membervo,34);
//		ResultMessage_signUp expect2 = ResultMessage_signUp.Wrong;
//		assertEquals(expect,cu.addCustomer(test));
//		assertEquals(expect2,cu.addCustomer(test2));
//		//assertEquals(customerVO.customerName,cu.getCustomerInfo(customer_id).customerName);
//
//	}
		public static void main(String[] args) {
			CustomerDealService customerDealService= new CustomerDealController();		
			CustomerSearchVO searchvo = new CustomerSearchVO(null,"0000");
			System.out.println(customerDealService.searchCustomer(searchvo).get(0).customerName);	
		}
		



}