package businesslogic.room;

import businesslogicservice.RoomSingleService;
import stub.RoomSingle_Stub;
import tools.ResultMessage;
import vo.RoomVO;

public class RoomSingle implements RoomSingleService {

	public RoomVO getSingleRoom(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		return roomSingle_Stub.getSingleRoom("", "");
	}

	public ResultMessage addSingleRoom(String hotel_id) {
		// TODO Auto-generated method stub
		RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		return roomSingle_Stub.addSingleRoom(hotel_id);
	}

	public ResultMessage editSingleRoom(RoomVO room) {
		// TODO Auto-generated method stub
		RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		
		return roomSingle_Stub.editSingleRoom(room);
	}

	public ResultMessage deleteSingleRoom(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		return roomSingle_Stub.deleteSingleRoom(hotel_id, room_id);
	}

	public ResultMessage saveSingleRoom(RoomVO room) {
		// TODO Auto-generated method stub
		RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		return roomSingle_Stub.saveSingleRoom(room);
	}

}