package driver;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.ManageHotelInfoService;
import tools.RoomType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.HotelInputVO;
import vo.HotelRoomInfoVO;

public class ManageHotelInfoService_Driver {

	public void drive(ManageHotelInfoService manageHotelInfoService){
		/*public ResultMessage2 addHotel( HotelInputVO vo);
		public HotelInfoVO editHotelInfo (String hotel_id);
		public ResultMessage2 saveHotelInfo (HotelInfoVO hotelInfo);*/
//		HotelInputVO vo=new HotelInputVO("ronghua",null,null, Star.four);
		
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("002","锟劫伙拷锟斤拷频锟�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("002","锟劫伙拷锟斤拷频锟�",typeList);
		
//		HotelInputVO hotelinfo=new HotelInputVO("002","", "nanjing",null);
		
		
//		System.out.println(manageHotelInfoService.addHotel(vo));
//		System.out.println(manageHotelInfoService.saveHotelInfo(hotelinfo));
		
		
	}
}
