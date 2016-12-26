package vo;

import po.DiscountPO_web_district;
import tools.DiscountState;
import tools.Strategy_webType;

/**
 * 
 * @author LWY
 *
 */
public class DiscountVO_web_district extends DiscountVO_web {

	public DiscountVO_web_district(DiscountPO_web_district discountPO_web) {
		this.discountState = discountPO_web.getDiscountState();
		this.discountID = discountPO_web.getDiscountID();
		this.level = discountPO_web.getLv();
		this.type = discountPO_web.getType();
		this.city = discountPO_web.getCity();
		this.businessCircle = discountPO_web.getBusinessCircle();
		this.discount = discountPO_web.getDiscount();
		this.district = discountPO_web.getDistrict();
	}

	public DiscountVO_web_district(double discount, int level, String city, String district, String businessCircle) {

		this.discount = discount ;
		this.level = level;
		this.city = city;
		this.district = district;
		this.businessCircle = businessCircle;
		this.type = Strategy_webType.VIP_district;
		this.discountState = null;
	}

	public int level;// 会员等级
	public String city;
	public String district;
	public String businessCircle;
}
