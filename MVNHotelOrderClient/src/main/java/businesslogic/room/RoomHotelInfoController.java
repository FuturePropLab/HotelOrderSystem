package businesslogic.room;

import java.util.List;

import businesslogicservice.RoomHotelInfoService;
import tools.ResultMessage;
import tools.RoomState;
import vo.HotelRoomInfoVO;
import vo.RoomVO;

public class RoomHotelInfoController implements RoomHotelInfoService{

	public HotelRoomInfoVO getRoomInfo(String hotel_id) {
		// TODO Auto-generated method stub
		RoomHotelInfo roominfo = new RoomHotelInfo();
		
		return roominfo.getRoomInfo(hotel_id);
	}

	public HotelRoomInfoVO editRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		// TODO Auto-generated method stub
		RoomHotelInfo roominfo = new RoomHotelInfo();
		return roominfo.editRoomInfo(hotelRoomInfo);
	}

	public ResultMessage saveRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		// TODO Auto-generated method stub
		RoomHotelInfo roominfo = new RoomHotelInfo();
		
		return roominfo.saveRoomInfo(hotelRoomInfo);
	}
	
}
