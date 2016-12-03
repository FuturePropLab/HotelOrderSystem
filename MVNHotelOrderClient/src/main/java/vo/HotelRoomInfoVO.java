package vo;

import java.util.List;

import tools.HotelRoomInfo;
import tools.TypeRoomInfo;

public class HotelRoomInfoVO {
		public String hotelID;
		public String hotelName;
		public List<TypeRoomInfo> typeRoomInfo;


		/**
		 *  @param hotelID  酒店ID
		 *  @param hotelName  酒店名字
		 *  @param typeRoomInfo  类型房间信息
		 */
		public HotelRoomInfoVO(String hotelID,String hotelName,
				List<TypeRoomInfo> typeRoomInfo){
			this.hotelID = hotelID;
			this.hotelName = hotelName;
			this.typeRoomInfo = typeRoomInfo;
		}
		
		public HotelRoomInfoVO(HotelRoomInfo hotelRoomInfo){
			this.hotelID= hotelRoomInfo.getHotelID();
			this.hotelName = hotelRoomInfo.getHotelName();
			this.typeRoomInfo = hotelRoomInfo.getTypeRoomInfo();
		}
}
