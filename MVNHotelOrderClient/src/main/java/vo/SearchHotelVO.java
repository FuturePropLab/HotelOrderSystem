package vo;

import tools.DateRange;
import tools.PriceRange;
import tools.RoomType;
import tools.Star;
/**
 * 按条件搜索酒店的搜索条件
 * 这个类不是我写的，但是我来维护
 * @author zjy
 *
 */
public class SearchHotelVO {
	public String city;
	public String district;
	public String businessCircle;
	public String hotelName;
	public PriceRange priceRange;
	public Star star;
	public RoomType roomType;
	public boolean booked;//是否要是以前预订过的酒店
	
	/**
	 * 
	 * @param city 城市名，不带“市”字
	 * @param district 区，如栖霞区
	 * @param businessCircle 商圈名
	 * @param hotelName 酒店名称，即用户输入的酒店名称，大部分情况下不是全名
	 * @param priceRange 价格区间
	 * @param star 星级
	 * @param roomType 房间类型
	 * @param booked 是否一定要是以前预订过的酒店
	 */
	public SearchHotelVO(String city, String district, String businessCircle, String hotelName, PriceRange priceRange,
			Star star, RoomType roomType, boolean booked) {
		super();
		this.city = city;
		this.district = district;
		this.businessCircle = businessCircle;
		this.hotelName = hotelName;
		this.priceRange = priceRange;
		this.star = star;
		this.roomType = roomType;
		this.booked = booked;
	}
}
