package testHibernate;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import dataservice.OrderDataService;
import dataservice.impl.OrderDataServiceImpl;
import po.OrderPO;
import tools.OrderState;
import tools.RoomType;

public class testOrder {
		public static void main(String[] args) throws RemoteException {
//			OrderDataHelper orderDataHelper = DataHelperUtils.getOrderDataHelper();
			OrderDataService orderDataService = new OrderDataServiceImpl();
//			
//			SearchOrderInfo searchOrderInfo = 
//			new SearchOrderInfo(null, null, null, null, "大酒店", null, null);
//			
//			List<OrderPO>  list = orderDataService.searchOrder(searchOrderInfo);
//			System.out.println(list.size());
//			Iterator<OrderPO> it = list.iterator();
//			
//			while(it.hasNext()){
//				OrderPO orderPO = it.next();
//				System.out.println(orderPO.getHotelID());
//				System.out.println(orderPO.getNumberOfRooms());
//				System.out.println(orderPO.getOrderState());
//				System.out.println(orderPO.getPrice());
//				System.out.println(orderPO.getPlanedPeopleNumber());
//				System.out.println(orderPO.getPlanedLeaveTime());
//				System.out.println(orderPO.getRoomNumber());
//				System.out.println(orderPO.getMark().getValue());
//				System.out.println(orderPO.getAssessment());
//				System.out.println();
//			}
//			

//			OrderAssessPO orderAssessPO = new OrderAssessPO("OD04", "HT001", 3.4, "not so good");
//			OrderSearchStorePO  orderSearchStorePO = new OrderSearchStorePO();
//			orderSearchStorePO.setOrderID("OD04");
//			orderSearchStorePO.setHotelID("HT001");
//			orderSearchStorePO.setCustomerID("CS001");
//			orderSearchStorePO.setOrderState(OrderState.Executed);
//			orderSearchStorePO.setStartTime( new Date());
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 21); // 控制时
			calendar.set(Calendar.MINUTE, 8);    // 控制分
		    calendar.set(Calendar.SECOND, 0);    // 控制秒
			
			OrderPO order = new 
					OrderPO("OD08", "CS002", "HT001", null, new Date(), calendar.getTime(), new Date(2016-1900, 11, 15), 
							null, null, null, null, RoomType.Double, 1, 3, 1, true, OrderState.Unexecuted, null, null, 180);
			System.out.println(orderDataService.add(order));
			
			
	//		System.out.println(orderDataService.modify(new OrderPO(orderSearchStorePO, new OrderNotChangePO(), orderAssessPO)));
			//OrderSearchStorePO  orderSearchStorePO  =orderDataHelper.getOrderSearchStorePO("OD01");
			//OrderNotChangePO  orderNotChangePO  =orderDataHelper.getOrderNotChangePO("OD01");
//			OrderAssessPO orderNotChangePO = orderDataHelper.getOrderAssessPO("OD02");
//			System.out.println(orderNotChangePO.getMarkValue());
//			List<String>  list = orderDataHelper.getOrderRoomPO("OD02");
//			System.out.println(list);
	   	    //System.out.println(orderSearchStorePO == null);
//			System.out.println(orderNotChangePO.getPlanedPeopleNumber() +"    "+
//					orderNotChangePO.getValue());
			//System.out.println(orderSearchStorePO.getCustomerID() == null);
//			System.out.println(orderSearchStorePO.getOrderID()== null);
			
			
			//System.out.println(orderSearchStorePO.getCustomerID());
			
//			List<String> list = new ArrayList<String>();
//			list.add("303");
//			list.add("302");
			
			
			//orderDataHelper.addCompleteOrderPO(new OrderPO("OD01"));			
//			OrderDataHelper orderDataHelper = DataHelperUtils.getOrderDataHelper();
//			OrderSearchStorePO orderSearchStorePO  = orderDataHelper.getOrderSearchStorePO("OD01");
//			System.out.println(orderDataHelper.modifyOrderAssessPO
//					(new OrderAssessPO("OD01", "HT001", 4, "还不错呦!")));
//			orderSearchStorePO.setCheckInTime(new Date());
//			System.out.println(orderDataHelper.modifyOrderSearchPO(orderSearchStorePO));
//			OrderPO orderPO = new OrderPO("OD01");
//			orderPO.setNumberOfRooms(2);
//			System.out.println(orderDataHelper.changeOrderState("OD01", OrderState.Executed));
			
	//		orderDataHelper.addOrderRoomPO("HT001", list);
			//Hibernateutils.shutdown();
			
		}
}
