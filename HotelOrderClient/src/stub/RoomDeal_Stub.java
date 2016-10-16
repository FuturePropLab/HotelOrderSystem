package stub;

import bussinesslogicservice.RoomDealService;
import po.Order;
import tools.ResultMessage;
import tools.RoomState;

public class RoomDeal_Stub implements RoomDealService {

	@Override
	public ResultMessage ChangeState(String hotel_id, String room_id, RoomState state) {
		if(room_id!=null &&  hotel_id!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage arrangeRoom(Order order) {
		if(order!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}

}
