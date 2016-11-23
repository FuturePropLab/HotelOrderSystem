package businesslogic.strategy;

import java.util.Iterator;
import java.util.List;

import businesslogic.discount.DiscountCalController;
import businesslogicservice.DiscountGetService;
import vo.DiscountVO_hotel;
import vo.OrderInputVO;

/**
 * 
 * @author LinWenye
 * 调用DiscountGetService得到符合条件的策略，计算出最优
 */

public class HotelStrategy {

	private List<DiscountVO_hotel> strategyList;

	// public HotelStrategy(OrderInputVO orderInput) {
	// 桩程序
	// DiscountGetService disDealService = new MockDiscount("hotel");

	// strategyList = disDealService.getSuitableDiscount_hotel(orderInput);
	// }
	
/**
 * 
 * @param orderInput
 * 构造方法
 */
	public HotelStrategy(OrderInputVO orderInput) {
		DiscountGetService discount = new DiscountCalController();
		strategyList = discount.getSuitableDiscount_hotel(orderInput);
	}

	
	/**
	 * 
	 * @return 最优酒店策略
	 */
	public DiscountVO_hotel calBest() {

		double min = 1.0;
		DiscountVO_hotel res = null ;
		
		Iterator iter = strategyList.iterator();
		while (iter.hasNext()) {			DiscountVO_hotel discountVO_hotel = (DiscountVO_hotel) iter.next();
			if (discountVO_hotel.discount < min) {

				min = discountVO_hotel.discount;

				res=discountVO_hotel;
			}
		}
		return res;
	}
}
