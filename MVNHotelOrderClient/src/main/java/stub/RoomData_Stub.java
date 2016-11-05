package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.RoomDataService;
import po.HotelRoomInfoPO;
import po.RoomPO;
import tools.ResultMessage;
import tools.RoomType;
import tools.TypeRoomInfo;

public class RoomData_Stub implements RoomDataService {

	
	public ResultMessage modifyRoomInfo(HotelRoomInfoPO hotelRoomInfo) {
		if(hotelRoomInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage addRoomInfo(HotelRoomInfoPO hotelRoomInfo) {
		if(hotelRoomInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public HotelRoomInfoPO getRoomInfo(String hotel_id) {
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo(hotel_id,"荣华大酒店",
				RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoPO hotelRoomInfoPO = new HotelRoomInfoPO(hotel_id,"荣华大酒店",typeList);
		return hotelRoomInfoPO;
	}


	public ResultMessage addRoom(RoomPO room) {
		if(room!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	
	public RoomPO getRoom(String hotel_id, String room_id) {
		RoomPO roomPo = new RoomPO("2333",
				"301", "荣华大酒店", RoomType.Single, 180.00);
		return roomPo;
	}

	
	public ResultMessage deleteRoom(String hotel_id, String room_id) {
		if(room_id!=null && hotel_id != null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	
	public ResultMessage modifyRoom(RoomPO room) {
		if(room!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

}
