package businesslogic.room;
import businesslogicservice.RoomDealService;
import dataservice.RoomDataService;
import po.Order;
import po.RoomPO;
import stub.RoomDeal_Stub;
import tools.ResultMessage;
import tools.ResultMessage_Modify;
import tools.RoomState;
import tools.RoomType;
import vo.RoomVO;
/**
 * @author chenyuyan 
 * 委托类 
 * 
 */
public class RoomDeal {
	private RoomDataService roomDataService;
/**
 * @author chenyuyan
 * 修改酒店状态 
 * @param hotel_id
 * @param room_id
 * @param state
 * @return
 */
	public ResultMessage_Modify ChangeState(String hotel_id, String room_id, RoomState state) {
		// TODO Auto-generated method stub
		//RoomVO roomVO=new RoomVO(hotel_id,"" , room_id, RoomType.Double, 10);
		RoomVO roomVO = new RoomVO(hotel_id,room_id,state);
		//roomVO.state=state;

		RoomPO roompo = new RoomPO(hotel_id,room_id,state);
		
		//RoomSingle roomSingle=new RoomSingle();
		return roomDataService.modifyRoomState(roompo);
		
	}
	
	
	

	public ResultMessage arrangeRoom(Order order) {
		// TODO Auto-generated method stub
		RoomDeal_Stub roomDeal_Stub=new RoomDeal_Stub();
		
		
		return roomDeal_Stub.arrangeRoom(order);
	}
	
	
     public int searchEmpty(RoomType type,String hotel_id){
		return roomDataService.searchEmptyRoom(type,hotel_id);
    	 
		
		
	}

}
