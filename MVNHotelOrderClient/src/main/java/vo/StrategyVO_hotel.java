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
	
	public boolean superimpose;//是否可叠加

	public Strategy_hotelType type;

	public double discount;//折扣
	
	public String enterpriseName;//企业名称
	
	public double minusPrice;//折扣减去的价格

	public StrategyVO_hotel(DiscountPO_hotel discountPO_hotel) {
		this.discount = discountPO_hotel.getDiscount();
		this.type = discountPO_hotel.getType();
		startDate = discountPO_hotel.getStartDate();
		endDate = discountPO_hotel.getEndDate();
		superimpose=discountPO_hotel.isSuperimpose();
		this.enterpriseName = discountPO_hotel.getEnterpriseName();
	}
}
