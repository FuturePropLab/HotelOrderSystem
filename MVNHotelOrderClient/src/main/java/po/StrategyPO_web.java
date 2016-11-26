package po;

import tools.Strategy_webType;

public class StrategyPO_web {

	private Strategy_webType type;

	private double discount;

	public StrategyPO_web(double discount, Strategy_webType type) {

		this.discount = discount;
		this.type = type;
	}


	public Strategy_webType getType() {
		return type;
	}

	public double getDiscount() {
		return discount;
	}
	
}
