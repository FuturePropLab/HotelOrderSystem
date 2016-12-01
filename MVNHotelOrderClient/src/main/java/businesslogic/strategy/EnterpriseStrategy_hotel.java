package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

public class EnterpriseStrategy_hotel implements HotelStrategyInterface{

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel) {
		// TODO Auto-generated method stub
		return orderInputCalVO.price*orderInputCalVO.numberOfRooms*strategyVO_hotel.discount;
	}

}
