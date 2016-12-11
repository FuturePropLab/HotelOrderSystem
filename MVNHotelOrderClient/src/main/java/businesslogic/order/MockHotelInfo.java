package businesslogic.order;

import Exception.OutOfBoundsException;
import tools.HotelAddress;
import tools.Mark;
import tools.PriceRange;
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
		HotelbriefVO hotelInfoVO = new HotelbriefVO();
		if(hotelID=="123"){hotelInfoVO.averagePrice=100;
		hotelInfoVO.hotelAddress=new HotelAddress("city", "district", "businessCircle", "addressDetail");
		hotelInfoVO.hotelID="hotelID";
		hotelInfoVO.hotelName="hotelName";
		try {
			hotelInfoVO.mark=new Mark(2.2);
			hotelInfoVO.priceRange=new PriceRange(100, 100);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}
		hotelInfoVO.star=Star.one;
		return hotelInfoVO;}
		else if(hotelID=="124"){
			hotelInfoVO.averagePrice=100;
			hotelInfoVO.hotelAddress=new HotelAddress("city", "district", "businessCircle", "addressDetail");
			hotelInfoVO.hotelID="hotelID";
			hotelInfoVO.hotelName="hotelName";
			try {
				hotelInfoVO.mark=new Mark(3);
				hotelInfoVO.priceRange=new PriceRange(100, 100);
			} catch (OutOfBoundsException e) {
				e.printStackTrace();
			}
			hotelInfoVO.star=Star.one;
			return hotelInfoVO;
		}
		return hotelInfoVO;
	}

}
