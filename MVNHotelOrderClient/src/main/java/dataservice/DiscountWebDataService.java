package dataservice;

import java.util.List;

import po.DiscountPO_web;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import vo.DiscountVO_web;
/**
 * 
 * @author LWY
 *
 */
public interface DiscountWebDataService {
	
	/**
	 * DiscountPO_web传过去的对象需要根据具体的type判断，应向下转型为哪种类型（好担心这个设计不是很好~~
	 * @return 成功或者失败(1.与已有的冲突：时间冲突，商圈冲突等；2.已经存在）
	 */
	public ResultMessage_strategy addWebDiscount (DiscountPO_web dis);
	
	public ResultMessageDiscount editWebDiscount (DiscountPO_web discountPO_web);
	
	/**
	 * 
	 * @return 一次性拿网站的所有促销策略
	 */
	public List<DiscountPO_web> getWebDiscount ();
	
	public ResultMessageDiscount deleteWebDiscount (String discount_id);
}
