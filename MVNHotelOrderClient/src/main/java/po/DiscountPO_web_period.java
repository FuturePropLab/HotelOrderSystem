package po;
import java.time.LocalDate;
import vo.DiscountVO_web_period;

/**
 * 
 * @author LWY
 * 特定期间网站促销策略PO
 */
public class DiscountPO_web_period extends DiscountPO_web{
	
	private LocalDate startDate;//特定期间折扣的开始时间
	
	private LocalDate endDate;
	
	public DiscountPO_web_period(double discount , LocalDate startDate ,LocalDate endDate ){
		super.setDiscount(discount);
		this.startDate=startDate;
		this.endDate=endDate;
	}
	public DiscountPO_web_period(DiscountVO_web_period discountVO_web) {
		// TODO Auto-generated constructor stub
		super.setDiscount(discountVO_web.discount);
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
