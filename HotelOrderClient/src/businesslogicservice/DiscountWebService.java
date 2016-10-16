package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.DiscountVO;

public interface DiscountWebService {

	public ResultMessage addWebDiscount (DiscountVO dis);
	public DiscountVO editHotelDiscount (String Discount_id);
	public DiscountVO getAHotelDiscount (String Discount_id);
	public ResultMessage saveDiscount (DiscountVO discount);
	
	
}
