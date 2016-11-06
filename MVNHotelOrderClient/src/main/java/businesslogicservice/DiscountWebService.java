package businesslogicservice;

import tools.ResultMessage;
import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_web;

public interface DiscountWebService {

	public ResultMessage2 addWebDiscount (DiscountVO_web dis);
	public DiscountVO_web editWebDiscount (String Discount_id);
	//public DiscountVO getAHotelDiscount (String Discount_id);
	public ResultMessage2 saveDiscount (DiscountVO discount);
	
	
}
