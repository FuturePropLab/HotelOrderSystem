package dataservice.datahelper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import DataFactory.DataHelperUtils;
import DataFactory.Hibernateutils;
import dataservice.datahelper.OrderDataHelper;
import dataservice.datahelper.RoomDateHelper;
import po.OrderAssessPO;
import po.OrderNotChangePO;
import po.OrderPO;
import po.OrderRoomPO;
import po.OrderSearchStorePO;
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

	
//	public ResultMessage addOrder

}
