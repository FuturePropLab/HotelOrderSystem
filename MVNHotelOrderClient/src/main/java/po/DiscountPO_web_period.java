package po;
import java.time.LocalDate;

import vo.DiscountVO_web_period;
public class DiscountPO_web_period extends DiscountPO_web{
	
	private double discount;
	
	private LocalDate startdate;
	
	private LocalDate enddate;
	
	public DiscountPO_web_period(double discount , LocalDate startdate ,LocalDate enddate ){
		this.discount=discount;
		this.startdate=startdate;
		this.enddate=enddate;
	}
	public DiscountPO_web_period(DiscountVO_web_period discountVO_web) {
		// TODO Auto-generated constructor stub
		this.discount=discountVO_web.discount;
		this.startdate=discountVO_web.startdate;
		this.enddate=discountVO_web.enddate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	
	public LocalDate getStartdate() {
		return startdate;
	}
	
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	

	
}	
