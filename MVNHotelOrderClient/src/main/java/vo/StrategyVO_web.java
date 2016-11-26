package vo;

import java.util.Calendar;

import tools.Strategy_webType;

/**
 * 
 * @author LWY
 *
 */
public class StrategyVO_web {
	public Calendar startDate;// 折扣开始时间

	public Calendar endDate;

	public Strategy_webType type;

	public double discount;

	public StrategyVO_web(double discount, Strategy_webType type, Calendar start, Calendar end) {

		this.discount = discount;
		this.type = type;
		startDate = start;
		endDate = end;
	}

}
