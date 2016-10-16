package driver;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.StrategyService;
import vo.DiscountVO;

public class StrategyService_Driver {
	public void drive(StrategyService strategy ){
		DiscountVO dis=new DiscountVO();
		dis.discount=7;
		List<DiscountVO> discountList = new LinkedList<>();
		discountList.add(dis);
		strategy.CalculateBestStrategy(discountList);
	}
}
