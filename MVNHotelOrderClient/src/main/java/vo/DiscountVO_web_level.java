package vo;

import po.DiscountPO_web_level;
import tools.DiscountState;
import tools.Strategy_webType;
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

	public DiscountVO_web_level(Strategy_webType strategy_webType,double discount,int level, int levelUpCredit){
		this.discount=discount;
		this.level=level;
		this.levelUpCredit = levelUpCredit;
		this.type = Strategy_webType.Level;
		this.discountState = DiscountState.valid;
	}
	public int level;// 会员等级

	public int levelUpCredit;// 升级所需信用

}
