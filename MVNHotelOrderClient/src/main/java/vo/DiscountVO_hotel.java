package vo;

import java.time.LocalDate;

import po.DiscountPO_hotel;
import tools.DiscountState;
import tools.Strategy_hotelType;
/**
 * 
 * @author LWY
 *
 */
public class DiscountVO_hotel {
	
	public  String hotelID;
	public  Strategy_hotelType type;
	public String discountID;//还得靠数据层生成啊
	public double discount;
	public LocalDate startDate;//
	public LocalDate endDate;
	public String remarks;
	public boolean superimpose;
	public DiscountState discountState;
	public String enterpriseName;
	
	
	public DiscountVO_hotel( double discount,LocalDate start,LocalDate end,String remarks,boolean superimpose,
			Strategy_hotelType type ,String enterpriseName,String hotelID){
		this.discount=discount;
		this.startDate=start;
		this.endDate=end;
		this.remarks=remarks;
		this.superimpose=superimpose;
		this.type=type;
		this.enterpriseName=enterpriseName;
		this.hotelID = hotelID;
		this.discountState=DiscountState.valid;
	}
	public DiscountVO_hotel (DiscountPO_hotel discountPO_hotel) {
		this.discountID=discountPO_hotel.getDiscount_id();
		this.type=discountPO_hotel.getType();
		this.discount=discountPO_hotel.getDiscount();
		this.startDate=discountPO_hotel.getStartDate();
		this.endDate=discountPO_hotel.getEndDate();
		this.remarks=discountPO_hotel.getRemarks();
		this.superimpose=discountPO_hotel.isSuperimpose();
		this.discountState=discountPO_hotel.getDiscountState();
		this.enterpriseName=discountPO_hotel.getEnterpriseName();
		this.hotelID = discountPO_hotel.getHotelID();
	}
}
