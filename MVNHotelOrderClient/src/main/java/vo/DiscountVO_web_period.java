package vo;

import java.time.LocalDate;

import po.DiscountPO_web_period;
/**
 * 
 * @author LWY
 *
 */
public class DiscountVO_web_period extends DiscountVO_web {
	public DiscountVO_web_period(DiscountPO_web_period discountPO_web) {
		this.discount=discountPO_web.getDiscount();
		this.startDate =discountPO_web.getStartdate();
		this.endDate = discountPO_web.getEnddate();
	}

	public double discount;

	public LocalDate startDate;//可打折开始时间

	public LocalDate endDate;

}
