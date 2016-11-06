package businesslogicservice;

import tools.ResultMessage;
import vo.RoomVO;

public interface RoomSingleService {
	public RoomVO getSingleRoom (String hotel_id, String room_id);
	
	public ResultMessage addSingleRoom (String hotel_id);
	
	public ResultMessage editSingleRoom (RoomVO room);
	
	public ResultMessage deleteSingleRoom (String hotel_id,String room_id);
	
	public ResultMessage saveSingleRoom (RoomVO room);
	
}
