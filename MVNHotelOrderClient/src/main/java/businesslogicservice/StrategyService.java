package businesslogicservice;

import vo.OrderInputCalVO;
import vo.StrategyVO;
/**
 * 
 * @author LWY
 *
 */
public interface StrategyService {
	public StrategyVO CalculateBestStrategy(OrderInputCalVO orderInputCalVO);
}
