package po;

import java.sql.Date;
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
	
	private DiscountState discountState;//策略状态，valid ， invalid

	private Strategy_hotelType type;//促销策略类型
	
	private String discountID;//如果是增加新的折扣策略，则id应该由数据层生成
	
	private double discount;//折扣
	
	private LocalDate startDate;//特定期间策略的期间开始时间
	
	private LocalDate endDate;
	
	private String remarks;//备注
	
	private boolean superimpose;//是否可叠加
	
	private String enterpriseName;//企业名称
	
	public DiscountPO_hotel(DiscountState discountState,Strategy_hotelType type,String discountID,double discount,LocalDate startDate,LocalDate enDate,String remarks,boolean superimpose,String enterpriseName){
		this.discountState=discountState;
		this.type=type;
		this.discountID=discountID;
		this.discount=discount;
		this.startDate=startDate;
		this.endDate=enDate;
		this.setRemarks(remarks);
		this.setSuperimpose(superimpose);
		this.enterpriseName=enterpriseName;
		
	}
	public DiscountPO_hotel(DiscountVO_hotel discountVO_hotel){
		this.type=discountVO_hotel.type;
		this.discountID=discountVO_hotel.discountID;
		this.discount=discountVO_hotel.discount;
		this.startDate=discountVO_hotel.startDate;
		this.endDate=discountVO_hotel.endDate;
		this.setRemarks(discountVO_hotel.remarks);//备注
		this.setSuperimpose(discountVO_hotel.superimpose);//是否可叠加
		this.enterpriseName = discountVO_hotel.enterpriseName;
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
	public boolean isSuperimpose() {
		return superimpose;
	}
	public void setSuperimpose(boolean superimpose) {
		this.superimpose = superimpose;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}

}
