package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.DiscountVO_web;

public interface WebStrategyInterface {
	
	public double calculate(OrderInputCalVO orderInputCalVO,DiscountVO_web strategyVO_web,long day) ;

}
