package vo;

import tools.Strategy_hotelType;

/**
 * 
 * @author LWY
 *
 */

public class StrategyVO_hotel {

	public Strategy_hotelType type;

	public double discount;

	public StrategyVO_hotel(double discount, Strategy_hotelType type) {
		this.discount = discount;
		this.type = type;
	}
}
