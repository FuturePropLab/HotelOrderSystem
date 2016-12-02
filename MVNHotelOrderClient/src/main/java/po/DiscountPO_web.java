package po;

import tools.DiscountState;
import tools.Strategy_webType;

public class DiscountPO_web {
	
	private Strategy_webType type;
	
	private DiscountState discountState;//策略状态
	
	private double discount;
	
	private String discountID;
	
	
	public Strategy_webType getType() {
		return type;
	}

	public void setType(Strategy_webType type) {
		this.type = type;
	}

	public DiscountState getDiscountState() {
		return discountState;
	}

	public void setDiscountState(DiscountState discountState) {
		this.discountState = discountState;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDiscountID() {
		return discountID;
	}


}
