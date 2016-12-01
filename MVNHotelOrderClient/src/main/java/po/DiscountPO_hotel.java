package po;

import java.time.LocalDate;

import tools.DiscountState;
import tools.Strategy_hotelType;
import vo.DiscountVO_hotel;
/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_hotel {
	
	private DiscountState discountState;//订单状态

	private Strategy_hotelType type;//促销策略类型
	
	private String discountID;
	
	private double discount;//折扣
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	public DiscountPO_hotel(DiscountState discountState,Strategy_hotelType type,String discountID,double discount,LocalDate startDate,LocalDate enDate){
		this.discountState=discountState;
		this.type=type;
		this.discountID=discountID;
		this.discount=discount;
		this.startDate=startDate;
		this.endDate=enDate;
		
	}
	public DiscountPO_hotel(DiscountVO_hotel discountVO_hotel){
		this.type=discountVO_hotel.type;
		this.discountID=discountVO_hotel.discountID;
		this.discount=discountVO_hotel.discount;
		this.startDate=discountVO_hotel.startDate;
		this.endDate=discountVO_hotel.endDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getDiscount_id() {
		return discountID;
	}
	public double getDiscount() {
		return discount;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Strategy_hotelType getType() {
		return type;
	}
	public DiscountState getDiscountState() {
		return discountState;
	}
	public void setDiscountState(DiscountState discountState) {
		this.discountState = discountState;
	}


}
