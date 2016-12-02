package businesslogicservice;

import tools.ResultMessageDiscount;
/**
 * 
 * @author lwy
 * 分离接口，有待进一步修改
 *
 */
public interface DiscountDealService {
	public ResultMessageDiscount invalidDiscount(String discount_id);
//	public List<DiscountVO> checkDiscount(DiscountSearchVO dsvo);
}
