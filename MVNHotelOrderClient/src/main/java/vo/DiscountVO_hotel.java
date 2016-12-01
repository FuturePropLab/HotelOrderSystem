package vo;

import java.time.LocalDate;

import tools.Strategy_hotelType;

public class DiscountVO_hotel extends DiscountVO{
	
	public  Strategy_hotelType type;
	public String discountID;
	public double discount;
	public LocalDate startDate;
	public LocalDate endDate;
	public String remarks;
	public boolean superimpose;
	public DiscountVO_hotel( String id,double discount,LocalDate start,LocalDate end,String remarks,boolean superimpose){
		this.discountID=id;
		this.discount=discount;
		this.startDate=start;
		this.endDate=end;
		this.remarks=remarks;
		this.superimpose=superimpose;
	}

}
