package businesslogic.room;

import businesslogicservice.RoomSingleService;
import dataservice.RoomDataService;
import po.RoomPO;
import stub.RoomSingle_Stub;
import tools.ResultMessage;
import tools.ResultMessage_delete;
import tools.RoomType;
import vo.RoomVO;
/**
 * Î¯ÍÐÀà
 * 
 * @author chenyuyan
 *
 */
public class RoomSingle  {
	private RoomDataService roomDataService;
	public RoomVO getSingleRoom(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		RoomPO roompo = roomDataService.getRoom(hotel_id, room_id);
		
		//RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		//return roomSingle_Stub.getSingleRoom("", "");
		return new RoomVO(roompo);
	}

	public ResultMessage addSingleRoom(String hotel_id,RoomVO room) {
		// TODO Auto-generated method stub
		
		//RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		//return roomSingle_Stub.addSingleRoom(hotel_id);
		RoomSingle roomid = new RoomSingle();
		String id = roomid.getID(room.hotelID, room.roomType, room.price);
		RoomPO roompo = new RoomPO(room.hotelID,room.hotelName,id,room.roomType,room.price,room.description);
		
		return roomDataService.addRoom(roompo);
	}
	public String getID(String hotel_id,RoomType type,Double pricce){
		
		
		return roomDataService.getID(hotel_id, type, pricce);
		
		
		
	}

	public ResultMessage editSingleRoom(RoomVO room) {
		// TODO Auto-generated method stub
		//RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		
		//RoomPO roompo = new RoomPO(room.hotelID,room.roomID,room.state);
		RoomPO roompo = new RoomPO(room.hotelID,room.hotelName,room.roomID,room.roomType,room.price,room.description);
		//return roomSingle_Stub.editSingleRoom(room);
		return roomDataService.editSingleRoom(roompo);
		
		
	}

	public ResultMessage_delete deleteSingleRoom(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		//RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		//return roomSingle_Stub.deleteSingleRoom(hotel_id, room_id);
		return roomDataService.deleteRoom(hotel_id, room_id);
	}

	public ResultMessage saveSingleRoom(RoomVO room) {
		// TODO Auto-generated method stub
		RoomPO roompo = new RoomPO(room.hotelID,room.hotelName,room.roomID,room.roomType,room.price,room.description);
		return roomDataService.saveSingleRoom(roompo);
		//RoomSingle_Stub roomSingle_Stub=new RoomSingle_Stub();
		//return roomSingle_Stub.saveSingleRoom(room);
	}

}
