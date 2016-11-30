package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogic.room.RoomDescription;
import dataservice.RoomDataService;
import po.HotelRoomInfoPO;
import po.RoomPO;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_delete;
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
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo(hotel_id,"鑽ｅ崕澶ч厭搴�",
				RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoPO hotelRoomInfoPO = new HotelRoomInfoPO(hotel_id,"鑽ｅ崕澶ч厭搴�",typeList);
		return hotelRoomInfoPO;
	}


	public ResultMessage addRoom(RoomPO room) {
		if(room!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	
	public RoomPO getRoom(String hotel_id, String room_id) {
		RoomPO roomPo = new RoomPO("2333","我的大酒店",
				room_id, RoomType.Single, 180.00,new RoomDescription("卫生间"));
		return roomPo;
	}

	
	public ResultMessage_delete deleteRoom(String hotel_id, String room_id) {
		if(room_id!=null && hotel_id != null)  return ResultMessage_delete.Success;
				return ResultMessage_delete.Failure;
	}

	
	


	public ResultMessage_Modify modifyRoomState(RoomPO room) {
		// TODO Auto-generated method stub
		if(room!=null)  return ResultMessage_Modify.Success;
		return ResultMessage_Modify.Failure;
	}


	public ResultMessage editHotelRoom(HotelRoomInfoPO roomInfopo) {
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

}
