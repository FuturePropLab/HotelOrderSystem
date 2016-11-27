package po;

/**
 * 
 * @author LWY
 *
 */
public class DiscountPO_web_district extends DiscountPO_web{

	private int lv;
	private String district;//类型暂为String
	private double discount;
	public DiscountPO_web_district(int lv,String district,double discount){
		this.lv=lv;
		this.district=district;
		this.discount=discount;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}

	
}
