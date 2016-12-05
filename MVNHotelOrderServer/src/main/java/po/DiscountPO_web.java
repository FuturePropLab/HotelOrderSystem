package po;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import tools.DiscountState;
import tools.Strategy_webType;
/**
 * 
 * @author LWY
 *
 */
@Entity
@Table(name="DiscountPO_web")
@Inheritance(strategy=InheritanceType.JOINED)
public class DiscountPO_web {
	@Id
	private String discountID;
	
	private Strategy_webType type;
	
	private DiscountState discountState;//策略状态
	
	private double discount;
	
	private String remarks;//备注
	
	
	public DiscountPO_web(){
		
	}
	
	@Enumerated(EnumType.STRING)
	public Strategy_webType getType() {
		return type;
	}

	public void setType(Strategy_webType type) {
		this.type = type;
	}
	
	@Enumerated(EnumType.STRING)
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
