package vo;

import java.util.List;

import tools.RoomType;
import tools.TypeRoomInfo;

public class HotelRoomInfoVO {
		public String hotelID;
		public String hotelName;
		public List<TypeRoomInfo> typeRoomInfo;
		
		public HotelRoomInfoVO(String hotelID,String hotelName,
				List<TypeRoomInfo> typeRoomInfo){
			this.hotelID = hotelID;
			this.hotelName = hotelName;
			this.typeRoomInfo = typeRoomInfo;
		}
}
