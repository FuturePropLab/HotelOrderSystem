package vo;

import po.DiscountPO_web_level;
/**
 * 
 * @author LWY
 *
 */
public class DiscountVO_web_level extends DiscountVO_web {
	public DiscountVO_web_level(DiscountPO_web_level discountPO_web) {
		this.type=discountPO_web.getType();
		this.discountState=discountPO_web.getDiscountState();
		this.discount=discountPO_web.getDiscount();
		this.discountID=discountPO_web.getDiscountID();
		this.level=discountPO_web.getLv();
		this.levelUpCredit=discountPO_web.getLevelUpCredit();
	}

	public int level;// 会员等级

	public int levelUpCredit;// 升级所需信用

}
