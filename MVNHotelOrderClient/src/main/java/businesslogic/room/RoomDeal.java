package businesslogic.room;
import java.util.ArrayList;
import java.util.Date;

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
	public ResultMessage_Modify ChangeState(String hotel_id, String room_id, RoomState state,Date date) {
		// TODO Auto-generated method stub
		//RoomVO roomVO=new RoomVO(hotel_id,"" , room_id, RoomType.Double, 10);
		RoomVO roomVO = new RoomVO(hotel_id,room_id,state);
		//roomVO.state=state;
		
		/*ArrayList <Date> BookedDate = roomVO.BookedDate;
		for(int i =0;i<BookedDate.size();i++){
			if(BookedDate.get(i)==date){
				BookedDate.remove(i);
				break;
			}
		}*/
		
		//oomPO roompo = new RoomPO(hotel_id,room_id,state);
		
		//RoomSingle roomSingle=new RoomSingle();
		return null;
		
	}
	
	
	

	public ResultMessage arrangeRoom(Order order) {
		// TODO Auto-generated method stub
		RoomDeal_Stub roomDeal_Stub=new RoomDeal_Stub();
		String hotel_id = order.getHotelID();
		
		
		return roomDeal_Stub.arrangeRoom(order);
	}
	
	
     public RoomVO searchEmpty(RoomType type,String hotel_id,Date Startdate,Date EndDate){
		//return roomDataService.searchEmptyRoom(type,hotel_id, date);
    	 //RoomPO roompo = roomDataService.searchEmptyRoom(type,hotel_id, Startdate,EndDate);
    	 return null;
		
		
	}

}
