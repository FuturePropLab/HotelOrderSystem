package businesslogic.account;

import java.util.List;

import tools.ResultMessage;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;

/**
 * MockHotel 模拟实现同层调用接口
 * @author wshwbluebird
 *
 */
public class MockHotel  implements HotelInfo {
	
	private List<HotelInfoVO> hotelList;
	private HotelInfoVO hotelInfoVO;
	public ResultMessage addHotel(HotelInputVO hotelInputVO) {
		if(hotelInputVO!=null)  
			return ResultMessage.Exist;
		return ResultMessage.NotExist;

	}

	public List<HotelInfoVO> searchHotel(HotelSearchVO hotelSearchVO) {	
		return hotelList;
	}
	
	/**
	 * 初始化
	 * @param hotelList
	 * @param hotelInfoVO
	 */
	public MockHotel(List<HotelInfoVO> hotelList,HotelInfoVO hotelInfoVO){
		this.hotelList = hotelList;
		this.hotelInfoVO = hotelInfoVO;
	}

	public HotelInfoVO getHotelDetail(String hotel_id) {
		return hotelInfoVO;
	}

}
