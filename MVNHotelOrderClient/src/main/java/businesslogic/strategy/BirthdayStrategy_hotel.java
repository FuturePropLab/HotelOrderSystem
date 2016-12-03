package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
/**
 *  酒店生日特惠算法
 * @author LWY
 *
 */
public class BirthdayStrategy_hotel implements HotelStrategyInterface{

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel,long day) {
		// TODO Auto-generated method stub
		if(orderInputCalVO.birthday.toEpochDay()>=orderInputCalVO.startDate.toEpochDay()
				&&orderInputCalVO.birthday.toEpochDay()<orderInputCalVO.endDate.toEpochDay()){
			
			return orderInputCalVO.price*orderInputCalVO.numberOfRooms*(strategyVO_hotel.discount-1);
		}
		else return 0;
	}

}
