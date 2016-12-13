package businesslogic.room;

import java.util.Date;

import businesslogicservice.RoomSingleService;
import tools.ResultMessage_Room;
import tools.RoomType;


/**
 * 控制单独的房间的增加删除  以及设置时间段的不可用
 * @author wshwbluebird
 *
 */
public class RoomSingleController implements RoomSingleService{
	
	private RoomSingle roomSingle;
	
	private static RoomSingleController roomSingleController = null;
	
	private RoomSingleController(){
		roomSingle = new RoomSingle();
	}
	
	public static RoomSingleController getInstance(){
		if(roomSingleController == null)
			roomSingleController = new RoomSingleController();
		return roomSingleController;
	}
	
	/**
	 * 
	 */
	public ResultMessage_Room addSingleRoom(String hotelID, String RoomNO, RoomType roomType) {
		return roomSingle.addSingleRoom(hotelID, RoomNO, roomType);
	}

	public ResultMessage_Room deleteSingleRoom(String hotelID, String roomNO) {
		return roomSingle.deleteSingleRoom(hotelID, roomNO);
	}

	public ResultMessage_Room addDisable(String hotelID, String roomNO, Date begin, Date end) {
		return roomSingle.addDisable(hotelID, roomNO, begin, end);
	}

	public ResultMessage_Room deleteDisable(String hotelID, String roomNO, Date begin) {
		return roomSingle.deleteDisable(hotelID, roomNO, begin);
	}


}
