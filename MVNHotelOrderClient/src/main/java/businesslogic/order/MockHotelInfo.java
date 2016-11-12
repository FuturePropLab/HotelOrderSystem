package businesslogic.order;

import Exception.OutOfBoundsException;
import tools.Mark;
import tools.Star;
import vo.HotelInfoVO;
import vo.HotelRoomInfoVO;
/**
 * 
 * @author zjy
 *
 */
public class MockHotelInfo implements HotelInfo{

	public HotelInfoVO getHotelInfo(String hotelID) {
		HotelInfoVO hotelInfoVO = null;
		try {
			hotelInfoVO=new HotelInfoVO(hotelID, "hotelName", "hotelAddress", "district", new Mark(5.0), 
					"introduction", "facility", new HotelRoomInfoVO(hotelID, "hotelName", null), Star.five);
		} catch (OutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotelInfoVO;
	}

}
