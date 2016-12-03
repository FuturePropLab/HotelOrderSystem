package vo;

import java.net.URI;

import tools.HotelAddress;
import tools.Star;

/**
 * 酒店详细信息
 * @author zjy
 *
 */
public class HotelDetailsVO {
	
	public String hotelID;
	public String hotelName;
	public URI hotelImage;
	public Star star;
	public HotelAddress hotelAddress;
	public HotelDiscribtionsVO hotelDiscribtionsVO;
	public HotelRoomInfoVO hotelRoomInfoVO;
	public HotelFacilityVO hotelFacilityVO;
	public HotelAssessVO hotelAssessVO;
}
