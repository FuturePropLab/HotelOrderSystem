package businesslogic.room;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public void testGetRoomNumByTime(){
		manager = new RoomManager();
		Date date5= null;
		Date date6 = null;
		SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			 date5= df2.parse("2004-01-02 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 date6 = df2.parse("2004-01-03 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, manager.getAvaiableNumberByTime("001", RoomType.Double, date5, date6));
	}
	@Test
	public void tetGetRoomByTime(){
		manager = new RoomManager();
		Date date5= null;
		Date date6 = null;
		SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			 date5= df2.parse("2004-01-02 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 date6 = df2.parse("2004-01-03 11:30:24");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("003", manager.getAvaiableRoomBytime("001",RoomType.Double, date5, date6).get(0));
	}
}
