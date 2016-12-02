package businesslogic.account;

import java.util.List;

import tools.ResultMessage;
import vo.HotelbriefVO;
import vo.HotelInputVO;
import vo.HotelSearchVO;

/**
 * 酒店模块调用接口
 * @author wshwbluebird
 *
 */
public interface HotelInfo {
	/**
	 * 同层调用酒店模块的增加酒店的方法
	 * @param hotelInputVO
	 * @return return
	 */
	public ResultMessage addHotel( HotelInputVO hotelInputVO);
	
	/**
	 * 同层调用酒店模块的搜索酒店的方法
	 * @param hotelSearchVO
	 * @return List<HotelInfoPO> 
	 */
	public List<HotelbriefVO> searchHotel(HotelSearchVO hotelSearchVO);
	
	/**
	 * 同层调用酒店模块的获取酒店基本信息的方法
	 * @param hotel_id
	 * @return HotelInfoVO
	 */
	public HotelbriefVO getHotelDetail(String hotel_id);
}
