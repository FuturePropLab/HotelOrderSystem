package businesslogic.room;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import tools.RoomType;
import tools.TypeRoomInfo;
import vo.HotelRoomInfoVO;

public class TestHotelRoomInfo {

	@Test
	public void test() {
		RoomManager hotelRoomInfo=new RoomManager();
		List<TypeRoomInfo> list =new LinkedList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo=new TypeRoomInfo("", "", RoomType.Double, 3, 3.0);
		HotelRoomInfoVO hotelRoomInfoVO=new HotelRoomInfoVO("001", "",list);
		assertEquals(hotelRoomInfoVO.hotelID,hotelRoomInfo.getRoomInfo("001").hotelID);
	}
	@Test
	public void test2() {
		RoomManager hotelRoomInfo=new RoomManager();
		List<TypeRoomInfo> list= new LinkedList<TypeRoomInfo>();
		 list.add(new TypeRoomInfo("","", RoomType.Double, 3, 3.0));
		 TypeRoomInfo typeRoomInfo=new TypeRoomInfo("", "", RoomType.Double, 3, 3.0);
		HotelRoomInfoVO hotelRoomInfoVO=new HotelRoomInfoVO(" ","", list);
		assertEquals( hotelRoomInfoVO.hotelID,hotelRoomInfo.editRoomInfo(new HotelRoomInfoVO(" ", " ",list)).hotelID);
		
	}
}
