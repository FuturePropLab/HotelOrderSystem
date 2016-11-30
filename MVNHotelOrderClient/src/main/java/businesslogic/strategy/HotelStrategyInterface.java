package businesslogic.strategy;

import vo.OrderInputCalVO;

public interface HotelStrategyInterface {
	/**
	 * 
	 * @param orderInputCalVO
	 * @return 不同策略计算的结果
	 */
	public double calculate(OrderInputCalVO orderInputCalVO , double discount) ;

}
