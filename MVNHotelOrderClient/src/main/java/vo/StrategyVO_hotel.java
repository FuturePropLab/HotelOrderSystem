package vo;

import java.util.Calendar;

import tools.Strategy_hotelType;

/**
 * 
 * @author LWY
 *
 */

public class StrategyVO_hotel {
	public Calendar startDate;// 折扣开始时间

	public Calendar endDate;

	public Strategy_hotelType type;

	public double discount;
//
//	public double orderPrice;
//	
//	public double roomPrice;

	public StrategyVO_hotel(double discount, Strategy_hotelType type, Calendar start, Calendar end) {
		this.discount = discount;
		this.type = type;
		startDate = start;
		endDate = end;
//		this.roomPrice=roomPrice;
//		orderPrice=(end.getTimeInMillis()-start.getTimeInMillis())/(1000*60*60*24)*roomPrice*discount;
	}
}
