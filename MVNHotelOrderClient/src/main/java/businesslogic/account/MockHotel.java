package businesslogic.account;

import java.util.List;

import tools.ResultMessage;
import vo.HotelbriefVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;

/**
 * MockHotel 模拟实现同层调用接口
 * @author wshwbluebird
 *
 */
public class MockHotel  implements HotelInfo {
	
	private List<HotelbriefVO> hotelList;
	private HotelbriefVO hotelInfoVO;
	public ResultMessage addHotel(HotelInputVO hotelInputVO) {
		if(hotelInputVO!=null)  
			return ResultMessage.Exist;
		return ResultMessage.NotExist;

	}

	public List<HotelbriefVO> searchHotel(HotelSearchVO hotelSearchVO) {	
		return hotelList;
	}
	
	/**
	 * 初始化
	 * @param hotelList
	 * @param hotelInfoVO
	 */
	public MockHotel(List<HotelbriefVO> hotelList,HotelbriefVO hotelInfoVO){
		this.hotelList = hotelList;
		this.hotelInfoVO = hotelInfoVO;
	}

	public HotelbriefVO getHotelDetail(String hotel_id) {
		return hotelInfoVO;
	}

}
