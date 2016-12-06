package vo;

import po.DiscountPO_web_district;
/**
 * 
 * @author LWY
 *
 */
public class DiscountVO_web_district extends DiscountVO_web{
	
	public DiscountVO_web_district(DiscountPO_web_district discountPO_web) {
		this.discountState=discountPO_web.getDiscountState();
		this.discountID=discountPO_web.getDiscountID();
		this.level=discountPO_web.getLv();
		this.type=discountPO_web.getType();
		this.city=discountPO_web.getCity();
		this.businessCircle=discountPO_web.getBusinessCircle();
		this.discount=discountPO_web.getDiscount();
		this.district=discountPO_web.getDistrict();
	}
	public int level;//会员等级
	public String city;
	public String district;
	public String businessCircle;
}
