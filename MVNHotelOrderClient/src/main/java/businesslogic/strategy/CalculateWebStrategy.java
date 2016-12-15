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
		// MockStrategyGet discount =new MockStrategyGet();
		strategyList = discount.getSuitableDiscount_web(orderInput);
		this.orderInputCalVO = orderInput;

	}

	/**
	 * 计算得出网站最优促销策略，默认不可叠加
	 * 
	 * @return
	 */
	public DiscountVO_web calBest() {

		DiscountVO_web single = new DiscountVO_web();
		single.discount = 1;

		Iterator<DiscountVO_web> iter = strategyList.iterator();
		double min = 0;// 最小值

		while (iter.hasNext()) {

			DiscountVO_web strategyVO_web = iter.next();
			FactoryConcreteWebStrategy factoryConcreteWebStrategy = new FactoryConcreteWebStrategy();
			WebStrategyInterface webStrategyInterface = factoryConcreteWebStrategy.getConcreteInstance(strategyVO_web);

			double calculate = webStrategyInterface.calculate(orderInputCalVO, strategyVO_web);

			if (calculate < min) {
				min = calculate;
				single = strategyVO_web;
			}

		}

		return single;
	}
}
