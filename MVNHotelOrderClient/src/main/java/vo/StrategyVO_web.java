package vo;

import po.StrategyPO_web;
import tools.Strategy_webType;

/**
 * 
 * @author LWY
 *
 */
public class StrategyVO_web {

	public Strategy_webType type;

	public double discount;

	public StrategyVO_web(StrategyPO_web strategyPO_web) {

		this.discount =strategyPO_web. getDiscount();
		this.type = strategyPO_web.getType();
	}

}
