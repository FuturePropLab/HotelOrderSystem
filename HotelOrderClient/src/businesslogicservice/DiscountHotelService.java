package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.DiscountVO;

public interface DiscountHotelService {
	
	public DiscountVO addHotelDiscount(String hotel_id);
	public DiscountVO editHotelDiscount (String Discount_id);
	public DiscountVO getSingleHotelDiscount (String Discount_id);
	public List<DiscountVO>getHotelDiscount (String hotel_id);
}
