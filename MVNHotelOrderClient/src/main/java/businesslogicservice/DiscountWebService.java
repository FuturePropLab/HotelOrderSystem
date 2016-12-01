package businesslogicservice;

import tools.ResultMessage2;
import tools.ResultMessage_strategy;
import vo.DiscountVO;
import vo.DiscountVO_web;

public interface DiscountWebService {

	public ResultMessage_strategy addWebDiscount (DiscountVO_web dis);
	public ResultMessage2 editWebDiscount (String Discount_id);
	public DiscountVO_web getWebDiscount (String Discount_id);
	public ResultMessage_strategy deleteDiscount (DiscountVO discount);
	
	
}
