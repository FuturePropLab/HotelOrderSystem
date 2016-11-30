package po;

/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_web_district extends DiscountPO_web{

	private int lv;
	private String city;
	private String district;
	private String businessCircle;
	private double discount;
	public DiscountPO_web_district(int lv,String city,String district,String businessCircle,double discount){
		this.lv=lv;
		this.setCity(city);
		this.setDistrict(district);
		this.setBusinessCircle(businessCircle);
		this.discount=discount;
	}


	public int getLv() {
		return lv;
	}
	
	public void setLv(int lv) {
		this.lv = lv;
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
