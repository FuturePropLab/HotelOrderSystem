package businesslogic.strategy;

import vo.DiscountVO_web;
import vo.DiscountVO_web_level;
import vo.OrderInputCalVO;

/**
 * 会员等级折扣算法
 * 
 * @author LWY
 *
 */
public class LevelStrategy_web implements WebStrategyInterface {

	public double calculate(OrderInputCalVO orderInputCalVO, DiscountVO_web discountVO_web, long day) {
		
		DiscountVO_web_level discountVO_web_level = (DiscountVO_web_level) discountVO_web;
		
		if (orderInputCalVO.level == discountVO_web_level.level) {
			
			return (discountVO_web_level.discount - 1) * orderInputCalVO.price * orderInputCalVO.numberOfRooms;
			
		}
		
		return 0;
	}

}
