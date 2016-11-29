package vo;

import po.DiscountPO_web;
import tools.Strategy_webType;

/**
 * 
 * @author LWY
 *
 */
public class StrategyVO_web {

	public Strategy_webType type;

	public double discount;

	public StrategyVO_web(DiscountPO_web strategyPO_web) {

		this.discount =strategyPO_web. getDiscount();
		this.type = strategyPO_web.getType();
	}

}
