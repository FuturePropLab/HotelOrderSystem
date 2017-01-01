package businesslogic.strategy;

import java.time.LocalDate;

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
		LocalDate liveDay = LocalDate.ofEpochDay(day);
		if (orderInputCalVO != null && orderInputCalVO.birthday != null
				&& orderInputCalVO.birthday.getMonthValue() == liveDay.getMonthValue()
				&& orderInputCalVO.birthday.getDayOfMonth() == liveDay.getDayOfMonth()
				&& strategyVO_hotel.startDate.toEpochDay()<=day
				&& strategyVO_hotel.endDate.toEpochDay()>=day) {
			
			
			res = orderInputCalVO.price * orderInputCalVO.numberOfRooms * (strategyVO_hotel.discount - 1);
//			System.out.println(res);
		}
		return res;
	}

}
