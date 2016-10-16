package bussinesslogicservice;

import po.Order;
import tools.ResultMessage;
import tools.RoomState;

public interface RoomDealService {
	public ResultMessage ChangeState (String hotel_id , String room_id, RoomState state);
	
	public ResultMessage arrangeRoom(Order order);
	
}
