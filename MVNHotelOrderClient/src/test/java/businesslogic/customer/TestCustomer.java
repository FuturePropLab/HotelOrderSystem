package businesslogic.customer;

import java.util.Iterator;
import java.util.List;

import businesslogicservice.CustomerDealService;
import vo.CustomerSearchVO;
import vo.CustomerVO;

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
		/**
		 * 非标准检验
		 * @param args
		 */
		/*public static void main(String[] args) {
			CustomerDealService customerDealService= new CustomerDealController();		
			CustomerSearchVO searchvo = new CustomerSearchVO("23", null, "女");
			List<CustomerVO> list = customerDealService.searchCustomer(searchvo);
			Iterator<CustomerVO> it = list.iterator();
			while(it.hasNext()){
				CustomerVO customerVO  =it.next();
				System.out.println(customerVO.customerID+"  "+customerVO.customerName+"  "+
						customerVO.gender+"  "+customerVO.telephone);
			}
			
		}*/
		



}