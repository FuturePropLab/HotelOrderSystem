package dataservice;

import tools.ResultMessageDiscount;
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
	ResultMessageDiscount invalidDiscount(String discount_id);
	
//	public List<DiscountPO> checkDiscount(DiscountSearchPO dsvo);
}
