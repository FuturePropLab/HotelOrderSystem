package po;
import java.time.LocalDate;

import vo.DiscountVO_web_period;
public class DiscountPO_web_period extends DiscountPO_web{
	
	private double discount;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	public DiscountPO_web_period(double discount , LocalDate startDate ,LocalDate endDate ){
		this.discount=discount;
		this.startDate=startDate;
		this.endDate=endDate;
	}
	public DiscountPO_web_period(DiscountVO_web_period discountVO_web) {
		// TODO Auto-generated constructor stub
		this.discount=discountVO_web.discount;
		this.startDate=discountVO_web.startDate;
		this.endDate=discountVO_web.endDate;
	}
	public LocalDate getEnddate() {
		return endDate;
	}
	
	public void setEnddate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public LocalDate getStartdate() {
		return startDate;
	}
	
	public void setStartdate(LocalDate startDate) {
		this.startDate = startDate;
	}
	

	
}	
