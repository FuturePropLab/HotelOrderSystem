package vo;

import tools.PriceRange;
import tools.Star;

/**
 * 酒店管理人员查询酒店的值对象
 * @author wshwbluebird
 *
 */
public class HotelSearchVO {
	public String address;
	public String district;
	public String hotelName;
	public String hotel_id;
	public PriceRange priceRange;
	public Star star;

	/**
	 * 初始化值对象
	 * @param address
	 * @param district
	 * @param hotelName
	 * @param roomType
	 * @param priceRange
	 * @param availableDate
	 * @param star
	 * @param booked
	 */
	public HotelSearchVO(String address, String district,String hotel_id, 
			String hotelName, PriceRange priceRange, Star star) {
		super();
		this.address = address;
		this.district = district;
		this.hotelName = hotelName;
		this.priceRange = priceRange;
		this.hotel_id = hotel_id;
		this.star = star;
	
	}
}
