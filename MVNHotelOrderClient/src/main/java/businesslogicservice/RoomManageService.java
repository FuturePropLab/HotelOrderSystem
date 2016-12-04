package businesslogicservice;

import java.util.Date;
import java.util.List;

import tools.ResultMessage_Room;
import tools.RoomType;
import vo.RoomDescriptionVO;

public interface RoomManageService {
	public RoomDescriptionVO  getRoomInfo(String hotel_id, RoomType roomType); 
		
	public ResultMessage_Room saveRoomInfo(String hotelID ,RoomDescriptionVO roomDescriptionVO);
	
	public List<String> getAllRoomByType(String hotelID , RoomType roomType);
	
	public List<String>  getAvaiableRoomBytime (String hotelID , RoomType roomType , Date begin,Date end );
	
	public int getAllNumberByType(String hotelID , RoomType roomType);
	
	public int getAvaiableNumberByTime(String hotelID , RoomType roomType , Date begin,Date end);
}
