package businesslogic.strategy;

import java.util.Iterator;
import java.util.List;

import businesslogic.discount.DiscountCalController;
import businesslogicservice.DiscountGetService;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;
/**
 * 
 * @author LinWenye
 *
 */

public class WebStrategy {
	private List<DiscountVO_web> strategyList;

	public WebStrategy(OrderInputVO orderInput) {
		
//		DiscountGetService disDealService = new MockDiscount("web");//桩程序
//		
//		strategyList = disDealService.getSuitableDiscount_web(orderInput);
		
		DiscountGetService discount = new DiscountCalController();
		strategyList = discount.getSuitableDiscount_web(orderInput);
	}
/**
 * 计算得到最优
 * @return 最优策略
 */
	public DiscountVO_web calBest() {
//		return (DiscountVO_web) strategyList.get(0);

		double min = 1.0;
		DiscountVO_web res = new DiscountVO_web(0, null, min, null, null, 0);
		
		Iterator iter = strategyList.iterator();
	
		while (iter.hasNext()) {
			DiscountVO_web discountVO_web = (DiscountVO_web) iter.next();
			if (discountVO_web.discount < min) {

				min = discountVO_web.discount;
				res=discountVO_web;
				
			}
		}
		return res;
	}
}
