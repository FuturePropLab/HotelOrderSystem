package businesslogic.strategy;

import java.util.List;

import vo.OrderInputCalVO;
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

	private CalculateHotelStrategy hotelStrategy;
	private CalculateWebStrategy webStrategy;

	public StrategyVO CalculateBestStrategy(OrderInputCalVO orderInput) {

		hotelStrategy = new CalculateHotelStrategy(orderInput);
		List<StrategyVO_hotel> hotelBest = hotelStrategy.calBest();

		webStrategy = new CalculateWebStrategy(orderInput);
		List<StrategyVO_web> webBest = webStrategy.calBest();

		StrategyVO res= new StrategyVO(hotelBest, webBest);
		
//	    long s=hotelBest.startDate.getTimeInMillis();  
//	    long e=hotelBest.endDate.getTimeInMillis();  
//	    long daysWithHotelDiscount = (e-s)/(1000*60*60*24);
//	    
//	    LocalDate end =orderInput.planedLeaveTime;
//	    LocalDate start=orderInput.startTime;
//	    
//	    long s1=start.getTimeInMillis();  
//	    long e1=end.getTimeInMillis();  
//	    long days = (e1-s1)/(1000*60*60*24);
	    
	    
//	    res.price=hotelStrategy.price*webBest.discount;
		
	    
	    return res;
	}
}
