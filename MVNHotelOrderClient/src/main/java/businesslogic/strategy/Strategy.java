package businesslogic.strategy;

import businesslogicservice.DiscountGetService;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;
import vo.StrategyVO;
/**
 * 
 * @author LinWenye
 *
 *委托给webStrategy和HotelStragety，分别得到网站的和酒店的最优的策略
 */
public class Strategy {
	
	private HotelStrategy hotelStrategy;
	private WebStrategy webStrategy;
	
	public StrategyVO CalculateBestStrategy(OrderInputVO orderInput){
		
		hotelStrategy=new HotelStrategy(orderInput);
		DiscountVO_hotel hotelBest=hotelStrategy.calBest();
		webStrategy=new WebStrategy(orderInput);
		DiscountVO_web webBest=webStrategy.calBest();
		return new StrategyVO(hotelBest,webBest);
	}
}
