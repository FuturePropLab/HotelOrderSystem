package po;

import java.io.Serializable;

import javax.persistence.Entity;

import tools.DiscountState;
import tools.Strategy_webType;

/**
 *
 * @author wsw
 *
 */
@Entity
public class DiscountPO_web_district extends DiscountPO_web implements Serializable{
	
	private static final long serialVersionUID = 6748351274254288601L;

	private int level;//会员等级
	private String city;
	private String district;
	private String businessCircle;
	
	/**
	 * 
	 * @param 等级
	 * @param city
	 * @param district
	 * @param businessCircle
	 * @param discount
	 * @param discountState
	 * @param remarks
	 * @param type
	 */
	public DiscountPO_web_district(int lv,String city,String district,String businessCircle,double discount,DiscountState discountState,String remarks,Strategy_webType type){
		this.level=lv;
		this.setCity(city);
		this.setDistrict(district);
		this.setBusinessCircle(businessCircle);
		setDiscount(discount);
		setDiscountState(discountState);
		setRemarks(remarks);
		setType(type);
	}
	
	
	public DiscountPO_web_district(){
		
	}

	public int getLv() {
		return level;
	}
	
	public void setLv(int lv) {
		this.level = lv;
	}


	public String getBusinessCircle() {
		return businessCircle;
	}


	public void setBusinessCircle(String businessCircle) {
		this.businessCircle = businessCircle;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}

	
}
