package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

/**
 * 酒店生日特惠算法
 * 
 * @author LWY
 *
 */
public class BirthdayStrategy_hotel implements HotelStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel, long day) {
		// TODO Auto-generated method stub
		double res = 0;
		if (orderInputCalVO.birthday.toEpochDay() == day) {
			res = orderInputCalVO.price * orderInputCalVO.numberOfRooms * (strategyVO_hotel.discount - 1);
			System.out.println(res);
		}
		return res;
	}

}
