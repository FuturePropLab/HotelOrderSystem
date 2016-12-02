package businesslogic.order;

import vo.HotelbriefVO;

/**
 * 酒店信息的接口
 * @author zjy
 *
 */
public interface HotelInfo {
	/**
	 * 获取酒店信息
	 * @param hotelID 酒店ID
	 * @return 酒店信息
	 */
	public HotelbriefVO getHotelInfo(String hotelID);
}
