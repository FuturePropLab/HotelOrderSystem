package dataservice;

import po.HotelRoomInfoPO;
import po.RoomPO;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomType;

public interface RoomDataService {
	public ResultMessage modifyRoomInfo(HotelRoomInfoPO hotelRoomInfo);
	
	public ResultMessage addRoomInfo(HotelRoomInfoPO hotelRoomInfo);
	
	public HotelRoomInfoPO getRoomInfo(String hotel_id); //�Ƶ�����ͷ���Ϣ
	
	public ResultMessage addRoom(RoomPO room);
	
	public RoomPO getRoom(String hotel_id,String room_id);//����������Ϣ
	
	public ResultMessage  deleteRoom(String hotel_id, String room_id);
	
	public  ResultMessage_Modify modifyRoomState(RoomPO room);//�޸ķ���״̬
	
	public ResultMessage editHotelRoom(HotelRoomInfoPO roomInfopo);//�༭�Ƶ�����ͷ���Ϣ
	
	public int searchEmptyRoom(RoomType type);//����ĳ����շ����������������
	
}
