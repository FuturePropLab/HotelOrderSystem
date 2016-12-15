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
//		MockStrategyGet discount =new MockStrategyGet();//test!!
		strategyList = discount.getSuitableDiscount_web(orderInput);
		this.orderInputCalVO = orderInput;
		
		// DiscountGetService disDealService = new MockDiscount("web");//妗╃▼搴�

		// strategyList = disDealService.getSuitableDiscount_web(orderInput);
	}

	/**
	 * 璁＄畻寰楀埌鏈�浼�
	 * 
	 * @return 鏈�浼樼瓥鐣�
	 */

	public DiscountVO_web calBest() {

			DiscountVO_web single = new DiscountVO_web();
			single.discount = 1;

			Iterator<DiscountVO_web> iter = strategyList.iterator();
			double min = 0;// 绛栫暐鍑忓幓鐨勯搴�,涓鸿礋鏁�

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
