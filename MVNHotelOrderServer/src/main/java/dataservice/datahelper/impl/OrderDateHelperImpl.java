package dataservice.datahelper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.DataHelperUtils;
import DataFactory.Hibernateutils;
import dataservice.datahelper.OrderDataHelper;
import dataservice.datahelper.RoomDateHelper;
import po.OrderAssessPO;
import po.OrderNotChangePO;
import po.OrderPO;
import po.OrderRoomPO;
import po.OrderSearchStorePO;
import po.SearchOrderInfo;
import tools.OrderState;
import tools.ResultMessage;
import tools.RoomType;

public class OrderDateHelperImpl implements OrderDataHelper {
	
	private static OrderDateHelperImpl orderDateHelperImpl = null;
	
	private OrderDateHelperImpl(){
		
	}
	
	public static OrderDateHelperImpl getInstance(){
		if(orderDateHelperImpl == null)
			orderDateHelperImpl = new OrderDateHelperImpl();
		return orderDateHelperImpl;
	}

	/**
	 * 添加订单的搜索信息
	 */
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
	
	/**
	 * 添加订单的不可修改信息
	 */
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
	
	/**
	 * 添加订单的平价信息
	 */
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
	
	/**
	 * 添加订单的 房间信息
	 */
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
	
	/**
	 * 添加一个完整 的 订单信息  已经分配房间不会出现问题的
	 */
	public ResultMessage addCompleteOrderPO(OrderPO orderPO) {
		addOrderNotChangePO(new OrderNotChangePO(orderPO));
		addOrderSearchStorePO(new OrderSearchStorePO(orderPO));
		addOrderRoomPO(orderPO.getOrderID(), orderPO.getRoomNumber());
		addOrderAssessPO(new OrderAssessPO(orderPO.getOrderID(), orderPO.getHotelID()));
		
		return ResultMessage.Exist;
	}

	public List<String> getArrangeRoom(String hotelID, RoomType roomType, int count,Date begin , Date end) {
		RoomDateHelper roomDateHelper  = DataHelperUtils.getRoomDateHelper();
		List<String> allRoom = roomDateHelper.getRoomNobyType(hotelID, roomType);
		List<String> roomlist = new ArrayList<String>();
		boolean flag = false;
		synchronized(this){
			Iterator<String> it  = allRoom.iterator();
			while(it.hasNext()){			
				String roomNO = it.next();
				if(roomDateHelper.isAvailableRoom(hotelID, roomNO, begin, end))
					roomlist.add(roomNO);				
				if(roomlist.size()==count){
					flag = true;
					break;
				}
			}
			//如果房间分配合理  增加房间占用信息
			if(flag == true){
				Iterator<String> it2  = roomlist.iterator();
				while(it2.hasNext()){
					roomDateHelper.addRecord(hotelID, it2.next(), begin, end);
				}
			}
				
		}
		if(flag == true)
			return roomlist;
		else 
			return null;
	}

	public OrderSearchStorePO getOrderSearchStorePO(String orderID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		OrderSearchStorePO orderSearchStorePO = (OrderSearchStorePO) s.load(OrderSearchStorePO.class, orderID);
		try{
			System.out.println(orderSearchStorePO.getCustomerID());
		}catch(Exception e){
			orderSearchStorePO = null;
		}finally{
			s.close();
		}
		
		return orderSearchStorePO;
	}

	public OrderNotChangePO getOrderNotChangePO(String orderID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		OrderNotChangePO orderNotChangePO = (OrderNotChangePO) s.load(OrderNotChangePO.class, orderID);
		try{
			System.out.println(orderNotChangePO.getOrderID());
		}catch(Exception e){
			orderNotChangePO = null;
		}finally{
			s.close();
		}
		
		return orderNotChangePO;
	}

	public OrderAssessPO getOrderAssessPO(String orderID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		OrderAssessPO orderAssessPO = (OrderAssessPO) s.load(OrderAssessPO.class, orderID);
		try{
			System.out.println(orderAssessPO.getOrderID());
		}catch(Exception e){
			orderAssessPO = null;
		}finally {
			s.close();
		}
		
		return orderAssessPO;
	}

	public List<String> getOrderRoomPO(String orderID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(OrderRoomPO.class);
		cr.add(Restrictions.eq("orderID", orderID));
		
		List<OrderRoomPO>  roomlist = cr.list();
		List<String> strList = new ArrayList<String>();
		Iterator<OrderRoomPO> it = roomlist.iterator();
		
		while(it.hasNext()){
			OrderRoomPO orderRoomPO = it.next();
			strList.add(orderRoomPO.getRoomNumber());
		}
		s.close();
		return strList;
	}

	public OrderPO getCompleteOrderPO(String orderID) {
		OrderSearchStorePO  orderSearchStorePO  = getOrderSearchStorePO(orderID);
		if(orderSearchStorePO == null)  return null;
		OrderNotChangePO  orderNotChangePO  = getOrderNotChangePO(orderID);
		if(orderNotChangePO ==null)  return null;
		OrderAssessPO orderAssessPO = getOrderAssessPO(orderID);
		if(orderAssessPO ==null)  return null;
		List<String>  list = getOrderRoomPO(orderID);
		
		OrderPO orderPO = new OrderPO(orderSearchStorePO, orderNotChangePO, orderAssessPO);
		orderPO.setRoomNumber((ArrayList<String>) list);
		
		return orderPO;
	}

	public ResultMessage modifyOrderSearchPO(OrderSearchStorePO orderSearchStorePO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.update(orderSearchStorePO);
			t.commit();
			return ResultMessage.Exist;
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}
	}

	public ResultMessage modifyOrderAssessPO(OrderAssessPO orderAssessPO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.update(orderAssessPO);
			t.commit();
			return ResultMessage.Exist;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}
	}

	public ResultMessage changeOrderState(String orderID, OrderState orderState) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			OrderSearchStorePO orderSearchStorePO = (OrderSearchStorePO) s.load(OrderSearchStorePO.class, orderID);
			s.close();
			s = Hibernateutils.getSessionFactory().openSession();
			Transaction t = s.beginTransaction();
			orderSearchStorePO.setOrderState(orderState);
			s.update(orderSearchStorePO);
			t.commit();
			return ResultMessage.Exist;
		}catch(Exception e){
			//System.err.println(e.getMessage());
			return ResultMessage.NotExist;
		}finally{
			s.close();
		}
	}

	public List<String> getOrderListBycondition(SearchOrderInfo searchOrderInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	public ResultMessage addOrder

}
