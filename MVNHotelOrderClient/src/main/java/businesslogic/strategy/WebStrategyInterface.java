package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.DiscountVO_web;
/**
 *  网站策略接口，应用策略模式
 * @author LWY
 *
 */
public interface WebStrategyInterface {
	
	public double calculate(OrderInputCalVO orderInputCalVO,DiscountVO_web strategyVO_web) ;

}
