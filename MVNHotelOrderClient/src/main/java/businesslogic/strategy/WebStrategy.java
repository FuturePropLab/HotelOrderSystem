package businesslogic.strategy;

import java.util.List;

import businesslogicservice.DiscountDealService;
import vo.DiscountVO;
import vo.DiscountVO_web;
import vo.OrderInputVO;
/**
 * 
 * @author LinWenye
 *
 */
//调用DiscountDealService得到符合条件的策略，计算出最优

public class WebStrategy {
	private List<DiscountVO_web> strategyList;

	public WebStrategy(OrderInputVO orderInput) {
		
		DiscountDealService disDealService = new MockDiscount("web");//桩程序
		
		strategyList = disDealService.getSuitableDiscount_web(orderInput);
	}
//计算得到最优
	public DiscountVO_web calBest() {
		return (DiscountVO_web) strategyList.get(0);
	}
}
