package businesslogic.order;

import Exception.OutOfBoundsException;
import tools.Mark;
import tools.Star;
import vo.HotelRoomInfoVO;
import vo.HotelbriefVO;
/**
 * 
 * @author zjy
 *
 */
public class MockHotelInfo implements HotelInfo{

	public HotelbriefVO getHotelInfo(String hotelID) {
		HotelbriefVO hotelInfoVO = null;
		hotelInfoVO=new HotelbriefVO(null);
		return hotelInfoVO;
	}

}
