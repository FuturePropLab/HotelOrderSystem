package vo;

import java.time.LocalDate;

import po.DiscountPO_web_period;

public class DiscountVO_web_period extends DiscountVO_web {
	public DiscountVO_web_period(DiscountPO_web_period discountPO_web) {
		// TODO Auto-generated constructor stub
		this.discount=discountPO_web.getDiscount();
		this.startdate =discountPO_web.getStartdate();
		this.enddate = discountPO_web.getEnddate();
	}

	public double discount;

	public LocalDate startdate;

	public LocalDate enddate;

}
