package stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogic.room.RoomDescription;
import dataservice.RoomDataService;
import po.RoomPO;
import tools.HotelRoomInfo;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_Room;
import tools.ResultMessage_delete;
import tools.RoomType;
import tools.TypeRoomInfo;

public class RoomData_Stub implements RoomDataService {

	
	public ResultMessage modifyRoomInfo(HotelRoomInfo hotelRoomInfo) {
		if(hotelRoomInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage addRoomInfo(HotelRoomInfo hotelRoomInfo) {
		if(hotelRoomInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public HotelRoomInfo getRoomInfo(String hotel_id) {
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo(hotel_id,"鑽ｅ崕澶ч厭搴�",
				RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfo hotelRoomInfoPO = new HotelRoomInfo(hotel_id,"鑽ｅ崕澶ч厭搴�",typeList);
		return hotelRoomInfoPO;
	}


	public ResultMessage addRoom(RoomPO room) {
		if(room!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	
	public RoomPO getRoom(String hotel_id, String room_id) {
		RoomPO roomPo = new RoomPO("2333","我的大酒店",
				room_id, RoomType.Single, 180.00,new RoomDescription("卫生间"), room_id);
		return roomPo;
	}

	
	public ResultMessage_delete deleteRoom1(String hotel_id, String room_id) {
		if(room_id!=null && hotel_id != null)  return ResultMessage_delete.Success;
				return ResultMessage_delete.Failure;
	}

	
	


	public ResultMessage_Modify modifyRoomState(RoomPO room) {
		// TODO Auto-generated method stub
		if(room!=null)  return ResultMessage_Modify.Success;
		return ResultMessage_Modify.Failure;
	}


	public ResultMessage editHotelRoom(HotelRoomInfo roomInfopo) {
		// TODO Auto-generated method stub
		return null;
	}


	public int searchEmptyRoom(RoomType type) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int searchEmptyRoom(RoomType type, String hotel_id) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getID(String hotel_id, RoomType type, Double pricce) {
		// TODO Auto-generated method stub
		return null;
	}


	public RoomPO searchEmptyRoom(RoomType type, String hotel_id, Date Sartdate, Date Enddate) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage saveSingleRoom(RoomPO room) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage editSingleRoom(RoomPO room) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room addRoom(String hotelID, String RoomNO, RoomType roomtype) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room deleteRoom(String hotelID, String RoomNO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room addRecord(String hotelID, String RoomNO, Date begin, Date end) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room deleteRecord(String hotelID, String RoomNO, Date begin) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getAvailbleRoomNoByType(String hotelID, RoomType roomType, Date begin, Date end)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public int getTotalNumberRoomByType(String hotelID, RoomType roomType) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getAvaiableNumberRoomByType(String hotelID, RoomType roomType, Date begin, Date end)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
