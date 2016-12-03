package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
/**
 * 特定期间优惠算法
 * @author LWY
 *
 */
public class PeriodStrategy_hotel implements HotelStrategyInterface{

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel,long day) {
		// TODO Auto-generated method stub
		double res;
		res= orderInputCalVO.price*orderInputCalVO.numberOfRooms*strategyVO_hotel.discount;
		
		
		return res;
	}

}
