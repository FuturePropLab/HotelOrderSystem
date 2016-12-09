package businesslogic.strategy;

import java.rmi.RemoteException;
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

	public StrategyVO CalculateBestStrategy(OrderInputCalVO orderInput) throws RemoteException {

		hotelStrategy = new CalculateHotelStrategy(orderInput);
		List<StrategyVO_hotel> hotelBest = hotelStrategy.calBest();

		webStrategy = new CalculateWebStrategy(orderInput);
		DiscountVO_web webBest = webStrategy.calBest();

		double price = orderInput.days * orderInput.numberOfRooms * orderInput.price;

		double[] minus = hotelStrategy.minus;
		for (int i = 0; i < orderInput.days; i++) {
			price += minus[i];
			System.out.println(minus[i]);
		}
		System.out.println(webBest.discount);
		price *= webBest.discount;

		StrategyVO res = new StrategyVO(hotelBest, webBest);
		res.price = price;
		
		for(StrategyVO_hotel strategyVO_hotel:hotelBest){
			System.out.println(strategyVO_hotel.type);
		}
		return res;
	}
}
