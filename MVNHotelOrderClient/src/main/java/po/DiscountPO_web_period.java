package po;
import java.io.Serializable;
import java.time.LocalDate;

import tools.DiscountState;
import tools.Strategy_webType;
import vo.DiscountVO_web_period;

/**
 * 
 * @author LWY
 * 特定期间网站促销策略PO
 */
public class DiscountPO_web_period extends DiscountPO_web implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2472299328587709694L;

	private LocalDate startDate;//特定期间折扣的开始时间
	
	private LocalDate endDate;
	
	/**
	 * 
	 * @param discount
	 * @param startDate
	 * @param endDate
	 * @param type
	 * @param discountState
	 * @param remarks
	 */
	public DiscountPO_web_period(double discount , LocalDate startDate ,LocalDate endDate,Strategy_webType type,DiscountState discountState ,String remarks){
		super.setDiscount(discount);
		this.startDate=startDate;
		this.endDate=endDate;
		super.setDiscountState(discountState);
		super.setRemarks(remarks);
		super.setType(type);
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
