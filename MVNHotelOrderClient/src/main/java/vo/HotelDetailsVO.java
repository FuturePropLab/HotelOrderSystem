package vo;

import java.net.URI;

import tools.HotelAddress;
import tools.Star;
import vo.HotelAssessVO;

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
	public HotelFacilityVO hotelFacilityVO;  //
	public HotelAssessVO  hotelAssessVO;  //
	
	/**
	 * 
	 * @param hotelID 酒店ID
	 * @param hotelName 酒店名称
	 * @param hotelImage 酒店首页的图片
	 * @param star 酒店星级
	 * @param hotelAddress 酒店地址
	 * @param hotelDiscribtionsVO 酒店简介信息
	 * @param hotelRoomInfoVO 酒店房间信息
	 * @param hotelFacilityVO 酒店设施服务信息
	 * @param hotelAssessVO 酒店评价信息
	 */
	public HotelDetailsVO(String hotelID, String hotelName, URI hotelImage, Star star, HotelAddress hotelAddress,
			HotelDiscribtionsVO hotelDiscribtionsVO, HotelRoomInfoVO hotelRoomInfoVO, HotelFacilityVO hotelFacilityVO,
			HotelAssessVO hotelAssessVO) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelImage = hotelImage;
		this.star = star;
		this.hotelAddress = hotelAddress;
		this.hotelDiscribtionsVO = hotelDiscribtionsVO;
		this.hotelRoomInfoVO = hotelRoomInfoVO;
		this.hotelFacilityVO = hotelFacilityVO;
		this.hotelAssessVO = hotelAssessVO;
	}
}
