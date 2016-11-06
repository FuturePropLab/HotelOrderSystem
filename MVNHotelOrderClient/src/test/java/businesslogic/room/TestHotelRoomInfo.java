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
		RoomHotelInfo hotelRoomInfo=new RoomHotelInfo();
		
		HotelRoomInfoVO hotelRoomInfoVO=new HotelRoomInfoVO("", "",(List<TypeRoomInfo>) new TypeRoomInfo(null, null, null, 0, null));
		assertEquals(hotelRoomInfoVO,hotelRoomInfo.getRoomInfo("001"));
	}
	@Test
	public void test2() {
		RoomHotelInfo hotelRoomInfo=new RoomHotelInfo();
		List<TypeRoomInfo> list= new LinkedList<TypeRoomInfo>();
		 list.add(new TypeRoomInfo("","", RoomType.Double, 3, 3.0));
		assertEquals( hotelRoomInfo,hotelRoomInfo.editRoomInfo(new HotelRoomInfoVO(" ", " ",list)));
		
	}
}
