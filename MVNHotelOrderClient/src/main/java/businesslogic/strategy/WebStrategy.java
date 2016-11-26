package businesslogic.strategy;

import java.util.Iterator;
import java.util.List;

import businesslogic.discount.DiscountGet;
import businesslogicservice.DiscountGetService;
import vo.OrderInputCalVO;
import vo.OrderInputVO;
import vo.StrategyVO_web;
/**
 * 
 * @author LinWenye
 *
 */

public class WebStrategy {
	private List<StrategyVO_web> strategyList;

	public WebStrategy(OrderInputCalVO orderInput) {
		
		DiscountGetService discount = new DiscountGet();
		strategyList = discount.getSuitableDiscount_web(orderInput);
		
//		DiscountGetService disDealService = new MockDiscount("web");//桩程序
//		
//		strategyList = disDealService.getSuitableDiscount_web(orderInput);
	}
/**
 * 计算得到最优
 * @return 最优策略
 */
	public StrategyVO_web calBest() {

		double min = 1.0;
		StrategyVO_web res = new StrategyVO_web(min, null);
		
		Iterator iter = strategyList.iterator();
	
		while (iter.hasNext()) {
			StrategyVO_web discountVO_web = (StrategyVO_web) iter.next();
			if (discountVO_web.discount < min) {

				min = discountVO_web.discount;
				res=discountVO_web;
				
			}
		}
		return res;
		
//		return (DiscountVO_web) strategyList.get(0);
	}
}
