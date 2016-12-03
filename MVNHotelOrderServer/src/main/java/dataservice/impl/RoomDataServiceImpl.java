package dataservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataservice.RoomDataService;
import dataservice.datahelper.RoomDateHelper;
import dataservice.datahelper.impl.RoomDateHelperImpl;
import tools.ResultMessage_Room;
import tools.RoomType;

public class RoomDataServiceImpl implements RoomDataService {
	
	private RoomDateHelper roomDateHelper;
	
	public RoomDataServiceImpl(){
		this.roomDateHelper = RoomDateHelperImpl.getInstantce();
	}
	
	public ResultMessage_Room addRoom(String hotelID, String RoomNO, RoomType roomtype)throws RemoteException {
		return roomDateHelper.addRoom( hotelID,  RoomNO,  roomtype);
	}

	public ResultMessage_Room deleteRoom(String hotelID, String RoomNO)throws RemoteException {
		return roomDateHelper.deleteRoom(hotelID, RoomNO);
	}

	public ResultMessage_Room addRecord(String hotelID, String RoomNO, Date begin, Date end) throws RemoteException{
		return roomDateHelper.addRecord(hotelID, RoomNO, begin, end);
	}

	public ResultMessage_Room deleteRecord(String hotelID, String RoomNO, Date begin)throws RemoteException {
		return roomDateHelper.deleteRecord(hotelID, RoomNO, begin);
	}

	public List<String> getAvailbleRoomNoByType(String hotelID, RoomType roomType, Date begin, Date end)throws RemoteException {
		List<String> allList = roomDateHelper.getRoomNobyType(hotelID, roomType);
		if(begin==null || end == null)   return allList;
		if(begin.after(end)) return new ArrayList<String>();
		List<String> returnlist = new ArrayList<String>();
		Iterator<String> it = allList.iterator();
		while(it.hasNext()){
			String roomNO= it.next();
			if(roomDateHelper.isAvailableRoom(hotelID, roomNO, begin, end))
				returnlist.add(roomNO);
		}
		return returnlist;
	}

	public int getTotalNumberRoomByType(String hotelID, RoomType roomType) throws RemoteException{
		return roomDateHelper.getRoomNobyType(hotelID, roomType).size();
	}

	public int getAvaiableNumberRoomByType(String hotelID, RoomType roomType, Date begin, Date end)
			throws RemoteException {
		return getAvailbleRoomNoByType(hotelID, roomType, begin, end).size();
	}

	
}
