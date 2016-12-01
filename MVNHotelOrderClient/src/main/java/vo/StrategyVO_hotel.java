package vo;

import java.time.LocalDate;

import po.DiscountPO_hotel;
import tools.Strategy_hotelType;

/**
 * 
 * @author LWY
 *
 */

public class StrategyVO_hotel {
	public LocalDate startDate;// 折扣开始时间

	public LocalDate endDate;

	public Strategy_hotelType type;

	public double discount;
//
//	public double orderPrice;
//	
//	public double roomPrice;

	public StrategyVO_hotel(DiscountPO_hotel strategyPO_hotel) {
		this.discount = strategyPO_hotel.getDiscount();
		this.type = strategyPO_hotel.getType();
		startDate = strategyPO_hotel.getStartDate();
		endDate = strategyPO_hotel.getEndDate();
//		this.roomPrice=roomPrice;
//		orderPrice=(end.getTimeInMillis()-start.getTimeInMillis())/(1000*60*60*24)*roomPrice*discount;
	}
}
