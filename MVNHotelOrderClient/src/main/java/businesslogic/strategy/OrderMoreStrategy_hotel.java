package businesslogic.strategy;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

/**
 * 
 * @author LWY 三间及以上预定的策略：第三间及以上的房间享有折扣
 *
 */
public class OrderMoreStrategy_hotel implements HotelStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO, StrategyVO_hotel strategyVO_hotel, long day) {

		double res = 0;

		final int maxNoDiscount = 2;// 刚好获得优惠的房间数量-1 软编码哈哈哈

		if (orderInputCalVO.numberOfRooms > maxNoDiscount) {

			res = orderInputCalVO.price * maxNoDiscount + orderInputCalVO.price
					* (orderInputCalVO.numberOfRooms - maxNoDiscount) * strategyVO_hotel.discount;

			res = res - orderInputCalVO.price * orderInputCalVO.numberOfRooms;

		} 

		return res;
	}

}
