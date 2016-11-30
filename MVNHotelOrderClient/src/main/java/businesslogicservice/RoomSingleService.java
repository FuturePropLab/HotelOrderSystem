package businesslogicservice;

import tools.ResultMessage;
import tools.ResultMessage_delete;
import vo.RoomVO;

public interface RoomSingleService {
	public RoomVO getSingleRoom (String hotel_id, String room_id);
	
	public ResultMessage addSingleRoom(String hotel_id,RoomVO room);
	
	public ResultMessage editSingleRoom (RoomVO room);
	
	public ResultMessage_delete deleteSingleRoom (String hotel_id,String room_id);
	
	public ResultMessage saveSingleRoom (RoomVO room);
	
}
