package stub;

import businesslogicservice.RoomSingleService;
import tools.ResultMessage;
import tools.ResultMessage_delete;
import tools.RoomType;
import vo.RoomVO;

public class RoomSingle_Stub implements RoomSingleService {


	public RoomVO getSingleRoom(String hotel_id, String room_id) {
		RoomVO roomVo = new RoomVO(hotel_id,"我的大酒店",
				room_id, RoomType.Single, 180.00);
		return roomVo;
	}

	
	public ResultMessage addSingleRoom(String hotel_id) {
		if(hotel_id!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage editSingleRoom(RoomVO room) {
		return ResultMessage.Exist;
	}


	public ResultMessage_delete deleteSingleRoom(String hotel_id, String room_id) {
		if(hotel_id!=null&&room_id!=null)  return ResultMessage_delete.Success;
				return ResultMessage_delete.Failure;
	}


	public ResultMessage saveSingleRoom(RoomVO room) {
		if(room!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage addSingleRoom(String hotel_id, RoomVO room) {
		// TODO Auto-generated method stub
		return null;
	}

}
