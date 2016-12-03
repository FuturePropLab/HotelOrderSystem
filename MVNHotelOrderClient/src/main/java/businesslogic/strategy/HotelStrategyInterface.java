package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
/**
 * 
 * @author LWY
 *
 */
public interface HotelStrategyInterface {
	/**
	 * 
	 * @param orderInputCalVO
	 * @return 不同策略计算的结果
	 * 只计算单独一天的优惠
	 */

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel, long i);

}
