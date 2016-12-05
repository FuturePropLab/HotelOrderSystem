package po;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import tools.DiscountState;
import tools.Strategy_hotelType;

@Entity
public class DiscountHotelPO {
	
	private String hotelID ;
	
	@Id
	private String discountID;//如果是增加新的折扣策略，则id应该由数据层生成
	
	private DiscountState discountState;//策略状态，valid ， invalid

	private Strategy_hotelType type;//促销策略类型
	
	private double discount;//折扣
	
	private LocalDate startDate;//特定期间策略的期间开始时间
	
	private LocalDate endDate;
	
	private String remarks;//备注
	
	private boolean superimpose;//是否可叠加
	
	private String enterpriseName;//企业名称
	
	
	public  DiscountHotelPO(){
		
	}
	
	public DiscountHotelPO(String hotelID , DiscountPO_hotel discountPO_hotel){
		this.discount = discountPO_hotel.getDiscount();
		this.discountID = discountPO_hotel.getDiscountID();
		this.discountState = discountPO_hotel.getDiscountState();
		this.enterpriseName =discountPO_hotel.getEnterpriseName();
		this.endDate = discountPO_hotel.getEndDate();
		this.startDate = discountPO_hotel.getStartDate();
		this.remarks = discountPO_hotel.getRemarks();
		this.hotelID = hotelID;
		this.superimpose = discountPO_hotel.isSuperimpose();
		this.type = discountPO_hotel.getType();
	}
	

	public String getDiscountID() {
		return discountID;
	}


	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}

	

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	@Enumerated(EnumType.STRING)
	public DiscountState getDiscountState() {
		return discountState;
	}


	public void setDiscountState(DiscountState discountState) {
		this.discountState = discountState;
	}

	@Enumerated(EnumType.STRING)
	public Strategy_hotelType getType() {
		return type;
	}


	public void setType(Strategy_hotelType type) {
		this.type = type;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public boolean isSuperimpose() {
		return superimpose;
	}


	public void setSuperimpose(boolean superimpose) {
		this.superimpose = superimpose;
	}


	public String getEnterpriseName() {
		return enterpriseName;
	}


	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	
	
	
	
}
