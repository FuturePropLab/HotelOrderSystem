package businesslogic.order;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Exception.CustomerCreditNotEnoughException;
import stub.OrderDate_Stub;
import tools.Mark;
import tools.OrderState;
import tools.RecoverValue;
import tools.ResultMessage;
import tools.RoomType;
import vo.ExecutionInfoVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchOrderInfoVO;

public class TestOrderController {
	private OrderController orderController;
	private OrderInputVO orderInputVO;
	private OrderVO orderVO;
	private SearchOrderInfoVO searchOrderInfo;
	private ExecutionInfoVO ExecutionInfoVO;
	
	@Before
	public void init() {
		orderController=new OrderController(new OrderDate_Stub());
		orderInputVO=new OrderInputVO("customerID", "hotelID", new Time(0), new Time(0), new Time(0), 
				RoomType.EluxeSuite, 1, 1, false,100);
		orderVO=new OrderVO();
		orderVO.orderID="orderID";
		orderVO.customerID="customerID";
		orderVO.hotelID="hotelID";
		orderVO.roomNumber=new ArrayList<String>();
		orderVO.roomNumber.add("8888");
		orderVO.startTime=new Time(0);
		orderVO.latestTime=new Time(0);
		orderVO.planedLeaveTime=new Time(0);
		orderVO.checkInTime=new Time(0);
		orderVO.checkOutTime=new Time(0);
		orderVO.revokeTime=null;
		orderVO.roomType=RoomType.EluxeSuite;
		orderVO.numberOfRooms=1;
		orderVO.value=100;
		orderVO.planedPeopleNumber=1;
		orderVO.child=false;
		orderVO.orderState=OrderState.Unexecuted;
		orderVO.mark=null;
		orderVO.assessment=null;
		searchOrderInfo=new SearchOrderInfoVO("keywords", new Date(), OrderState.Unexecuted);
		ExecutionInfoVO=new ExecutionInfoVO("orderID", new ArrayList<String>(), new Time(0), new Time(0), new Time(0));
	}

	@Test
	public void testCreateOrders() {
		OrderVO newOrderVO = new OrderVO();
		try {
			assertEquals(orderController.createOrders(orderInputVO), ResultMessage.Exist);
		} catch (CustomerCreditNotEnoughException e) {
			System.out.println("客户信用值为负");
		}
	}
	@Test
	public void testSaveOrder() {
		assertEquals(orderController.saveOrder(orderVO), ResultMessage.Exist);
	}
	@Test
	public void testCheckOrderList() {
		assertNotNull(orderController.CheckOrderList(searchOrderInfo));
	}
	@Test
	public void testCheckSingleOrder() {
		OrderVO newOrderVO=orderController.checkSingleOrder("orderID");
		assertNotNull(newOrderVO);
		assertEquals(newOrderVO.orderID,"orderID");
	}
	@Test
	public void testRevokeCurrentOrder() {
		assertEquals(orderController.revokeCurrentOrder(orderVO), ResultMessage.Exist);
	}
	@Test
	public void testCalculateCreditLose() {
		assertTrue(orderController.calculateCreditLose(orderVO)>0);
	}
	@Test
	public void testExecutionModify() {
		assertEquals(orderController.executionModify(ExecutionInfoVO), ResultMessage.Exist);
	}
	@Test
	public void testAutoToBad() {
		assertEquals(orderController.AutoToBad(orderVO), ResultMessage.Exist);
	}
	@Test
	public void testRevokeBadOrderr() {
		assertEquals(orderController.revokeBadOrderr(orderVO,RecoverValue.RecoverAll), ResultMessage.NotExist);
	}
}
