package po;

import java.util.Calendar;

import tools.Strategy_hotelType;

/**
 * 
 * @author LWY
 *
 */

public class StrategyPO_hotel {
	private Calendar startDate;// 折扣开始时间

	private Calendar endDate;

	private Strategy_hotelType type;

	private double discount;
//

	public StrategyPO_hotel(double discount, Strategy_hotelType type, Calendar start, Calendar end) {
		this.discount = discount;
		this.type = type;
		startDate = start;
		endDate = end;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public Strategy_hotelType getType() {
		return type;
	}

	public double getDiscount() {
		return discount;
	}
}
