package businesslogic.strategy;

import vo.StrategyVO_hotel;

public class FactoryConcreteHotelStrategy {
	public HotelStrategyInterface getConcreteInstance(StrategyVO_hotel strategyVO_hotel) {

		HotelStrategyInterface res = null;
		switch (strategyVO_hotel.type) {
		case Birthday:
			res = new BirthdayStrategy_hotel();
			break;

		case OrderMore:
			res = new OrderMoreStrategy_hotel();
			break;

		case CooperateEnterprise:
			res = new EnterpriseStrategy_hotel();
			break;
		case SpecificPeriod:
			res = new PeriodStrategy_hotel();
			break;
		}
		return res;
	}
}
