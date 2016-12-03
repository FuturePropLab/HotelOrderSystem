package businesslogicservice;

import java.util.List;

import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import tools.Strategy_webType;
import vo.DiscountVO_web;
/**
 * 
 * @author LWY
 *
 */
public interface DiscountWebService {

	public ResultMessage_strategy addWebDiscount (DiscountVO_web dis);
	
	public ResultMessageDiscount editWebDiscount (DiscountVO_web dis);
	/**
	 * 得到網站的所有促銷策略
	 * @return
	 */
	public List<DiscountVO_web> getWebDiscount ();
	/**
	 * 
	 * @param type
	 * @return 根據類型得到網站促銷策略
	 */
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type) ;
	
	public ResultMessageDiscount deleteDiscount (String discountID);
	
	/**
	 * 
	 * @param discount_id
	 * @return 将策略设置为无效
	 */
	public ResultMessageDiscount invalidDiscount(String discount_id);
	
}
