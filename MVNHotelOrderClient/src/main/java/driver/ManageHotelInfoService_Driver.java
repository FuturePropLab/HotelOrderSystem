package driver;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.ManageHotelInfoService;
import tools.ResultMessage2;
import tools.RoomType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.HotelRoomInfoVO;

public class ManageHotelInfoService_Driver {

	public void drive(ManageHotelInfoService manageHotelInfoService){
		/*public ResultMessage2 addHotel( HotelInputVO vo);
		public HotelInfoVO editHotelInfo (String hotel_id);
		public ResultMessage2 saveHotelInfo (HotelInfoVO hotelInfo);*/
		HotelInputVO vo=new HotelInputVO("ronghua","nanjing","xinjiekou",Star.four);
		
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("002","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("002","�ٻ���Ƶ�",typeList);
		
		HotelInfoVO hotelinfo=new HotelInfoVO("002","�ٻ���Ƶ�", "nanjing","xinjiekou",null,"good","room",hotelRoomInfoVO,Star.five);
		
		
		System.out.println(manageHotelInfoService.addHotel(vo));
		System.out.println(manageHotelInfoService.editHotelInfo(null).facility);
		System.out.println(manageHotelInfoService.saveHotelInfo(hotelinfo));
		
		
	}
}
