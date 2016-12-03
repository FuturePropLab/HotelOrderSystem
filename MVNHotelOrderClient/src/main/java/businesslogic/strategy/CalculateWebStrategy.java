package businesslogic.strategy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.StrategyGet;
import vo.DiscountVO_web;
import vo.OrderInputCalVO;

/**
 * 
 * @author LinWenye
 *
 */

public class CalculateWebStrategy {
	// private WebStrategyInterface

	private List<DiscountVO_web> strategyList;
	private OrderInputCalVO orderInputCalVO;

	public CalculateWebStrategy(OrderInputCalVO orderInput) {

		StrategyGetService discount = new StrategyGet();
		strategyList = discount.getSuitableDiscount_web(orderInput);
		this.orderInputCalVO = orderInput;
		// DiscountGetService disDealService = new MockDiscount("web");//桩程序

		// strategyList = disDealService.getSuitableDiscount_web(orderInput);
	}

	/**
	 * 计算得到最优
	 * 
	 * @return 最优策略
	 */
	// public List<DiscountVO_web> calBest() {
	//
	// double min = 1.0;
	// List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
	//
	// Iterator<DiscountVO_web> iter = strategyList.iterator();
	//
	// while (iter.hasNext()) {
	//
	// DiscountVO_web strategyVO_web = iter.next();
	// FactoryConcreteWebStrategy factoryConcreteWebStrategy = new
	// FactoryConcreteWebStrategy();
	// WebStrategyInterface webStrategyInterface =
	// factoryConcreteWebStrategy.getConcreteInstance(strategyVO_web);
	//
	// double calulate = webStrategyInterface.calculate(orderInput,
	// strategyVO_web);
	// if (calulate < min) {
	//
	// min = calulate;
	// res.add(strategyVO_web);
	//
	// }
	//
	// }
	// return res;
	//
	// // return (DiscountVO_web) strategyList.get(0);
	// }

	public List<DiscountVO_web> calBest() {

		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();

		for (long i = orderInputCalVO.startDate.toEpochDay(); i < orderInputCalVO.endDate.toEpochDay(); i++) {

			DiscountVO_web single = null;

			Iterator<DiscountVO_web> iter = strategyList.iterator();
			double min = 0;// 策略减去的额度,为负数

			while (iter.hasNext()) {

				DiscountVO_web strategyVO_web = iter.next();
				FactoryConcreteWebStrategy factoryConcreteWebStrategy = new FactoryConcreteWebStrategy();
				WebStrategyInterface webStrategyInterface = factoryConcreteWebStrategy
						.getConcreteInstance(strategyVO_web);

				double calculate = webStrategyInterface.calculate(orderInputCalVO, strategyVO_web, i);

				if (calculate < min) {
					min = calculate;
					single = strategyVO_web;
				}

			}

			// 不重复地添加进使用的优惠策略
			
					boolean exist = false;
					Iterator<DiscountVO_web> iterator = res.iterator();
					while (iterator.hasNext()) {
						DiscountVO_web compare2 = iterator.next();
						if (compare2.discount == single.discount && compare2.type == single.type) {
							exist = true;
						}
					}
					if (!exist)
						res.add(single);
			
			
		}
		return res;
	}
}
