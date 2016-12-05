package businesslogic.strategy;

import java.util.List;

import vo.DiscountVO_web;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
/**
 * 
 * @author LWY
 * change: 分离接口 ，使策略计算时不调用冗余接口。
 * 调用Discount模块
 */
public interface StrategyGetService {
		
		public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput);
		
		public List<DiscountVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput);

}
