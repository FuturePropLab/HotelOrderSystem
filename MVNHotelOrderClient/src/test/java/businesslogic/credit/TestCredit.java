package businesslogic.credit;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		//CustomerInfo customerInfo  = new MockCustomer(ResultMessage.Exist,customerVO );
		credit = new Credit();
	}
	
	 
	@Test
	public void testAddlog() {
		Order order = new Order("O1234567");
		assertEquals(ResultMessage.NotExist,credit.addlog(null, ActionType.BadOrder, -34));
		//assertEquals(ResultMessage.Exist, credit.addlog(order, ActionType.BadOrder, -34));
	}
	
	@Test
	public void testGetLogList() {
		List<CreditlogVO> list = credit.getLogList("my_id");
		assertEquals(2,list.size());
		assertEquals(100,list.get(0).changeValue);
	}
	
	
	/**
	 * 这个方法测试 需要别的方法
	 * @throws RemoteException 
	 */
	@Test
	public void testCharge() throws RemoteException {
		assertEquals(ResultMessage.NotExist, credit.charge("wsw", 100));
	}
	public static void main(String args[]) throws ParseException, RemoteException{
		Order order = new Order("O1234567");
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date1= df.parse("2004-01-02 11:30:24");
		Date date2 = df.parse("2004-01-02 11:30:24");
		Date date3 = df.parse("2004-01-03 10:30:24");
		Date date4 = df.parse("2004-01-03 11:00:24");
		Date date5 = df.parse("2004-01-03 11:30:24");
		order.setLatestTime(date1);
		order.setCheckInTime(date2);
		order.setPlanedLeaveTime(date3);
		order.setCheckOutTime(date4);
		
		//order.setRevokeTime(date5);
		Credit test = new Credit();
			//test.CreditChangeAboutOrder(order, ActionType.BadOrder);
		//test.addlog(order, ActionType.BadOrder, 50);
	}

}
