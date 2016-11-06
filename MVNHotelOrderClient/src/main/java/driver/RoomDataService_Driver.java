package driver;

import java.util.ArrayList;
import java.util.List;

import dataservice.RoomDataService;
import po.HotelRoomInfoPO;
import po.RoomPO;
import tools.RoomType;
import tools.TypeRoomInfo;

public class RoomDataService_Driver {
      public void drive(RoomDataService roomDataService){
    	List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
  	 	TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("23333","荣华大酒店",
  				RoomType.Single,5,180.0);
  		typeList.add(typeRoomInfo1);
  		HotelRoomInfoPO hotelRoomInfoPO = new HotelRoomInfoPO("23333","荣华大酒店",typeList);
  		System.out.println(roomDataService.addRoomInfo(hotelRoomInfoPO));
  		System.out.println(roomDataService.getRoomInfo("asd").
  				getTypeRoomInfo().get(0).getPrice());
  		System.out.println(roomDataService.modifyRoomInfo(hotelRoomInfoPO));
  		
  		
		RoomPO roomPo = new RoomPO("2333",
				"301", "荣华大酒店", RoomType.Single, 180.00);
  		
  		System.out.println(roomDataService.addRoom(roomPo));
  		System.out.println(roomDataService.deleteRoom("233", "301"));
  		System.out.println(roomDataService.getRoom("asd", "ssdf").getHotelName());
  		System.out.println(roomDataService.modifyRoom(roomPo));
  		
  		
      }
}