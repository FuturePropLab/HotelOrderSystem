package po;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import tools.DiscountState;
import tools.Strategy_hotelType;


/**
 * 
 * @author wshwbluebird
 *
 */


public class DiscountPO_hotel implements Serializable{
	
	private String discountID;//如果是增加新的折扣策略，则id应该由数据层生成
	
	private static final long serialVersionUID = 7645590613074411508L;

	private DiscountState discountState;//策略状态，valid ， invalid

	private Strategy_hotelType type;//促销策略类型
	
	private double discount;//折扣
	
	private LocalDate startDate;//特定期间策略的期间开始时间
	
	private LocalDate endDate;
	
	private String remarks;//备注
	
	private boolean superimpose;//是否可叠加
	
	private String enterpriseName;//企业名称
	
	/**
	 * 
	 * @param discountState
	 * @param type
	 * @param discountID
	 * @param discount
	 * @param startDate
	 * @param enDate
	 * @param remarks
	 * @param superimpose
	 * @param enterpriseName
	 */
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
	
	
	public DiscountPO_hotel(DiscountHotelPO discountHotelPO){
		this.discountState=discountHotelPO.getDiscountState();
		this.type=discountHotelPO.getType();
		this.discountID=discountHotelPO.getDiscountID();
		this.discount=discountHotelPO.getDiscount();
		this.startDate=discountHotelPO.getStartDate();
		this.endDate=discountHotelPO.getEndDate();
		this.setRemarks(discountHotelPO.getRemarks());
		this.setSuperimpose(discountHotelPO.isSuperimpose());
		this.enterpriseName=discountHotelPO.getEnterpriseName();
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


	public String getDiscountID() {
		return discountID;
	}


	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}

	@Enumerated(EnumType.STRING)
	public void setType(Strategy_hotelType type) {
		this.type = type;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	
}
