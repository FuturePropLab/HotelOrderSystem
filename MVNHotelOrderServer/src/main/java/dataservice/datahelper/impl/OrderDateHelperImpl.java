package dataservice.datahelper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.DataHelperUtils;
import DataFactory.Hibernateutils;
import dataservice.datahelper.CreditLogdataHelper;
import dataservice.datahelper.OrderDataHelper;
import dataservice.datahelper.RoomDateHelper;
import po.CreditLogPO;
import po.CustomerPO;
import po.HotelBasePO;
import po.OrderAssessPO;
import po.OrderNotChangePO;
import po.OrderPO;
import po.OrderRoomPO;
import po.OrderSearchStorePO;
import tools.ActionType;
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
		
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
	    final Date time = orderPO.getLatestTime();
	    final String OrderID = orderPO.getOrderID();
	    final Date endTime = orderPO.getPlanedLeaveTime();
	    final String customerID =  orderPO.getCustomerID();
	    final Date startTime = orderPO.getStartTime();
	    final int value = orderPO.getValue();
	    final List<String>  roomNOList = orderPO.getRoomNumber();
	    final String hotelID = orderPO.getHotelID();
	    System.out.println(time.toString());
	    System.out.println(endTime.toString());
	    
	    timer1.schedule(new TimerTask() {
	      public void run() {
	    	  OrderSearchStorePO orderSearchStorePO = getOrderSearchStorePO(OrderID);
	    	  System.out.println(orderSearchStorePO.getOrderState());
	    	  if(orderSearchStorePO.getOrderState()==OrderState.Unexecuted){
	    		  Session s = Hibernateutils.getSessionFactory().openSession();
	    			try{
	    				Transaction t = s.beginTransaction();
	    				orderSearchStorePO.setOrderState(OrderState.Unexecuted.Exception);
	    				s.update(orderSearchStorePO);
	    				t.commit();
	    			}catch(Exception e){
	    				//System.err.println(e.getMessage());
	    			}finally{
	    				s.close();
	    			}
	    			
	    			
	    		//add credit log 
	    		 CreditLogdataHelper creditLogdataHelper = DataHelperUtils.getCreditLogdataHelper();
		    	 creditLogdataHelper.addCreditLog
		    		  (new CreditLogPO(customerID, ActionType.BadOrder, OrderID, time, 
		    				  0-value, 0));
		    	 
		    	 
		    	//change value; 
		    	Session s2 = Hibernateutils.getSessionFactory().openSession();
		 		CustomerPO customerPO  = (CustomerPO) s2.load(CustomerPO.class, customerID);
		 		//s.close();
		 		//Session s2 = Hibernateutils.getSessionFactory().openSession();
		 		try{		
		 			Transaction t = s2.beginTransaction();
		 			customerPO.setCredit(customerPO.getCredit()-value);
		 			s2.update(customerPO);
		 			t.commit();
		 		}catch(Exception e){
		 			System.err.println(e.getMessage());
		 		}finally {
		 			s2.close();
		 		}	    	 
	    		System.out.println("change to Exception");
	    	  }
	    	  //TODO  Change the credit
	    	  
	        System.gc();
	      }
	    }, time);
	    //timer.cancel();
	    
	    
	    //change room avaiabe;
	    timer2.schedule(new TimerTask() {
		      public void run() {
		    	  OrderSearchStorePO orderSearchStorePO = getOrderSearchStorePO(OrderID);
		    	  System.out.println(orderSearchStorePO.getOrderState());
		    	  if(orderSearchStorePO.getOrderState()==OrderState.Exception){
		    		 RoomDateHelper roomDateHelper  =DataHelperUtils.getRoomDateHelper();
		    		 for (int i = 0; i < roomNOList.size(); i++) {
		    			 roomDateHelper.deleteRecord(hotelID, roomNOList.get(i), startTime);
					}
		    		 System.out.println("Recober Room");
		    	  }
		    	  
		        System.gc();
		      }
		    }, endTime);
	    
	    
	    
	    System.out.println("jump!!!!!");
		
		return ResultMessage.Exist;
	}
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getArrangeRoom(java.lang.String, tools.RoomType, int, java.util.Date, java.util.Date)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getOrderSearchStorePO(java.lang.String)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getOrderNotChangePO(java.lang.String)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getOrderAssessPO(java.lang.String)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getOrderRoomPO(java.lang.String)
	 */
	public List<String> getOrderRoomPO(String orderID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		SQLQuery q =s.createSQLQuery("select RoomNumber from OrderRoomPO  where orderID = '"+orderID+"'");
		
		
		List<String> strList = new ArrayList<String>();
		strList = q.list();
		s.close();
		return strList;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getCompleteOrderPO(java.lang.String)
	 */
	public OrderPO getCompleteOrderPO(String orderID) {
		OrderSearchStorePO  orderSearchStorePO  = getOrderSearchStorePO(orderID);
		if(orderSearchStorePO == null)  return null;
		OrderNotChangePO  orderNotChangePO  = getOrderNotChangePO(orderID);
		if(orderNotChangePO ==null)  return null;
		OrderAssessPO orderAssessPO = getOrderAssessPO(orderID);
		if(orderAssessPO ==null)  return null;
		System.out.println("not Null");
		List<String>  list = getOrderRoomPO(orderID);
		
		OrderPO orderPO = new OrderPO(orderSearchStorePO, orderNotChangePO, orderAssessPO);
		orderPO.setRoomNumber((ArrayList<String>) list);
		
		return orderPO;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#modifyOrderSearchPO(po.OrderSearchStorePO)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#modifyOrderAssessPO(po.OrderAssessPO)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#changeOrderState(java.lang.String, tools.OrderState)
	 */
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
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getOrderListBycondition(po.SearchOrderInfo)
	 */
	public boolean isValidCustomerName(String customerpattern, String customerID) {
		if(customerpattern==null)  return true;
		Session s = Hibernateutils.getSessionFactory().openSession();
		CustomerPO customerPO  = (CustomerPO) s.load(CustomerPO.class, customerID);
		String realname = null;
		
		try {
			realname = customerPO.getCustomerName();
		} catch (Exception e) {
			s.close();
			return false;
		}
		s.close();
		Pattern pattern = Pattern.compile(customerpattern);
    	Matcher matcher = pattern.matcher(realname);
		return matcher.matches();
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#isValidHotelName(java.lang.String, java.lang.String)
	 */
	public boolean isValidHotelName(String hotelnamepattern, String hotelID) {
		if(hotelnamepattern==null)  return true;
		Session s = Hibernateutils.getSessionFactory().openSession();
		HotelBasePO hotelBasePO  = (HotelBasePO) s.load(HotelBasePO.class, hotelID);
		String realname = null;
		
		try {
			realname = hotelBasePO.getHotelName();
		} catch (Exception e) {
			s.close();
			return false;
		}
		s.close();
		Pattern pattern = Pattern.compile(hotelnamepattern);
    	Matcher matcher = pattern.matcher(realname);
		return matcher.matches();
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#isValidTime(java.lang.String, java.util.Date)
	 */
	public boolean isValidTime(String orderID, Date date) {
		
		if(date==null)  return true;
		
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(OrderNotChangePO.class);
		cr.add(Restrictions.le("latestTime", date));
		cr.add(Restrictions.ge("planedLeaveTime", date));
		List<OrderNotChangePO> list =  cr.list();
		s.close();
		if(list.isEmpty())  return false;
		return true;
	}
	
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.OrderDataHelper#getOrderListBycondition(tools.OrderState, java.lang.String, java.lang.String)
	 */
	public List<OrderSearchStorePO> getOrderListBycondition(OrderState orderState, String hotelID, String customerID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(OrderSearchStorePO.class);
		if(orderState!=null)
			cr.add(Restrictions.eq("orderState", orderState));
		if(hotelID !=null)
			cr.add(Restrictions.eq("hotelID", hotelID));
		if(customerID!=null)
			cr.add(Restrictions.eq("customerID", customerID));	
		List<OrderSearchStorePO>  list = cr.list();	
		s.close();
		return list;
	}

	public List<String> getAllComment(String hotelID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(OrderAssessPO.class);
		cr.add(Restrictions.eq("hotelID", hotelID));
		List<OrderAssessPO>  orderAssessPOs = cr.list();
		s.close();
		List<String> ans =new ArrayList<String>();
		for (int i = 0; i < orderAssessPOs.size(); i++) {
			String comment = orderAssessPOs.get(i).getAssessment();
			if(comment!=null)
			ans.add(comment);
		}
		return ans;
	}

	

}
