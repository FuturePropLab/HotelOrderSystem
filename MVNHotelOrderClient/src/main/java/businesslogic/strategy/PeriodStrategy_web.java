package businesslogic.strategy;

import vo.DiscountVO_web;
import vo.DiscountVO_web_period;
import vo.OrderInputCalVO;

/**
 * 特定期间优惠算法
 * 
 * @author LWY
 *
 */
public class PeriodStrategy_web implements WebStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO, DiscountVO_web discountVO_web) {

		double res = 0;
		
		long day = orderInputCalVO.orderDate.toEpochDay();
		
		DiscountVO_web_period discountVO_web_period = (DiscountVO_web_period) discountVO_web;

		if (day < discountVO_web_period.endDate.toEpochDay() && day >= discountVO_web_period.startDate.toEpochDay()) {
			
			res = (discountVO_web_period.discount - 1) * orderInputCalVO.numberOfRooms * orderInputCalVO.price;

		}
		System.out.println(res);
		return res;
	}

}
