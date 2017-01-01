package businesslogic.strategy;

import vo.DiscountVO_web;
import vo.DiscountVO_web_district;
import vo.OrderInputCalVO;

/**
 * VIP特定商圈优惠算法
 * 
 * @author LWY
 *
 */
public class VIP_circleStrategy_web implements WebStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO, DiscountVO_web strategyVO_web) {
		double res = 0;
		DiscountVO_web_district discountVO_web_district = (DiscountVO_web_district)strategyVO_web;
		if(orderInputCalVO.businessCircle.equals(discountVO_web_district.businessCircle)&&
				orderInputCalVO.city.equals(discountVO_web_district.city)&&
				orderInputCalVO.district.equals(discountVO_web_district.district)&&
				orderInputCalVO.level==discountVO_web_district.level){
			res=(discountVO_web_district.discount-1)*orderInputCalVO.numberOfRooms*orderInputCalVO.price;
		}
		return res;
	}

}
