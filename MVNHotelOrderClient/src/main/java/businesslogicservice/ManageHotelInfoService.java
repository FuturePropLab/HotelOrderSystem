package businesslogicservice;

import tools.ResultMessage2;
import tools.ResultMessage_Hotel;
import vo.HotelInfoVO;
import vo.HotelInputVO;

public interface ManageHotelInfoService {
	public ResultMessage_Hotel addHotel( HotelInputVO vo);
	public HotelInfoVO editHotelInfo (String hotel_id);
	public ResultMessage2 saveHotelInfo (HotelInfoVO hotelInfo);
	
	
}
