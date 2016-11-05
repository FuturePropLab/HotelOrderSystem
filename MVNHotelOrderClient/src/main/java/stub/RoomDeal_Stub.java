package stub;

import businesslogicservice.RoomDealService;
import po.Order;
import tools.ResultMessage;
import tools.RoomState;

public class RoomDeal_Stub implements RoomDealService {


	public ResultMessage ChangeState(String hotel_id, String room_id, RoomState state) {
		if(room_id!=null &&  hotel_id!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public ResultMessage arrangeRoom(Order order) {
		if(order!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

}
