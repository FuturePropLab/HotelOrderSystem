package businesslogic.strategy;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import businesslogic.discount.DiscountGet;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

/**
 * 
 * @author LinWenye 调用DiscountGetService得到符合条件的策略，计算出最优
 */

public class HotelStrategy {

	private List<StrategyVO_hotel> strategyList;
	private OrderInputCalVO orderInput;

	public double price = -1;

	// public HotelStrategy(OrderInputVO orderInput) {
	// 桩程序
	// DiscountGetService disDealService = new MockDiscount("hotel");

	// strategyList = disDealService.getSuitableDiscount_hotel(orderInput);
	// }

	/**
	 * 
	 * @param orderInput
	 *            构造方法
	 */
	public HotelStrategy(OrderInputCalVO orderInput) {
		StrategyGetService discount = new DiscountGet();
		strategyList = discount.getSuitableDiscount_hotel(orderInput);
		this.orderInput = orderInput;
	}

	/**
	 * 
	 * @return 最优酒店策略
	 */
	public List<StrategyVO_hotel> calBest() {

		List<StrategyVO_hotel> res = null;

		LocalDate end = orderInput.endDate;
		LocalDate start = orderInput.startDate;
//
//		long s1 = start.getTimeInMillis();
//		long e1 = end.getTimeInMillis();
//		long days = (e1 - s1) / (1000 * 60 * 60 * 24);

		Iterator iter = strategyList.iterator();
		
		while (iter.hasNext()) {
			StrategyVO_hotel discountVO_hotel = (StrategyVO_hotel) iter.next();

//			long s = discountVO_hotel.startDate.getTimeInMillis();
//			long e = discountVO_hotel.endDate.getTimeInMillis();
//			long daysWithHotelDiscount = (e - s) / (1000 * 60 * 60 * 24);

//			double price = orderInput.price * orderInput.numberOfRooms
//					* (daysWithHotelDiscount * discountVO_hotel.discount + days - daysWithHotelDiscount);
//
//			if (this.price < 0) {
//
//				res = discountVO_hotel;
//				this.price = price;
//
//			} else if (price < this.price) {
//
//				this.price = price;
//
//				res = discountVO_hotel;
//			}
		}
		return res;
	}
}
