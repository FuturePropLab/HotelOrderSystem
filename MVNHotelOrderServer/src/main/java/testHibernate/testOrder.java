package testHibernate;

import java.rmi.RemoteException;
import java.util.Date;

import DataFactory.DataHelperUtils;
import dataservice.OrderDataService;
import dataservice.datahelper.OrderDataHelper;
import dataservice.impl.OrderDataServiceImpl;
import po.OrderAssessPO;
import po.OrderPO;
import po.OrderSearchStorePO;
import tools.OrderState;

public class testOrder {
		public static void main(String[] args) throws RemoteException {
//			OrderDataHelper orderDataHelper = DataHelperUtils.getOrderDataHelper();
			
			
//			OrderPO orderPO = orderDataHelper.getCompleteOrderPO("OD01");
//			System.out.println(orderPO.getHotelID());
//			System.out.println(orderPO.getNumberOfRooms());
//			System.out.println(orderPO.getOrderState());
//			System.out.println(orderPO.getPrice());
//			System.out.println(orderPO.getPlanedPeopleNumber());
//			System.out.println(orderPO.getPlanedLeaveTime());
//			System.out.println(orderPO.getRoomNumber());
//			System.out.println(orderPO.getMark());
//			
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
			OrderDataHelper orderDataHelper = DataHelperUtils.getOrderDataHelper();
			OrderSearchStorePO orderSearchStorePO  = orderDataHelper.getOrderSearchStorePO("OD01");
//			System.out.println(orderDataHelper.modifyOrderAssessPO
//					(new OrderAssessPO("OD01", "HT001", 4, "还不错呦!")));
			orderSearchStorePO.setCheckInTime(new Date());
			System.out.println(orderDataHelper.modifyOrderSearchPO(orderSearchStorePO));
//			OrderPO orderPO = new OrderPO("OD01");
//			orderPO.setNumberOfRooms(2);
//			System.out.println(orderDataHelper.changeOrderState("OD01", OrderState.Executed));
			
	//		orderDataHelper.addOrderRoomPO("HT001", list);
			//Hibernateutils.shutdown();
			
		}
}
