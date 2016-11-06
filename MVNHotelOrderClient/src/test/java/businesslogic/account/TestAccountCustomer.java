package businesslogic.account;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tools.ResultMessage;
import vo.CustomerAccountVO;
import vo.CustomerSearchVO;
import vo.CustomerVO;


/**
 * 均为模拟测试  并不是真正的测试了类的功能 因为并没有进入代码阶段
 * @author wshwbluebird
 *
 */
public class TestAccountCustomer {
	
	 businesslogic.account.Account account;
	@Before
	public  void testBeforeClass(){
		List<CustomerVO> customerList = new ArrayList<CustomerVO>();
		CustomerVO customerVO1 = new CustomerVO("wsw", "bbd", "male", "15210262516", null,123);
		CustomerVO customerVO2 = new CustomerVO("wsw2", "bbd2", "male", "15210262516", null,123);
		CustomerVO customerVO3 = new CustomerVO("wsw3", "bbd3", "male", "15210262516", null,123);
		customerList.add(customerVO1);
		customerList.add(customerVO2);
		customerList.add(customerVO3);
		
		CustomerInfo customerInfo  = new MockCustomer(customerList, customerVO1);
		this.account = new Account(customerInfo);
	}
	
	
	@Test
	public void testGetCustomerAccount() {
		CustomerAccountVO accountVO = new CustomerAccountVO("123", "wsw", "qisini");
		assertEquals(accountVO.customerName, account.getCustomerAccount("123").customerName);
		assertEquals(accountVO.password, account.getCustomerAccount("123").password);
	  
	}
	
	@Test
	public void testAccountModify() {
		CustomerAccountVO customerAccount = new CustomerAccountVO("123", "wsw", "qisini");
		assertEquals(ResultMessage.Exist, account.accountModify(customerAccount ));
	  
	}
	
	@Test
	public void testSearchCustomerAccount() {
		CustomerSearchVO customerSearchVO = new CustomerSearchVO(null, "wsw", null);
		assertEquals(3, account.searchCustomerAccount(customerSearchVO).size() );
		assertEquals("wsw", account.searchCustomerAccount(customerSearchVO).get(0).customerId );
		assertEquals("wsw2", account.searchCustomerAccount(customerSearchVO).get(1).customerId );
		
	  
	}
	
	@Test
	public void testGetCustomerDetailt() {
		assertEquals("wsw", account.getCustomerDetail("123321").customerID );
		  
	}


}
