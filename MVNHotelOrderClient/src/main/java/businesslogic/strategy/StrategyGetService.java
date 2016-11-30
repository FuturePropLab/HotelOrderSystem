package businesslogic.strategy;

import java.util.List;

import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;
/**
 * 
 * @author LWY
 * change: 分离接口 ，使策略计算时不调用冗余接口。
 */
public interface StrategyGetService {
		/**
		 * 
		 * 供Strategy模块调用，由discount模块实现
		 * 那为什么放blservice包里面？  --by zjy
		 */
		public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput);
		public List<StrategyVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput);

}
