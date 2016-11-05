package stub;

import businesslogicservice.RoomSingleService;
import tools.ResultMessage;
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


	public RoomVO editSingleRoom(String hotel_id, String room_id) {
		RoomVO roomVo = new RoomVO(hotel_id,"我的大酒店",
				room_id, RoomType.Single, 200.00);
		return roomVo;
	}


	public ResultMessage deleteSingleRoom(String hotel_id, String room_id) {
		if(hotel_id!=null&&room_id!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage saveSingleRoom(RoomVO room) {
		if(room!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

}
