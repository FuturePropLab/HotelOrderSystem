package businesslogicservice;

import java.util.Date;

import tools.ResultMessage_Room;
import tools.RoomType;

public interface RoomSingleService {
	
	public ResultMessage_Room addSingleRoom(String hotelID, String RoomNO, RoomType roomType);
	
	public ResultMessage_Room deleteSingleRoom (String hotelID,String roomNO);
	
	public ResultMessage_Room addDisable (String hotelID,String roomNO , Date negin , Date end);
	
	public ResultMessage_Room deleteDisable (String hotelID,String roomNO , Date negin);
	
}
