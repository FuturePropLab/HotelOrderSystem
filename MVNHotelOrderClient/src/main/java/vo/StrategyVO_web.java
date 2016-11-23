package vo;

import tools.Strategy_webType;

/**
 * 
 * @author LWY
 *
 */
public class StrategyVO_web {

	public Strategy_webType type;

	public double discount;

	public StrategyVO_web(double discount, Strategy_webType type) {

		this.discount = discount;
		this.type = type;
	}

}
