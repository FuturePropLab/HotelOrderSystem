package businesslogic.discount;

import po.DiscountPO_web;
import po.DiscountPO_web_district;
import po.DiscountPO_web_level;
import po.DiscountPO_web_period;
import vo.DiscountVO_web;
import vo.DiscountVO_web_district;
import vo.DiscountVO_web_level;
import vo.DiscountVO_web_period;

public class FactoryDiscount {
	public DiscountPO_web conversion (DiscountVO_web discountVO_web){
		
		DiscountPO_web res = null;
		
		switch (discountVO_web.type) {
		case Period:
			res = new DiscountPO_web_period((DiscountVO_web_period)discountVO_web);
			break;

		case VIP_district:
			res = new DiscountPO_web_district((DiscountVO_web_district)discountVO_web);
			break;
			
		case Level:
			res = new DiscountPO_web_level((DiscountVO_web_level)discountVO_web);
			break;
		}
		
		return res;
		
	}
	
	public DiscountVO_web converToVO (DiscountPO_web discountPO_web){
		
		DiscountVO_web res = null;
		
		switch (discountPO_web.getType()) {
		case Period:
			res = new DiscountVO_web_period((DiscountPO_web_period)discountPO_web);
			break;

		case VIP_district:
			res = new DiscountVO_web_district((DiscountPO_web_district)discountPO_web);
			break;
			
		case Level:
			res = new DiscountVO_web_level((DiscountPO_web_level)discountPO_web);
			break;
		}
		
		return res;
		
	}
}
