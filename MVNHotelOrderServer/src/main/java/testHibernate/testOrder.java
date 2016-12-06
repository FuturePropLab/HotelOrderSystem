package testHibernate;

import java.rmi.RemoteException;

import javax.persistence.criteria.Order;

import DataFactory.Hibernateutils;
import dataservice.OrderDataService;
import dataservice.datahelper.OrderDataHelper;
import dataservice.datahelper.impl.OrderDateHelperImpl;
import dataservice.impl.OrderDataServiceImpl;
import po.OrderPO;

public class testOrder {
		public static void main(String[] args) throws RemoteException {
//			OrderDataHelper orderDataHelper = new OrderDateHelperImpl();
//			List<String> list = new ArrayList<String>();
//			list.add("303");
//			list.add("302");
			
//			orderDataHelper.addCompleteOrderPO(new OrderPO("OD01"));
			
			OrderDataService orderDataService = new OrderDataServiceImpl();
			OrderPO orderPO = new OrderPO("OD04");
			orderPO.setNumberOfRooms(2);
			System.out.println(orderDataService.add(orderPO));
			
	//		orderDataHelper.addOrderRoomPO("HT001", list);
			Hibernateutils.shutdown();
			
		}
}
