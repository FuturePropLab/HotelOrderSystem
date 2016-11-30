package businesslogicservice;

import tools.ResultMessage_Hotel;
import vo.HotelInfoVO;
import vo.HotelInputVO;

public interface ManageHotelInfoService {
	/**
	 * 增加酒店的信息
	 * @param vo
	 * @return
	 */
	public ResultMessage_Hotel addHotel( HotelInputVO vo);
	
	
	/**
	 * 修改酒店的信息
	 * @param hotelInfo
	 * @return
	 */
	public ResultMessage_Hotel saveHotelInfo (HotelInfoVO hotelInfo);
	
	
}
