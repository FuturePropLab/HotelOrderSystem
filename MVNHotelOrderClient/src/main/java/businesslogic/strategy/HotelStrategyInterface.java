package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO;

public interface HotelStrategyInterface {
	public StrategyVO Calculate(OrderInputCalVO orderInputCalVO) ;

}
