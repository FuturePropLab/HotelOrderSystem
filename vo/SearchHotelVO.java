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
	
	public SearchHotelVO(String address, String district, String hotelName, RoomType roomType, PriceRange priceRange,
			DateRange availableDate, Star star, boolean booked) {
		super();
		this.address = address;
		this.district = district;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.priceRange = priceRange;
		this.availableDate = availableDate;
		this.star = star;
		this.booked = booked;
	}
}
