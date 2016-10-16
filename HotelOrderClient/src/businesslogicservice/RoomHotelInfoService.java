package businesslogicservice;

import tools.ResultMessage;
import vo.HotelRoomInfoVO;

public interface RoomHotelInfoService {
	public HotelRoomInfoVO getRoomInfo(String hotel_id); 
	
	public HotelRoomInfoVO editRoomInfo (HotelRoomInfoVO  hotelRoomInfo);
		
	public ResultMessage saveRoomInfo(HotelRoomInfoVO hotelRoomInfo);
}
