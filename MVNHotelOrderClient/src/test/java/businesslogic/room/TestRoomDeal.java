package businesslogic.room;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Test;

import po.Order;
import tools.ResultMessage;
import tools.RoomState;
import tools.RoomType;
import vo.OrderInputVO;

public class TestRoomDeal {

//	@Test
//	public void test() {
//		RoomDeal room=new RoomDeal();
//		assertEquals(ResultMessage.Exist,room.ChangeState("001", "001", RoomState.Available));
//	}
	@Test
	public void test2() {
		RoomDeal room=new RoomDeal();
		Order order=new Order("");
		
		assertEquals(ResultMessage.Exist   ,room.arrangeRoom(order));
	}
}
