package driver;

import java.util.ArrayList;
import java.util.List;

import businesslogic.room.RoomDescription;
import dataservice.RoomDataService;
import po.HotelRoomInfo;
import po.RoomPO;
import tools.RoomType;
import tools.TypeRoomInfo;

public class RoomDataService_Driver {
      public void drive(RoomDataService roomDataService){
    	List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
  	 	TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("23333","荣华大酒店",
  				RoomType.Single,5,180.0);
  		typeList.add(typeRoomInfo1);
  		HotelRoomInfo hotelRoomInfoPO = new HotelRoomInfo("23333","荣华大酒店",typeList);
  		System.out.println(roomDataService.addRoomInfo(hotelRoomInfoPO));
  		System.out.println(roomDataService.getRoomInfo("asd").
  				getTypeRoomInfo().get(0).getPrice());
  		System.out.println(roomDataService.modifyRoomInfo(hotelRoomInfoPO));
  		
  		RoomDescription description = new RoomDescription("卫生间");
  		
		RoomPO roomPo = new RoomPO("2333",
				"301", "荣华大酒店", RoomType.Single, 180.00,description, null);
  		
  		System.out.println(roomDataService.addRoom(roomPo));
  		System.out.println(roomDataService.deleteRoom("233", "301"));
  		System.out.println(roomDataService.getRoom("asd", "ssdf").getHotelName());
  		System.out.println(roomDataService.modifyRoomState(roomPo));
  		
  		
      }
}
