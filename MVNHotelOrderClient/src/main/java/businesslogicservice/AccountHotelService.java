package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.HotelAccountVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;
import vo.SearchConditionVO;

public interface AccountHotelService {
	public ResultMessage addHotelAccount (HotelAccountVO hotelAccount,HotelInputVO hotelInputVO);
	public ResultMessage modifyHotelAccount (HotelAccountVO hotelAccount);
	public HotelAccountVO getHotelAccount(String hotel_id);
	public ResultMessage deleteHotelAccount (String hotel_id);
	public List<HotelAccountVO>searchHotelAccount (HotelSearchVO vo);
}
