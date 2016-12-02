package stub;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.ManageHotelInfoService;
import tools.ResultMessage_Hotel;
import tools.RoomType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.HotelInputVO;
import vo.HotelRoomInfoVO;
import vo.HotelbriefVO;

public class ManageHotelInfo_Stub implements ManageHotelInfoService {


	public ResultMessage_Hotel addHotel(HotelInputVO vo) {
		// TODO Auto-generated method stub
		if(vo==null){return ResultMessage_Hotel.fail;
		}else{
			return ResultMessage_Hotel.success;
		}
	}
		
	

	public HotelbriefVO editHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
	
		
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelbriefVO hotelinfo=new HotelbriefVO(null);
		
		return hotelinfo;
	}

	
	public ResultMessage_Hotel saveHotelInfo(HotelbriefVO hotelInfo) {
		// TODO Auto-generated method stub
		//HotelInfoVO hotelinfo=new HotelInfoVO(hotel_id,"hotel1", "nanjing","xinjiekou","2738","sda","dasd",null,Star.one);
		return ResultMessage_Hotel.success;
	}



	public ResultMessage_Hotel saveHotelInfo(HotelInputVO hotelInputVO) {
		// TODO Auto-generated method stub
		return null;
	}



	public ResultMessage_Hotel modifyHotelPicture(String hotelID, URI uri) {
		// TODO Auto-generated method stub
		return null;
	}

}
