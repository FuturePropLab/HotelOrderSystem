package dataservice;

import po.DiscountPO_hotel;
import tools.ResultMessage2;

public interface HotelDiscountDataService {
	ResultMessage2 addHotelDiscount(String hotel_id,DiscountPO_hotel dis);
}
