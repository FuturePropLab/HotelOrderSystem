package dataservice;

import java.util.List;

import po.DiscountPO_web;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
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
	public ResultMessage_DiscountDetail addWebDiscount (DiscountPO_web dis);
	
	public ResultMessage_Discount editWebDiscount (DiscountPO_web discountPO_web);
	
	/**
	 * 
	 * @return 一次性拿网站的所有促销策略
	 */
	public List<DiscountPO_web> getWebDiscount ();
	
	public ResultMessage_Discount deleteWebDiscount (String discountID);
	
	/**
	 * 
	 * @param discountID
	 * @return 是否成功，已为无效的不可重复设置无效
	 */
	public ResultMessage_Discount invalidDiscount(String discountID);
}
