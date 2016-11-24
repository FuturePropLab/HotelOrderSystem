package businesslogic.room;

import businesslogicservice.RoomDealService;
import po.Order;
import tools.ResultMessage;
import tools.RoomState;

public class RoomDealController implements RoomDealService{

	public ResultMessage ChangeState(String hotel_id, String room_id, RoomState state) {
		// TODO Auto-generated method stub
		RoomDeal roomdeal = new RoomDeal();
		return roomdeal.ChangeState(hotel_id, room_id, state);
	}

	public ResultMessage arrangeRoom(Order order) {
		// TODO Auto-generated method stub
		RoomDeal roomdeal = new RoomDeal();
		
		return roomdeal.arrangeRoom(order);
	}

	
	
	
	
}
