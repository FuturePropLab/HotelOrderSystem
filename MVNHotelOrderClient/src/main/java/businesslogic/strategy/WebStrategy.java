package businesslogic.strategy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.DiscountGet;
import vo.OrderInputCalVO;
import vo.StrategyVO_web;
/**
 * 
 * @author LinWenye
 *
 */

public class WebStrategy {
	
	private List<StrategyVO_web> strategyList;

	public WebStrategy(OrderInputCalVO orderInput) {
		
		StrategyGetService discount = new DiscountGet();
		strategyList = discount.getSuitableDiscount_web(orderInput);
		
//		DiscountGetService disDealService = new MockDiscount("web");//桩程序
//		
//		strategyList = disDealService.getSuitableDiscount_web(orderInput);
	}
/**
 * 计算得到最优
 * @return 最优策略
 */
	public List<StrategyVO_web> calBest() {

		double min = 1.0;
		List<StrategyVO_web> res = new LinkedList<StrategyVO_web>(null);
		
		Iterator iter = strategyList.iterator();
	
		while (iter.hasNext()) {
//			StrategyVO_web discountVO_web = (StrategyVO_web) iter.next();
//			if (discountVO_web.discount < min) {
//
//				min = discountVO_web.discount;
//				res=discountVO_web;
//				
//			}
		}
		return res;
		
//		return (DiscountVO_web) strategyList.get(0);
	}
}
