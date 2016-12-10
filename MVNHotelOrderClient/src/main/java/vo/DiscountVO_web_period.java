package vo;

import java.time.LocalDate;

import org.junit.experimental.theories.Theories;

import po.DiscountPO_web_period;
import tools.DiscountState;
import tools.Strategy_webType;
/**
 * 
 * @author LWY
 *
 */
public class DiscountVO_web_period extends DiscountVO_web {
	
	public DiscountVO_web_period(DiscountPO_web_period discountPO_web) {
		this.startDate =discountPO_web.getStartdate();
		this.endDate = discountPO_web.getEnddate();
		this.type=discountPO_web.getType();
		this.discountState=discountPO_web.getDiscountState();
		this.discount=discountPO_web.getDiscount();
		this.discountID=discountPO_web.getDiscountID();
	}
	public  DiscountVO_web_period(LocalDate startDate,LocalDate endDate,double discount){
		this.startDate =startDate;
		this.endDate = endDate;
		this.discount=discount*0.1;
		this.type=Strategy_webType.Period;
		this.discountState=DiscountState.valid;
	}
	public LocalDate startDate;//可打折开始时间

	public LocalDate endDate;

}
