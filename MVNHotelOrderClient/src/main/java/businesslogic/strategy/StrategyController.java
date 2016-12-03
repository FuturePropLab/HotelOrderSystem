package businesslogic.strategy;

import java.util.List;

import businesslogicservice.StrategyService;
import vo.OrderInputCalVO;
import vo.StrategyVO;
/**
 * 
 * @author LWY
 *
 */
public class StrategyController implements StrategyService{

	private Strategy strategy;
	
	private static StrategyController strategyController;
	
	private StrategyController() {	
		strategy=new Strategy();
	}
	
	public static StrategyController getInstance(){
		if(strategyController==null)strategyController=new StrategyController();
		return strategyController;
	}
	public StrategyVO CalculateBestStrategy(OrderInputCalVO orderInputCalVO) {
		
		return strategy.CalculateBestStrategy(orderInputCalVO);
	}

}
