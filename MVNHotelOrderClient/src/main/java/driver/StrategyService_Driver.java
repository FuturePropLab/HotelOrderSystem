package driver;

import java.time.LocalDate;

import businesslogicservice.StrategyService;
import tools.RoomType;
import vo.OrderInputCalVO;

public class StrategyService_Driver {
	public void drive(StrategyService strategy ){
		OrderInputCalVO discountList = new OrderInputCalVO(100, "001", "233", LocalDate.of(2016, 12, 1), LocalDate.of(2016, 12, 4), LocalDate.of(2016, 11, 28), RoomType.Double, 4);
		strategy.CalculateBestStrategy(discountList);
	}
}
