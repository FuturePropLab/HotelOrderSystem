package businesslogic.room;

import businesslogicservice.RoomSingleService;
import tools.ResultMessage;
import tools.ResultMessage_delete;
import vo.RoomVO;

public class RoomSingleController implements RoomSingleService{

	public RoomVO getSingleRoom(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		RoomSingle roomsingle = new RoomSingle();
		
		return roomsingle.getSingleRoom(hotel_id, room_id);
	}

	public ResultMessage addSingleRoom(String hotel_id) {
		// TODO Auto-generated method stub
		RoomSingle roomsingle = new RoomSingle();
		
		return roomsingle.addSingleRoom(hotel_id);
	}

	public ResultMessage editSingleRoom(RoomVO room) {
		// TODO Auto-generated method stub
		RoomSingle roomsingle = new RoomSingle();
		
		return roomsingle.editSingleRoom(room);
	}

	public ResultMessage_delete deleteSingleRoom(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		RoomSingle roomsingle = new RoomSingle();
		
		return roomsingle.deleteSingleRoom(hotel_id, room_id);
	}

	public ResultMessage saveSingleRoom(RoomVO room) {
		// TODO Auto-generated method stub
		RoomSingle roomsingle = new RoomSingle();
		
		return roomsingle.saveSingleRoom(room);
	}

}
