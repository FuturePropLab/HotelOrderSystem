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
	
	public RoomPO getRoom(String hotel_id,String room_id);//客房信息
	
	public ResultMessage  deleteRoom(String hotel_id, String room_id);
	
	public  ResultMessage_Modify modifyRoomState(RoomPO room);//修改客房状态̬
	
	public ResultMessage editHotelRoom(HotelRoomInfoPO roomInfopo);//修改酒店整体客房信息
	
	public int searchEmptyRoom(RoomType type,String hotel_id);//查找酒店某类型的空余房间
	
	public String getID(String hotel_id,RoomType type,Double pricce);//添加房间需要获得一个id
	
}
