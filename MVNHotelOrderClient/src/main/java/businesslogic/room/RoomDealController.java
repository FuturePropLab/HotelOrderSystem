package businesslogic.room;

import businesslogicservice.RoomDealService;
import po.Order;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomState;
import tools.RoomType;

public class RoomDealController implements RoomDealService{

	public ResultMessage_Modify ChangeState(String hotel_id, String room_id, RoomState state) {
		// TODO Auto-generated method stub
		RoomDeal roomdeal = new RoomDeal();
		return roomdeal.ChangeState(hotel_id, room_id, state);
	}

	public ResultMessage arrangeRoom(Order order) {
		// TODO Auto-generated method stub
		RoomDeal roomdeal = new RoomDeal();
		
		return roomdeal.arrangeRoom(order);
	}
	
	/**
	 * @author chenyuyan 11/26
	 * 增加一个方法，选择房间类型后返回剩余间数
	 * 
	 * 
	 */
	public int searchEmptyRoom(RoomType type){
		
		RoomDeal roomdeal = new RoomDeal();
		return roomdeal.searchEmpty(type);
		
	}

	
	
	
	
}
