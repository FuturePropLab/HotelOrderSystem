package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_hotel;

public interface DiscountHotelService {
	
	public ResultMessage2 addHotelDiscount(String hotel_id);
	public DiscountVO_hotel editHotelDiscount (String Discount_id);
	public DiscountVO_hotel getSingleHotelDiscount (String Discount_id);
	public List<DiscountVO_hotel>getHotelDiscount (String hotel_id);
}
