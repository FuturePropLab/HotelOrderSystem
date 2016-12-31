package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

/**
 * 合作企业优惠算法
 * 
 * @author LWY
 *
 */
public class EnterpriseStrategy_hotel implements HotelStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel, long day) {
		System.out.println("林文烨");
		System.out.println(orderInputCalVO.enterprise);
		System.out.println(strategyVO_hotel.enterpriseName);
		if (strategyVO_hotel.enterpriseName.equals(orderInputCalVO.enterprise)) {
			System.out.println("enen");
			return orderInputCalVO.price * orderInputCalVO.numberOfRooms * (strategyVO_hotel.discount - 1);
		} else
			return 0;
	}

}
