package driver;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.StrategyService;
import vo.DiscountVO;
import vo.OrderInputCalVO;

public class StrategyService_Driver {
	public void drive(StrategyService strategy ){
		OrderInputCalVO discountList = new OrderInputCalVO(0, null, null, null, null, null, 0);
		strategy.CalculateBestStrategy(discountList);
	}
}
