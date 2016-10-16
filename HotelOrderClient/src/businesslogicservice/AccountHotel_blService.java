package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.HotelAccountVO;
import vo.SearchConditionVO;

public interface AccountHotel_blService {
	public ResultMessage addHotelAccount (HotelAccountVO hotelAccount);
	public ResultMessage modifyHotelAccount (HotelAccountVO hotelAccount);
	public HotelAccountVO getHotelAccount(String hotel_id);
	public ResultMessage deleteHotelAccount (String hotel_id);
	public List<HotelAccountVO>searchHotelAccount (SearchConditionVO vo);
}
