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
		RoomVO expected=new RoomVO("", "","", RoomType.Double, 3.0);
		assertEquals(expected, roomSingle.getSingleRoom("", ""));
	}
	@Test
	public void test2() {
		RoomSingle roomSingle=new RoomSingle();
		assertEquals(ResultMessage.Exist, roomSingle.deleteSingleRoom("", ""));
	}
	@Test
	public void test3() {
		RoomSingle roomSingle=new RoomSingle();
		assertEquals(ResultMessage.Exist, roomSingle.editSingleRoom(new RoomVO("", "", "", RoomType.Double, 3.0)));
	}
	@Test
	public void test4() {
		RoomSingle roomSingle=new RoomSingle();
		assertEquals(ResultMessage.Exist, roomSingle.saveSingleRoom(new RoomVO("", "", "", RoomType.Double, 3.0)));
	}
}
