package dataservice;

import tools.ResultMessage2;
/**
 * 
 * @author LWY
 *
 */
public interface DiscountDealDataService {
	/**
	 * 
	 * @param discount_id
	 * @return 将过期的策略更改状态
	 */
	ResultMessage2 invalidDiscount(String discount_id);
	
//	public List<DiscountPO> checkDiscount(DiscountSearchPO dsvo);
}
