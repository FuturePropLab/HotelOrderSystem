package businesslogic.strategy;

import vo.StrategyVO_web;

public class FactoryConcreteWebStrategy {
	public WebStrategyInterface getConcreteInstance(StrategyVO_web strategyVO_web) {

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
