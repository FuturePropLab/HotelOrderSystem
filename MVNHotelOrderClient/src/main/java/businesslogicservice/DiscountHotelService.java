package businesslogicservice;

import java.util.List;

import tools.ResultMessage_strategy;
import vo.DiscountVO_hotel;

public interface DiscountHotelService {
	
	public ResultMessage_strategy addHotelDiscount(String hotel_id,DiscountVO_hotel discountVO_hotel);
	public ResultMessage_strategy editHotelDiscount (String discount_id,DiscountVO_hotel discountVO_hotel);
	public ResultMessage_strategy deleteHotelDiscount(String hotel_id,String discount_id);
//	public DiscountVO_hotel getSingleHotelDiscount (String discount_id);
	public List<DiscountVO_hotel> getHotelDiscount (String hotel_id);
}
