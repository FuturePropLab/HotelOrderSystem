package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_web;

public interface WebStrategyInterface {
	
	public double calculate(OrderInputCalVO orderInputCalVO,StrategyVO_web strategyVO_web,long day) ;

}
