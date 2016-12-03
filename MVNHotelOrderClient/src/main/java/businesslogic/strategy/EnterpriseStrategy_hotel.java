package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
/**
 * 合作企业优惠算法
 * @author LWY
 *
 */
public class EnterpriseStrategy_hotel implements HotelStrategyInterface{

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel,long day) {
		
		if(strategyVO_hotel.enterpriseName.equals(orderInputCalVO.enterprise))
		return orderInputCalVO.price*orderInputCalVO.numberOfRooms*(strategyVO_hotel.discount-1);
		
		else return 0;
	}

}
