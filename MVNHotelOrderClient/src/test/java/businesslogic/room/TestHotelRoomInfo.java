package businesslogic.room;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import tools.RoomType;
import tools.TypeRoomInfo;
import vo.HotelRoomInfoVO;

public class TestHotelRoomInfo {
	public RoomManager manager ;
	@Test
	public void testGetRoomByType() {
		/*RoomManager hotelRoomInfo=new RoomManager();
		List<TypeRoomInfo> list =new LinkedList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo=new TypeRoomInfo("", "", RoomType.Double, 3, 3.0);
		HotelRoomInfoVO hotelRoomInfoVO=new HotelRoomInfoVO("001", "",list);
		assertEquals(hotelRoomInfoVO.hotelID,hotelRoomInfo.getRoomInfo("001", null).);*/
		
		manager =new RoomManager();
		assertEquals("001",manager.getAllRoomByType("001", RoomType.Double).get(0));
	}
	@Test
	public void testGetRoomByType2(){
		manager =new RoomManager();
		assertEquals("002", manager.getAllRoomByType("001",RoomType.Single).get(0));
		
	}

	@Test
	public void testGetRoomByTime(){
		
		
	}
}
