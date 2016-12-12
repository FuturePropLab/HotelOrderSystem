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
import tools.Mark;
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
	
	@Before
	public void init() {
		try {
			order=new Order(new OrderInputVO("customerID", "hotelID", new Time(0), new Time(0), new Time(0), RoomType.EluxeSuite, 1, 1, false,100), 
					new MockCustomerInfo(), new MockHotelInfo(), new OrderDate_Stub());
		} catch (CustomerCreditNotEnoughException e) {
			System.out.println("客户信用值为负");
		}
	}

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
//		OrderPO orderPO,CustomerInfo customerInfo,HotelInfo hotelInfo,OrderDataService orderDataService
		OrderPO orderPO = new OrderPO("000");
		
		
//		OrderPO orderPO = new OrderPO("001",null,null,null,null.null.null,null,null,null,null,null,null,null,null,null,false,OrderState.Unexecuted,"00",100);
		order = new Order(orderPO,new MockCustomerInfo(),new MockHotelInfo(),new OrderDate_Stub());
		ArrayList<String> roomNumber = new ArrayList<String>();
		roomNumber.add("100");
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date4 = null;
		try {
			date4 = df.parse("2004-01-03 11:00:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date5 = null;
		try {
			date5 = df.parse("2004-01-03 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		assertTrue(order.modifyCheckInInfo(new ExecutionInfoVO("orderID",roomNumber , date1, date2, null)));
		
		assertEquals(true, order.modifyCheckInInfo(new ExecutionInfoVO(order.getOrderID(),roomNumber , date4, date5, null)));
		assertEquals(true, order.modifyCheckInInfo(new ExecutionInfoVO("000",roomNumber , null,null, null)));
//		assertEquals(order.getState(), OrderState.Executed);
	}
	/*
	@Test
	public void testModifyCheckOutInfo() {
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
//		OrderPO orderPO = new OrderPO("123");
//		order = new Order(orderPO,null,null,null);
//		ArrayList<String> roomNumber=new ArrayList<String>();
//		roomNumber.add("8888");
		 
		ExecutionInfoVO ex = new ExecutionInfoVO(order.getOrderID(), roomNumber, date1, date2, null);
		assertEquals(false, order.modifyCheckOutInfo(ex));
		
//		assertNotNull(order.getCheckInAndOutInfo().checkOutTime);
	}*/
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
		
		Date date5= null;
		Date date6 = null;
//		SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			 date5= df2.parse("2004-01-02 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 date6 = df2.parse("2004-01-03 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderInputVO orderInputVO3 = new OrderInputVO("0003","125",date1, date2, null,RoomType.Double, 1, 2, false,2000);
//		OrderInputVO orderInput,CustomerInfo customerInfo,HotelInfo hotelInfo,OrderDataService orderDataService
		CustomerInfo customerInfo3 = new MockCustomerInfo();
		MockHotelInfo hotelInfo3 = new MockHotelInfo();
//		OrderDataService orderDataService2 = new OrderDate_Stub();
		Order order3 = null;
		try {
			 order3 = new Order(orderInputVO3,customerInfo3,hotelInfo3,orderDataService2);
		} catch (CustomerCreditNotEnoughException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		assertEquals(order.getOrderValue(), 1320);
		assertEquals(order2.getOrderValue(), 1300);
		assertEquals(order3.getOrderValue(),2400 );
		
		
	}
	@Test
	public void testGetOrderID() {
//		Date startTime, Date latestTime,Date planedLeaveTime,
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
		try {
			order=new Order(new OrderInputVO("001", "000", date3, new Time(0), new Time(0), RoomType.EluxeSuite, 1, 1, false,100), 
					new MockCustomerInfo(), new MockHotelInfo(), new OrderDate_Stub());
		} catch (CustomerCreditNotEnoughException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order order2 = null;
		try {
			order2=new Order(new OrderInputVO("00002", "000", date4, new Time(0), new Time(0), RoomType.EluxeSuite, 1, 1, false,100), 
					new MockCustomerInfo(), new MockHotelInfo(), new OrderDate_Stub());
		} catch (CustomerCreditNotEnoughException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*String hashValue=orderInput.startTime.hashCode()+"";
		String customerID=orderInput.customerID;
		String result="";
		for(int i=0,j=0;i<hashValue.length()||j<customerID.length();i++,j++){
			if(i>=hashValue.length()){
				result=result+customerID.charAt(j);
			}else if (j>=customerID.length()) {
				result=result+hashValue.charAt(i);
			}else {
				result=result+hashValue.charAt(i)+customerID.charAt(j);
			}
		}
		if("".equals(result)){
			System.err.println("create OrderID failed!");
		}
		return result;*/
		
		
		assertEquals("-070217600007",order.getOrderID());
		assertEquals("-06040102200007",order2.getOrderID());
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
	/*@Test
	public void testGetOrderPO() {
		OrderPO orderPO=order.getOrderPO();
//		assertNotNull(orderPO);
		assertEquals(orderPO.getOrderID(), "orderID");
	}*/
}
