package businesslogic.order;

import vo.HotelInfoVO;

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
	public HotelInfoVO getHotelInfo(String hotelID);
}
