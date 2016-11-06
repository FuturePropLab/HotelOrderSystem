package businesslogic.hotel;

import java.util.List;

import vo.DiscountVO;
import vo.DiscountVO_hotel;

public interface getDiscountInfo {
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id);
}
