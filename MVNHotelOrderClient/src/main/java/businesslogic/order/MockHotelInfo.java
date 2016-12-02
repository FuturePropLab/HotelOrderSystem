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
		try {
			hotelInfoVO=new HotelbriefVO(null, null, hotelID, "hotelName", "hotelAddress", "district", new Mark(5.0), 
					"introduction", "facility", new HotelRoomInfoVO(hotelID, "hotelName", null), Star.five);
		} catch (OutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotelInfoVO;
	}

}
