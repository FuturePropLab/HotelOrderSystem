package businesslogic.customer;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import businesslogicservice.CustomerDealService;
import tools.MemberType;
import tools.ResultMessage_signUp;
import vo.CustomerInputVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;
import vo.MemberVO;

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
		public Customer customer;

@Test
	public void testGetCustomerInfo(){
	String customer_id="123";
	customer = new Customer();
	MemberType memberType = new MemberType("123");
	MemberVO membervo  = new MemberVO("123", memberType);
	CustomerVO customerVO  = new CustomerVO(customer_id, "王帅惟", "男", "15050522805", membervo,34);
	try {
		assertEquals(customerVO.customerID,customer.getCustomerInfo(customer_id).customerID);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
	public void testAddCustomer(){
	 customer = new Customer();
	CustomerInputVO test=new CustomerInputVO("xx","xxx","xxx", "1234567ABC", "xx");
	try {
		assertEquals(ResultMessage_signUp.Success,customer.addCustomer(test));
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
	public void testSearch(){
	 customer = new Customer();
	CustomerSearchVO searchVO = new CustomerSearchVO("CS001");
	try {
		assertEquals(34, customer.searchCustomer(searchVO).get(0).credit);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
	public void testSearch2(){
	customer = new Customer();
//	String telephone,String customernName ,String gender
	CustomerSearchVO searchVO = new CustomerSearchVO(null,"陈语嫣","女");
	try {
		assertEquals("CS005", customer.searchCustomer(searchVO).get(0).customerID);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
	public void testSearch3(){
		customer = new Customer();
		CustomerSearchVO searchVO = new CustomerSearchVO("333",null,null);
		try {
			assertEquals("CS003", customer.searchCustomer(searchVO).get(0).customerID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}