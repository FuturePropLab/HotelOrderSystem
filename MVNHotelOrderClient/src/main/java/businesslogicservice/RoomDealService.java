package businesslogicservice;

import java.util.Date;

import po.Order;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomState;
import tools.RoomType;
import vo.RoomVO;

public interface RoomDealService {
	public ResultMessage_Modify ChangeState (String hotel_id , String room_id, RoomState state,Date date);
	
	public ResultMessage arrangeRoom(Order order);
	public RoomVO searchEmptyRoom(RoomType type,String hotel_Id,Date Startdate,Date Enddate);
	
}
