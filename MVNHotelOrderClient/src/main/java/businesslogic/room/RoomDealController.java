package businesslogic.room;

import java.util.Date;

import businesslogicservice.RoomDealService;
import po.Order;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomState;
import tools.RoomType;
import vo.RoomVO;

public class RoomDealController implements RoomDealService{

	public ResultMessage_Modify ChangeState(String hotel_id, String room_id, RoomState state,Date date) {
		// TODO Auto-generated method stub
		RoomDeal roomdeal = new RoomDeal();
		return roomdeal.ChangeState(hotel_id, room_id, state,date);
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
	public RoomVO searchEmptyRoom(RoomType type,String hotel_id,Date date){
		
		RoomDeal roomdeal = new RoomDeal();
		return roomdeal.searchEmpty(type,hotel_id,date);
		
	}

	

	
	
	
	
}
