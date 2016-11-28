package businesslogic.room;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.ResultMessage;
import tools.RoomType;
import vo.RoomVO;

public class TestRoomSingle {

	@Test
	public void test() {
		
		RoomSingle roomSingle=new RoomSingle();
		RoomDescription description = new RoomDescription("卫生间");
		
		RoomVO expected=new RoomVO("", "","", RoomType.Double, 3.0,description);
		assertEquals(expected.hotelID, roomSingle.getSingleRoom("", "").hotelID);
	}
	@Test
	public void test2() {
		RoomSingle roomSingle=new RoomSingle();
		assertEquals(ResultMessage.Exist, roomSingle.deleteSingleRoom("", ""));
	}
	@Test
	public void test3() {
		RoomSingle roomSingle=new RoomSingle();
		assertEquals(ResultMessage.Exist, roomSingle.editSingleRoom(new RoomVO("", "", "", RoomType.Double, 3.0,new RoomDescription("卫生间"))));
	}
	@Test
	public void test4() {
		RoomSingle roomSingle=new RoomSingle();
		assertEquals(ResultMessage.Exist, roomSingle.saveSingleRoom(new RoomVO("", "", "", RoomType.Double, 3.0,new RoomDescription("卫生间"))));
	}
}
