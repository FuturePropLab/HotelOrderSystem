package businesslogic.strategy;

import vo.DiscountVO_web;
/**
 * 工厂模式，生成不同的网站优惠算法对象
 * @author LWY
 *
 */
public class FactoryConcreteWebStrategy {
	public WebStrategyInterface getConcreteInstance(DiscountVO_web strategyVO_web) {

		WebStrategyInterface res = null;
		switch (strategyVO_web.type) {
		case Level:
			res = new LevelStrategy_web();
			break;

		case Period:
			res = new PeriodStrategy_web();
			break;

		case VIP_district:
			res = new VIP_circleStrategy_web();
			break;

		}
		return res;
	}
}
