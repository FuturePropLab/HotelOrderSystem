package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

/**
 * 特定期间优惠算法
 * 
 * @author LWY
 *
 */
public class PeriodStrategy_hotel implements HotelStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel, long day) {

		double res = 0;

		if (day < strategyVO_hotel.endDate.toEpochDay() && day >= strategyVO_hotel.startDate.toEpochDay()) {

			res = (strategyVO_hotel.discount-1) * orderInputCalVO.numberOfRooms * orderInputCalVO.price;

		}

		return res;
	}

}
