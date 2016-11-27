package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_hotel;

public interface DiscountHotelService {
	
	public ResultMessage2 addHotelDiscount(String hotel_id,DiscountVO_hotel discountVO_hotel);
	public ResultMessage2 editHotelDiscount (String discount_id,DiscountVO_hotel discountVO_hotel);
//	public DiscountVO_hotel getSingleHotelDiscount (String discount_id);
	public List<DiscountVO_hotel>getHotelDiscount (String hotel_id);
}
