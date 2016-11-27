package po;

import java.util.Date;

import tools.Strategy_hotelType;
/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_hotel {
	
	private Strategy_hotelType type;
	private String Discount_id;
	private double discount;
	private Date startDate;
	private Date EndDate;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getDiscount_id() {
		return Discount_id;
	}
	public double getDiscount() {
		return discount;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public Strategy_hotelType getType() {
		return type;
	}


}
