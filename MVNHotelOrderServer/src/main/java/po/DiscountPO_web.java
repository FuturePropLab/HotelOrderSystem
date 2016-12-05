package po;

import java.io.Serializable;

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
public class DiscountPO_web implements Serializable {
	private static final long serialVersionUID = -4692890931780645810L;
	@Id
	private String discountID;
	
	private Strategy_webType type;
	
	private DiscountState discountState;//策略状态
	
	private double discount;
	
	private String remarks;//备注
	
	
	
	
	public DiscountPO_web(){
		
	}




	public String getDiscountID() {
		return discountID;
	}




	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}




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



	@Enumerated(EnumType.STRING)
	public void setDiscountState(DiscountState discountState) {
		this.discountState = discountState;
	}




	public double getDiscount() {
		return discount;
	}




	public void setDiscount(double discount) {
		this.discount = discount;
	}



	@Enumerated(EnumType.STRING)
	public String getRemarks() {
		return remarks;
	}
	@Enumerated(EnumType.STRING)
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



}
