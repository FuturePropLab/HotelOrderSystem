package stub;

import java.util.Date;

import businesslogicservice.RoomDealService;
import po.Order;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomState;
import tools.RoomType;
import vo.RoomVO;

public class RoomDeal_Stub implements RoomDealService {


	public ResultMessage_Modify ChangeState(String hotel_id, String room_id, RoomState state) {
		if(room_id!=null &&  hotel_id!=null)  return ResultMessage_Modify.Success;
				return ResultMessage_Modify.Failure;
	}


	public ResultMessage arrangeRoom(Order order) {
		if(order!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	}


	public int searchEmptyRoom(RoomType type) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int searchEmptyRoom(RoomType type, String hotel_Id) {
		// TODO Auto-generated method stub
		return 0;
	}


	public ResultMessage_Modify ChangeState(String hotel_id, String room_id, RoomState state, Date date) {
		// TODO Auto-generated method stub
		return null;
	}


	public RoomVO searchEmptyRoom(RoomType type, String hotel_Id, Date Startdate, Date Enddate) {
		// TODO Auto-generated method stub
		return null;
	}

}
