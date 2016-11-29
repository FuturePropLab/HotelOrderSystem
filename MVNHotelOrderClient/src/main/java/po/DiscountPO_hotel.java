package po;

import java.util.Calendar;
import java.util.Date;

import tools.DiscountState;
import tools.Strategy_hotelType;
/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_hotel {
	
	private DiscountState discountState;

	private Strategy_hotelType type;
	
	private String Discount_id;
	
	private double discount;
	
	private Calendar startDate;
	
	private Calendar EndDate;
	
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	public String getDiscount_id() {
		return Discount_id;
	}
	public double getDiscount() {
		return discount;
	}
	public Calendar getEndDate() {
		return EndDate;
	}
	public void setEndDate(Calendar endDate) {
		EndDate = endDate;
	}
	public Strategy_hotelType getType() {
		return type;
	}
	public DiscountState getDiscountState() {
		return discountState;
	}
	public void setDiscountState(DiscountState discountState) {
		this.discountState = discountState;
	}


}
