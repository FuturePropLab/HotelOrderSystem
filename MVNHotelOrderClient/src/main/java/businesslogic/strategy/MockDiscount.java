package businesslogic.strategy;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.StrategyGetService;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;

/**
 * 
 * @author LWY
 *
 */
public class MockDiscount implements StrategyGetService{
	private String type;

	// constructor
	public MockDiscount(String str) {
		type = str;
	}

	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) {

		// 应该根据type 和 orderInput来get
		List<StrategyVO_hotel> res = new LinkedList<StrategyVO_hotel>();
		StrategyVO_hotel dv = new StrategyVO_hotel(null);
		dv.discount = 0.9;
		res.add((StrategyVO_hotel) dv);
		return res;
	}

	public List<StrategyVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) {

		// 应该根据type 和 orderInput来get
		List<StrategyVO_web> res = new LinkedList<StrategyVO_web>();
		StrategyVO_web dv = new StrategyVO_web(null);
		dv.discount = 0.9;
		res.add((StrategyVO_web) dv);
		return res;
	}



}
