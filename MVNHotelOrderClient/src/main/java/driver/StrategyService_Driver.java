package driver;

import java.rmi.RemoteException;
import java.time.LocalDate;

import businesslogic.strategy.StrategyController;
import businesslogicservice.StrategyService;
import tools.RoomType;
import vo.OrderInputCalVO;
import vo.StrategyVO;

public class StrategyService_Driver {
	public static void main(String args[]) {
		// OrderInputCalVO discountList = new OrderInputCalVO(100, "001", "233",
		// LocalDate.of(2016, 12, 1),
		// LocalDate.of(2016, 12, 4), LocalDate.of(2016, 11, 28),
		// RoomType.Double, 4);
		OrderInputCalVO orderInputCalVO = new OrderInputCalVO(100, "110", "330", LocalDate.of(2016, 12, 4),
				LocalDate.of(2016, 12, 8), LocalDate.of(2016, 12, 3), RoomType.Double, 4);
		StrategyService strategyService = StrategyController.getInstance();
		try {
			StrategyVO strategyVO = strategyService.CalculateBestStrategy(orderInputCalVO);
			System.out.println(strategyVO.price);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
