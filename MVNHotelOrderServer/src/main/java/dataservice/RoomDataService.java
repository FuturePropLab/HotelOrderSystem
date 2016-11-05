package dataservice;

import po.HotelRoomInfoPO;
import po.RoomPO;
import tools.ResultMessage;

public interface RoomDataService {
	public ResultMessage modifyRoomInfo(HotelRoomInfoPO hotelRoomInfo);
	
	public ResultMessage addRoomInfo(HotelRoomInfoPO hotelRoomInfo);
	
	public HotelRoomInfoPO getRoomInfo(String hotel_id);
	
	public ResultMessage addRoom(RoomPO room);
	
	public RoomPO getRoom(String hotel_id,String room_id);
	
	public ResultMessage  deleteRoom(String hotel_id, String room_id);
	
	public  ResultMessage modifyRoom(RoomPO room);
	
}
