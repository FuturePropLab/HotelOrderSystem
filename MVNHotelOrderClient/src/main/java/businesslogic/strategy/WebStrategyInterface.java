package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO;

public interface WebStrategyInterface {
	public StrategyVO Calculate(OrderInputCalVO orderInputCalVO) ;

}
