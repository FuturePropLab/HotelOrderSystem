package dataservice.datahelper.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.RoomDateHelper;
import po.RoomDisablePK;
import po.RoomDisablePO;
import po.RoomPK;
import po.SingleRoomPK;
import po.SingleRoomPO;
import po.TypeRoomInfoPO;
import tools.ResultMessage_Room;
import tools.RoomType;

public class RoomDateHelperImpl  implements RoomDateHelper{
	
	private static RoomDateHelperImpl roomDateHelperImpl = null;
	
	private RoomDateHelperImpl(){
		
	}
	/**
	 * 
	 * @return
	 */
	public static RoomDateHelperImpl getInstantce(){
		if(roomDateHelperImpl== null)
			roomDateHelperImpl = new RoomDateHelperImpl();
		return roomDateHelperImpl;
	}
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.RoomDateHelper#addRoom(java.lang.String, java.lang.String, tools.RoomType)
	 */
	public ResultMessage_Room addRoom(String hotelID, String RoomNO, RoomType roomtype) {
		Session s = Hibernateutils.getSessionFactory().openSession();	
		RoomPK roomPK = new RoomPK(hotelID, roomtype);
		TypeRoomInfoPO typeRoomInfoPO = null;
		Transaction t = s.beginTransaction();	
		try{
			typeRoomInfoPO = (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			System.out.println(typeRoomInfoPO.getRoomPK().getRoomtype());
		}catch(Exception e){
			typeRoomInfoPO = new TypeRoomInfoPO();
			typeRoomInfoPO.setRoomPK(roomPK);
			typeRoomInfoPO.setAvailableCount(0);
			typeRoomInfoPO.setPrice(0.0);
			String hotelName = HotelDataHelperImpl.getInstance().getHotelName(hotelID);
			typeRoomInfoPO.setHotelName(hotelName);
			s.save(typeRoomInfoPO);
			t.commit();			
		}
		s.close();
		s = Hibernateutils.getSessionFactory().openSession();	
		System.out.println("BETEEN");
		try {
			Transaction t2 = s.beginTransaction();
			SingleRoomPO singleRoomPO = new SingleRoomPO(hotelID, RoomNO, roomtype);
			s.save(singleRoomPO);
			typeRoomInfoPO.setAvailableCount(typeRoomInfoPO.getAvailableCount()+1);
			s.update(typeRoomInfoPO);
			t2.commit();
			return ResultMessage_Room.success;
		} catch (Exception e) {
			return ResultMessage_Room.fail;
		}finally {
			s.close();
		}
	}

	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.RoomDateHelper#deleteRoom(java.lang.String, java.lang.String)
	 */
	public ResultMessage_Room deleteRoom(String hotelID, String RoomNO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		SingleRoomPK singleRoomPK = new SingleRoomPK(hotelID, RoomNO);	
        try {
			Transaction t = s.beginTransaction();
			//采用load查询不存在的数据,hibernate会抛出object not found exception
			SingleRoomPO singleRoomPO = (SingleRoomPO) s.load(SingleRoomPO.class, singleRoomPK);
			RoomType roomType = singleRoomPO.getRoomType();
			//删除表中的记录.
			//删除,建议用此种方式删除,先加载再删除.
			s.delete(singleRoomPO);
			RoomPK roomPK = new RoomPK(hotelID, roomType);
			TypeRoomInfoPO typeRoomInfoPO;
			typeRoomInfoPO = (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			typeRoomInfoPO.setAvailableCount(typeRoomInfoPO.getAvailableCount()-1);
			s.update(typeRoomInfoPO);
			//提交事务.把内存的改变提交到数据库上.
			t.commit();
			return ResultMessage_Room.success;
		} catch (Exception e) {
			return ResultMessage_Room.fail;
		}finally {
			s.close();	
		}	
	}

	public ResultMessage_Room addRecord(String hotelID, String roomNO, Date begin, Date end) {
		Session s = Hibernateutils.getSessionFactory().openSession();	
		Criteria cr = s.createCriteria(RoomDisablePO.class);
		cr.add(Restrictions.eq("roomDisablePK.hotelID", hotelID));
		cr.add(Restrictions.eq("roomDisablePK.roomNO", roomNO));
		cr.add(Restrictions.lt("roomDisablePK.begin", end));
		if(!cr.list().isEmpty())  return ResultMessage_Room.fail;
		try {
			Transaction t = s.beginTransaction();
			RoomDisablePO roomDisablePO = new RoomDisablePO(hotelID, roomNO, begin, end);
			s.save(roomDisablePO);
			t.commit();
			return ResultMessage_Room.success;
		} catch (Exception e) {
			return ResultMessage_Room.fail;
		}finally {
			s.close();
		}
	}

	public ResultMessage_Room deleteRecord(String hotelID, String RoomNO, Date begin) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		RoomDisablePK roomDisablePK = new RoomDisablePK(hotelID, RoomNO ,begin);
        try {
			Transaction t = s.beginTransaction();
			RoomDisablePO singleRoomPO = (RoomDisablePO) s.load(RoomDisablePO.class, roomDisablePK);
			s.delete(singleRoomPO);
			t.commit();
			return ResultMessage_Room.success;
		} catch (Exception e) {
			return ResultMessage_Room.fail;
		}finally {
			s.close();	
		}	
	}
	
	public ResultMessage_Room deleteRecord(String hotelID, String roomNO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		//Session s = Hibernateutils.getSessionFactory().openSession();	
		Criteria cr = s.createCriteria(RoomDisablePO.class);
		cr.add(Restrictions.eq("roomDisablePK.hotelID", hotelID));
		cr.add(Restrictions.eq("roomDisablePK.roomNO", roomNO));
		cr.add(Restrictions.lt("roomDisablePK.begin", new Date()));
		List<RoomDisablePO>  list = cr.list();
		if(list.isEmpty())  {
			System.out.println("none");
			s.close();
			return ResultMessage_Room.success;
		}else{
			Transaction  t = s.beginTransaction();
			s.delete(list.get(0));
			t.commit();
			s.close();
			return ResultMessage_Room.success;
		}
	}
	
	
	
	public List<String> getRoomNobyType(String hotelID, RoomType roomType) {
		Session s = Hibernateutils.getSessionFactory().openSession();	
		Criteria cr = s.createCriteria(SingleRoomPO.class);
		cr.add(Restrictions.eq("singleRoomPK.hotelID", hotelID));
		cr.add(Restrictions.eq("roomType", roomType));
		List<String> list = new ArrayList<String>();
		Iterator<SingleRoomPO> it = cr.list().iterator();
		while(it.hasNext()){
			list.add(it.next().getSingleRoomPK().getRoomNO());
		}
		s.close();
		return list;
	}
	public boolean isAvailableRoom(String hotelID, String roomNO, Date begin, Date end) {
		Session s = Hibernateutils.getSessionFactory().openSession();	
		Criteria cr = s.createCriteria(RoomDisablePO.class);
		cr.add(Restrictions.eq("roomDisablePK.hotelID", hotelID));
		cr.add(Restrictions.eq("roomDisablePK.roomNO", roomNO));
		cr.add(Restrictions.lt("roomDisablePK.begin", end));
		List<RoomDisablePO>  list = cr.list();
		s.close();
		return list.isEmpty(); 
	}
	
	
	public ResultMessage_Room modifyTypeToomInfoName(String hotelID, String hotelName) {
		Session s = Hibernateutils.getSessionFactory().openSession();	
		Criteria cr = s.createCriteria(TypeRoomInfoPO.class);
		cr.add(Restrictions.eq("roomPK.hotelID", hotelID));
		List<TypeRoomInfoPO>  list = cr.list();
		try {
			for (int i = 0; i < list.size(); i++) {
				TypeRoomInfoPO typeRoomInfoPO = list.get(i);
				Transaction t = s.beginTransaction();
				typeRoomInfoPO.setHotelName(hotelName);
				t.commit();
			} 
			return ResultMessage_Room.success;
		} catch (Exception e) {
			return ResultMessage_Room.fail;
		}finally {
			s.close();
		}
	}
	
	
	public ResultMessage_Room modifyTypeRoomPrice(String hotelID, RoomType roomType, double price) {
		Session s = Hibernateutils.getSessionFactory().openSession();	
		RoomPK roomPK = new RoomPK(hotelID, roomType);
		try {
			TypeRoomInfoPO typeRoomInfoPO = (TypeRoomInfoPO) s.load(TypeRoomInfoPO.class, roomPK);
			typeRoomInfoPO.setPrice(price);
			Transaction t = s.beginTransaction();
			s.update(typeRoomInfoPO);
			t.commit();			
			return ResultMessage_Room.success;
		} catch (Exception e) {
			return ResultMessage_Room.success.fail;
		}finally {
			s.close();
		}
		
	}

	
	
}
