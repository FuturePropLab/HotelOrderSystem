package stub;

import java.util.Date;

import businesslogicservice.RoomSingleService;
import tools.ResultMessage;
import tools.ResultMessage_Room;
import tools.ResultMessage_delete;
import tools.RoomType;
import vo.RoomVO;

public class RoomSingle_Stub implements RoomSingleService {


	public RoomVO getSingleRoom(String hotel_id, String room_id) {
		
		RoomVO roomVo = new RoomVO(null);
		return roomVo;
	}

	
	public ResultMessage addSingleRoom(String hotel_id) {
		if(hotel_id!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage editSingleRoom(RoomVO room) {
		return ResultMessage.Exist;
	}


	public ResultMessage saveSingleRoom(RoomVO room) {
		if(room!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage addSingleRoom(String hotel_id, RoomVO room) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room addSingleRoom(String hotelID, String RoomNO, RoomType roomType) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room deleteSingleRoom1(String hotelID, String roomNO) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room addDisable(String hotelID, String roomNO, Date negin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room deleteDisable(String hotelID, String roomNO, Date negin) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room deleteSingleRoom(String hotelID, String roomNO) {
		// TODO Auto-generated method stub
		return null;
	}

}
