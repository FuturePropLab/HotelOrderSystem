package vo;

import tools.DateRange;
import tools.PriceRange;
import tools.RoomType;
import tools.Star;

public class SearchHotelVO {
	public String address;
	public String district;
	public String hotelName;
	public RoomType roomType;
	public PriceRange priceRange;
	public DateRange availableDate;//有空房期间
	public Star star;
	public boolean booked;//是否要是以前预订过的酒店
}
