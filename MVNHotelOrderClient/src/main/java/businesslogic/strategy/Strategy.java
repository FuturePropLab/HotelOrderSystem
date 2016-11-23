package businesslogic.strategy;

import businesslogicservice.DiscountGetService;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;
import vo.StrategyVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;

/**
 * 
 * @author LinWenye
 *
 *         委托给webStrategy和HotelStragety，分别得到网站的和酒店的最优的策略
 */
public class Strategy {

	private HotelStrategy hotelStrategy;
	private WebStrategy webStrategy;

	public StrategyVO CalculateBestStrategy(OrderInputVO orderInput) {

		hotelStrategy = new HotelStrategy(orderInput);
		StrategyVO_hotel hotelBest = hotelStrategy.calBest();

		webStrategy = new WebStrategy(orderInput);
		StrategyVO_web webBest = webStrategy.calBest();

		return new StrategyVO(hotelBest, webBest);
	}
}
