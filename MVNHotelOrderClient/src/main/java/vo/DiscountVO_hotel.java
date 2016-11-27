package vo;

import java.util.Date;

public class DiscountVO_hotel extends DiscountVO{
	public String Discount_id;
	public double discount;
	public Date startDate;
	public Date EndDate;
	public DiscountVO_hotel( String id,double discount,Date start,Date End){
		this.Discount_id=id;
		this.discount=discount;
		this.startDate=start;
		this.EndDate=End;
	}

}
