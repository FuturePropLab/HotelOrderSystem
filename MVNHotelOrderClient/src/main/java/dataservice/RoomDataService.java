package dataservice;

import java.util.Date;

import po.HotelRoomInfo;
import po.RoomPO;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.ResultMessage_delete;
import tools.RoomType;
import vo.RoomVO;

public interface RoomDataService {
	public ResultMessage modifyRoomInfo(HotelRoomInfo hotelRoomInfo);
	
	public ResultMessage addRoomInfo(HotelRoomInfo hotelRoomInfo);
	
	public HotelRoomInfo getRoomInfo(String hotel_id); //酒店整体客房信息
	
	public ResultMessage addRoom(RoomPO room);
	
	public RoomPO getRoom(String hotel_id,String room_id);//客房信息
	
	public ResultMessage_delete  deleteRoom(String hotel_id, String room_id);
	
	public  ResultMessage_Modify modifyRoomState(RoomPO room);//修改客房状态̬
	
	public ResultMessage editHotelRoom(HotelRoomInfo roomInfopo);//修改酒店整体客房信息
	
	public RoomPO searchEmptyRoom(RoomType type,String hotel_id,Date Sartdate,Date Enddate);//查找酒店某类型的空余房间
	
	public String getID(String hotel_id,RoomType type,Double pricce);//添加房间需要获得一个id
	
	public ResultMessage saveSingleRoom(RoomPO room);//保存客房信息
	
	public ResultMessage editSingleRoom(RoomPO room);//编辑客房信息
	
}
