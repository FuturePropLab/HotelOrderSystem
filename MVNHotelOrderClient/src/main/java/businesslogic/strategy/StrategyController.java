package businesslogic.strategy;

import java.util.List;

import businesslogicservice.StrategyService;
import vo.DiscountVO;
import vo.OrderInputCalVO;
import vo.StrategyVO;

public class StrategyController implements StrategyService{

	private Strategy strategy;
	public StrategyVO CalculateBestStrategy(OrderInputCalVO orderInputCalVO) {
		// TODO Auto-generated method stub
		return strategy.CalculateBestStrategy(orderInputCalVO);
	}

}
