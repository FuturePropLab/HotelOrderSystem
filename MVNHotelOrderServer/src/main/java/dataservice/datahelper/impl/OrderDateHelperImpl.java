package dataservice.datahelper.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import DataFactory.Hibernateutils;
import dataservice.datahelper.OrderDataHelper;
import po.OrderAssessPO;
import po.OrderNotChangePO;
import po.OrderRoomPO;
import po.OrderSearchStorePO;
import tools.ResultMessage;

public class OrderDateHelperImpl implements OrderDataHelper {


	public ResultMessage addOrderSearchStorePO(OrderSearchStorePO orderSearchStorePO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(orderSearchStorePO);
			t.commit();
			return ResultMessage.Exist;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}
	}

	public ResultMessage addOrderNotChangePO(OrderNotChangePO orderNotChangePO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(orderNotChangePO);
			t.commit();
			return ResultMessage.Exist;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}
	}

	public ResultMessage addOrderAssessPO(OrderAssessPO orderAssessPO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(orderAssessPO);
			t.commit();
			return ResultMessage.Exist;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}
	}

	public ResultMessage addOrderRoomPO(String orderID, List<String> roomNumberList) {
		Iterator<String> it =  roomNumberList.iterator();

		
		while(it.hasNext()){
			Session s = Hibernateutils.getSessionFactory().openSession();
			Transaction t = s.beginTransaction();
			String roomNO = it.next();
			OrderRoomPO orderRoomPO = new OrderRoomPO(orderID, roomNO);
			s.save(orderRoomPO);
			t.commit();
			s.close();
		}
		
		return ResultMessage.Exist;
	}
	
//	public ResultMessage addOrder

}
