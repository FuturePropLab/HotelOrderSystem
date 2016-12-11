package businesslogic.order;

import static org.junit.Assert.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Exception.CustomerCreditNotEnoughException;
import dataservice.OrderDataService;
import po.OrderPO;
import stub.OrderDate_Stub;
import tools.OrderState;
import tools.ResultMessage;
import tools.ResultMessage_LoginCheck;
import tools.RoomType;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
/**
 * 
 * @author zjy
 *
 */
public class TestOrder {
	private Order order;
	
	/*@Before
	public void init() {
		try {
			order=new Order(new OrderInputVO("customerID", "hotelID", new Time(0), new Time(0), new Time(0), RoomType.EluxeSuite, 1, 1, false,100), 
					new MockCustomerInfo(), new MockHotelInfo(), new OrderDate_Stub());
		} catch (CustomerCreditNotEnoughException e) {
			System.out.println("客户信用值为负");
		}
	}*/

	@Test
	public void testOrder() {
		assertNotNull(order);
	}
	@Test
	public void testSaveOrder() {
		assertEquals(order.saveOrder(), ResultMessage.Exist);
	}
	@Test
	public void testChangeState() {
		assertEquals(order.changeState(OrderState.Exception),ResultMessage.Exist);
		assertEquals(order.getState(), OrderState.Exception);
	}
	@Test
	public void testModifyCheckInInfo() {
		ArrayList<String> roomNumber=new ArrayList<String>();
		roomNumber.add("8888");
		Date date1 = null;
		Date date2 = null;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			 date1= df.parse("2004-01-02 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 date2 = df.parse("2004-01-03 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Date date4 = df.parse("2004-01-03 11:00:24");
//		Date date5 = df.parse("2004-01-03 11:30:24");
//		assertTrue(order.modifyCheckInInfo(new ExecutionInfoVO("orderID",roomNumber , date1, date2, null)));
		
		assertEquals(true, order.modifyCheckInInfo(new ExecutionInfoVO(order.getOrderID(),roomNumber , date1, date2, null)));
		assertEquals(false, order.modifyCheckInInfo(new ExecutionInfoVO("000",roomNumber , null,null, null)));
		assertEquals(order.getState(), OrderState.Executed);
	}
	@Test
	public void testModifyCheckOutInfo() {
		ArrayList<String> roomNumber=new ArrayList<String>();
		roomNumber.add("8888");
		assertTrue(order.modifyCheckOutInfo(new ExecutionInfoVO("orderID",roomNumber , new Time(0), new Time(0), new Time(0))));
		assertNotNull(order.getCheckInAndOutInfo().checkOutTime);
	}
	@Test
	public void testGetState() {
		assertEquals(order.getState(), OrderState.Unexecuted);
	}
	@Test
	public void testCreateValue() {
//		order = new Order();
		Date date1 = null;
		Date date2 = null;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			 date1= df.parse("2004-01-02 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 date2 = df.parse("2004-01-03 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderInputVO orderInputVO = new OrderInputVO("0001","123",date1, date2, null,RoomType.Double, 1, 2, false,100);
//		OrderInputVO orderInput,CustomerInfo customerInfo,HotelInfo hotelInfo,OrderDataService orderDataService
		CustomerInfo customerInfo = new MockCustomerInfo();
		MockHotelInfo hotelInfo = new MockHotelInfo();
		OrderDataService orderDataService = new OrderDate_Stub();
		try {
			order = new Order(orderInputVO,customerInfo,hotelInfo,orderDataService);
		} catch (CustomerCreditNotEnoughException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		Date date3 = null;
		Date date4 = null;
		SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			 date3= df2.parse("2004-01-02 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 date4 = df2.parse("2004-01-03 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderInputVO orderInputVO2 = new OrderInputVO("0002","124",date1, date2, null,RoomType.Double, 1, 2, false,1000);
//		OrderInputVO orderInput,CustomerInfo customerInfo,HotelInfo hotelInfo,OrderDataService orderDataService
		CustomerInfo customerInfo2 = new MockCustomerInfo();
		MockHotelInfo hotelInfo2 = new MockHotelInfo();
		OrderDataService orderDataService2 = new OrderDate_Stub();
		Order order2 = null;
		try {
			 order2 = new Order(orderInputVO2,customerInfo2,hotelInfo2,orderDataService2);
		} catch (CustomerCreditNotEnoughException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		assertEquals(order.getOrderValue(), 1320);
		
		
		
		
		
		assertEquals(order2.getOrderValue(), 1300);
		
		
		
	}
	@Test
	public void testGetOrderID() {
		assertEquals(order.getOrderID(), "orderID");
	}
	@Test
	public void testGetCustomer() {
		assertNotNull(order.getCustomer());
	}
	@Test
	public void testGetPlacingOrderInfo() {
		assertNotNull(order.getPlacingOrderInfo());
	}
	@Test
	public void testGetHotelInfo() {
		assertNotNull(order.getHotelInfo());
	}
	@Test
	public void testGetCheckInAndOutInfo() {
		ExecutionInfoVO executionInfoVO=order.getCheckInAndOutInfo();
		assertNotNull(executionInfoVO);
	}
	@Test
	public void testGetAssessInfo() {
		assertNotNull(order.getAssessInfo());
	}
	@Test
	public void testGetOrderPO() {
		OrderPO orderPO=order.getOrderPO();
		assertNotNull(orderPO);
		assertEquals(orderPO.getOrderID(), "orderID");
	}
}
