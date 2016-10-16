package driver;

import java.util.ArrayList;
import java.util.List;

import bussinesslogicservice.RoomHotelInfoService;
import tools.RoomType;
import tools.TypeRoomInfo;
import vo.HotelRoomInfoVO;

public class RoomHotelInfoService_Driver {
		public void driver(RoomHotelInfoService hotelInfoService){
			System.out.println(hotelInfoService.getRoomInfo("2134").
					typeRoomInfo.get(0).getRoomtype());
			
			List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
			TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("1234","荣华大酒店",
					RoomType.Single,5,180.0);
			typeList.add(typeRoomInfo1);
			HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("1234","荣华大酒店",typeList);
			
			System.out.println("number:  "+hotelInfoService.editRoomInfo(hotelRoomInfoVO).
					typeRoomInfo.size());
			
			System.out.println(hotelInfoService.saveRoomInfo(hotelRoomInfoVO));
		}
}
