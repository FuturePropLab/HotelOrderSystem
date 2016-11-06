package businesslogic.room;
import businesslogicservice.RoomHotelInfoService;
import stub.RoomHotelInfo_Stub;
import tools.ResultMessage;
import vo.HotelRoomInfoVO;
public class RoomHotelInfo implements RoomHotelInfoService{

	public HotelRoomInfoVO getRoomInfo(String hotel_id) {
		// TODO Auto-generated method stub
		return new RoomHotelInfo_Stub().getRoomInfo(hotel_id);
	}

	public HotelRoomInfoVO editRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		// TODO Auto-generated method stub
		RoomHotelInfo_Stub roomHotelInfo_Stub=new RoomHotelInfo_Stub();
		return roomHotelInfo_Stub.editRoomInfo(hotelRoomInfo);
	}

	public ResultMessage saveRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		// TODO Auto-generated method stub
		return new RoomHotelInfo_Stub().saveRoomInfo(hotelRoomInfo);
	}

}
