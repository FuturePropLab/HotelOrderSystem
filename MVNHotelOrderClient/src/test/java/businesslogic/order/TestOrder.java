package businesslogic.order;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exception.CustomerCreditNotEnoughException;
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
		assertTrue(order.changeState(OrderState.Exception));
		assertEquals(order.getState(), OrderState.Exception);
	}
	@Test
	public void testModifyCheckInInfo() {
		ArrayList<String> roomNumber=new ArrayList<String>();
		roomNumber.add("8888");
		assertTrue(order.modifyCheckInInfo(new ExecutionInfoVO("orderID",roomNumber , new Time(0), new Time(0), null)));
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
	public void testGetOrderValue() {
		assertEquals(order.getOrderValue(), 1);
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
