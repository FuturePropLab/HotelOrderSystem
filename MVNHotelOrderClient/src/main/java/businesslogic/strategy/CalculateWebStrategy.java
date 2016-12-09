package businesslogic.strategy;

import java.rmi.RemoteException;
import java.util.Iterator;
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

	private List<DiscountVO_web> strategyList;
	private OrderInputCalVO orderInputCalVO;

	public CalculateWebStrategy(OrderInputCalVO orderInput) throws RemoteException {

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

	public DiscountVO_web calBest() {

			DiscountVO_web single = new DiscountVO_web();
			single.discount = 1;

			Iterator<DiscountVO_web> iter = strategyList.iterator();
			double min = 0;// 策略减去的额度,为负数

			while (iter.hasNext()) {

				DiscountVO_web strategyVO_web = iter.next();
				FactoryConcreteWebStrategy factoryConcreteWebStrategy = new FactoryConcreteWebStrategy();
				WebStrategyInterface webStrategyInterface = factoryConcreteWebStrategy
						.getConcreteInstance(strategyVO_web);

				double calculate = webStrategyInterface.calculate(orderInputCalVO, strategyVO_web);

				if (calculate < min) {
					min = calculate;
					single = strategyVO_web;
				}

			}
			
		return single;
	}
}
