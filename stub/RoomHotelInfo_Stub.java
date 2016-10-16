package stub;

import java.util.ArrayList;
import java.util.List;

import bussinesslogicservice.RoomHotelInfoService;
import tools.ResultMessage;
import tools.RoomType;
import tools.TypeRoomInfo;
import vo.HotelRoomInfoVO;

public class RoomHotelInfo_Stub implements RoomHotelInfoService {

	@Override
	public HotelRoomInfoVO getRoomInfo(String hotel_id) {
		
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo(hotel_id,"荣华大酒店",
				RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO(hotel_id,"荣华大酒店",typeList);
		return hotelRoomInfoVO;
	}

	@Override
	public HotelRoomInfoVO editRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo(hotelRoomInfo.hotelID,hotelRoomInfo.hotelName,
				RoomType.Double,10,180.0);;
		
		HotelRoomInfoVO hotelRoomInfoVO = hotelRoomInfo;
		hotelRoomInfoVO.typeRoomInfo.add(typeRoomInfo1);
		
		return hotelRoomInfoVO;
	}

	@Override
	public ResultMessage saveRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		if(hotelRoomInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	
	}

}
