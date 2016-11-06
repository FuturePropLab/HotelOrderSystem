package businesslogic.credit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import po.Order;
import tools.ActionType;
import tools.ResultMessage;
import vo.CreditlogVO;
import vo.CustomerVO;
/**
 * Credit类的测试
 * @author wshwbluebird
 *
 */
public class TestCredit {
	
	businesslogic.credit.Credit credit;
	@Before
	public  void testBeforeClass(){
		
		CustomerVO  customerVO  = new CustomerVO
				("ppd", "wsw", "male", "15251124223", null, 34);		
		CustomerInfo customerInfo  = new MockCustomer(ResultMessage.Exist,customerVO );
		credit = new Credit(customerInfo);
	}
	
	 
	@Test
	public void testAddlog() {
		Order order = new Order("O1234567");
		assertEquals(ResultMessage.NotExist,credit.addlog(null, ActionType.BadOrder, -34));
		assertEquals(ResultMessage.Exist, credit.addlog(order, ActionType.BadOrder, -34));
	}
	
	@Test
	public void testGetLogList() {
		List<CreditlogVO> list = credit.getLogList("my_id");
		assertEquals(2,list.size());
		assertEquals(100,list.get(0).changeValue);
	}
	
	
	/**
	 * 这个方法测试 需要别的方法
	 */
	@Test
	public void testCharge() {
		assertEquals(ResultMessage.NotExist, credit.charge("wsw", 100));
	}

}
