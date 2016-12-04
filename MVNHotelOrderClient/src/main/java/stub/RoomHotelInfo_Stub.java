package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogicservice.RoomManageService;
import tools.ResultMessage;
import tools.ResultMessage_Room;
import tools.RoomType;
import tools.TypeRoomInfo;
import vo.HotelRoomInfoVO;
import vo.RoomDescriptionVO;

public class RoomHotelInfo_Stub implements RoomManageService {

	
	public HotelRoomInfoVO getRoomInfo(String hotel_id) {
		
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo(hotel_id,"荣华大酒店",
				RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO(hotel_id,"荣华大酒店",typeList);
		return hotelRoomInfoVO;
	}

	
	public HotelRoomInfoVO editRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo(hotelRoomInfo.hotelID,hotelRoomInfo.hotelName,
				RoomType.Double,10,180.0);;
		
		HotelRoomInfoVO hotelRoomInfoVO = hotelRoomInfo;
		hotelRoomInfoVO.typeRoomInfo.add(typeRoomInfo1);
		
		return hotelRoomInfoVO;
	}


	public ResultMessage saveRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		if(hotelRoomInfo!=null)  return ResultMessage.Exist;
				return ResultMessage.NotExist;
	
	}


	public RoomDescriptionVO getRoomInfo(String hotel_id, RoomType roomType) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage_Room saveRoomInfo(String hotelID, RoomDescriptionVO roomDescriptionVO) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getAllRoomByType(String hotelID, RoomType roomType) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getAvaiableRoomBytime(String hotelID, RoomType roomType, Date begin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getAllNumberByType(String hotelID, RoomType roomType) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getAvaiableNumberByTime(String hotelID, RoomType roomType, Date begin, Date end) {
		// TODO Auto-generated method stub
		return 0;
	}

}
