package businesslogic.room;
import businesslogicservice.RoomDealService;
import po.Order;
import stub.RoomDeal_Stub;
import tools.ResultMessage;
import tools.RoomState;
import tools.RoomType;
import vo.RoomVO;
public class RoomDeal implements RoomDealService{

	public ResultMessage ChangeState(String hotel_id, String room_id, RoomState state) {
		// TODO Auto-generated method stub
		RoomVO roomVO=new RoomVO(hotel_id,"" , room_id, RoomType.Double, 10);
		roomVO.state=state;
		RoomSingle roomSingle=new RoomSingle();
		return roomSingle. editSingleRoom(roomVO);
	}

	public ResultMessage arrangeRoom(Order order) {
		// TODO Auto-generated method stub
		RoomDeal_Stub roomDeal_Stub=new RoomDeal_Stub();
		return roomDeal_Stub.arrangeRoom(order);
	}

}
