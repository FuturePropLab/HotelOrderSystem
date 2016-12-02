package businesslogicservice;

import java.util.List;

import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import vo.DiscountVO_web;

public interface DiscountWebService {

	public ResultMessage_strategy addWebDiscount (DiscountVO_web dis);
	public ResultMessageDiscount editWebDiscount (DiscountVO_web dis);
	public List<DiscountVO_web> getWebDiscount ();
	public ResultMessageDiscount deleteDiscount (String discountID);
	
	
}
