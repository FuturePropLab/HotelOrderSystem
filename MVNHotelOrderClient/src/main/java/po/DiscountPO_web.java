package po;

import tools.DiscountState;
import tools.Strategy_webType;
/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_web {
	
	private Strategy_webType type;
	
	private DiscountState discountState;//策略状态，valid，invalid
	
	private double discount;
	
	private String discountID;
	
	private String remarks;//备注
	
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
