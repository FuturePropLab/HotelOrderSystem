package businesslogicservice;

import java.util.List;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;
/**
 * 
 * @author lwy
 * change: 分离接口 ，使策略计算时不调用冗余接口。
 */
public interface DiscountGetService {
		/**
		 * 
		 * @param orderInput
		 * @return
		 */
		public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput);
		public List<StrategyVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput);

}
