package po;
import java.time.LocalDate;

import javax.persistence.Entity;

import tools.DiscountState;
import tools.Strategy_webType;

/**
 * 
 * @author wsw
 * 
 * 特定期间网站促销策略PO
 */
@Entity
public class DiscountPO_web_period extends DiscountPO_web{
	
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
	
	//for hibernate 
	public DiscountPO_web_period(){
		
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
