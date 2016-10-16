package businesslogicservice;

import tools.ResultMessage;
import tools.ResultMessage2;
import vo.HotelInfoVO;
import vo.HotelInputVO;

public interface ManageHotelInfoService {
	public ResultMessage2 addHotel( HotelInputVO vo);
	public HotelInfoVO editHotelInfo (String hotel_id);
	public ResultMessage2 saveHotelInfo (HotelInfoVO hotelInfo);
	
	
}
