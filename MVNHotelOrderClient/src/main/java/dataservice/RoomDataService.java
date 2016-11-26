package dataservice;

import po.HotelRoomInfoPO;
import po.RoomPO;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomType;

public interface RoomDataService {
	public ResultMessage modifyRoomInfo(HotelRoomInfoPO hotelRoomInfo);
	
	public ResultMessage addRoomInfo(HotelRoomInfoPO hotelRoomInfo);
	
	public HotelRoomInfoPO getRoomInfo(String hotel_id); //酒店整体客房信息
	
	public ResultMessage addRoom(RoomPO room);
	
	public RoomPO getRoom(String hotel_id,String room_id);//单个房间信息
	
	public ResultMessage  deleteRoom(String hotel_id, String room_id);
	
	public  ResultMessage_Modify modifyRoomState(RoomPO room);//修改房间状态
	
	public ResultMessage editHotelRoom(HotelRoomInfoPO roomInfopo);//编辑酒店整体客房信息
	
	public int searchEmptyRoom(RoomType type);//返回某种类空房间个数，新增方法
	
}
