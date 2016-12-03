package businesslogic.strategy;

import java.util.List;

import vo.DiscountVO_web;
import vo.OrderInputCalVO;
import vo.StrategyVO;
import vo.StrategyVO_hotel;

/**
 * 
 * @author LinWenye
 *
 *         委托给webStrategy和HotelStragety，分别得到网站的和酒店的最优的策略
 */
public class Strategy {

	private CalculateHotelStrategy hotelStrategy;
	private CalculateWebStrategy webStrategy;

	public StrategyVO CalculateBestStrategy(OrderInputCalVO orderInput) {

		hotelStrategy = new CalculateHotelStrategy(orderInput);
		List<StrategyVO_hotel> hotelBest = hotelStrategy.calBest();

		webStrategy = new CalculateWebStrategy(orderInput);
		List<DiscountVO_web> webBest = webStrategy.calBest();

		StrategyVO res= new StrategyVO(hotelBest, webBest);
	    
	    return res;
	}
}
