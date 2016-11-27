package businesslogicservice;

import po.Order;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomState;
import tools.RoomType;

public interface RoomDealService {
	public ResultMessage_Modify ChangeState (String hotel_id , String room_id, RoomState state);
	
	public ResultMessage arrangeRoom(Order order);
	public int searchEmptyRoom(RoomType type,String hotel_Id);
	
}
