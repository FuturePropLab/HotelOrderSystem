package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.StrategyGetService;
import po.StrategyPO_hotel;
import po.StrategyPO_web;
import rmi.RemoteHelper;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;

/**
 * 
 * @author LWY
 *
 */

public class DiscountGet implements StrategyGetService {

	private dataservice.StrategyGetService dataService;
	public DiscountGet() {
		dataService=RemoteHelper.getInstance().geStrategy();
	}
	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) {
		// TODO Auto-generated method stub
		List<StrategyPO_hotel> list= dataService.getSuitableDiscount_hotel(orderInput);
		List<StrategyVO_hotel> res = new LinkedList<StrategyVO_hotel>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			res.add(new StrategyVO_hotel((StrategyPO_hotel) iterator.next()));
		}
		return res;
	}

	public List<StrategyVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) {
		// TODO Auto-generated method stub
		List<StrategyPO_web> list= dataService.getSuitableDiscount_web(orderInput);
		List<StrategyVO_web> res = new LinkedList<StrategyVO_web>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			res.add(new StrategyVO_web((StrategyPO_web) iterator.next()));
		}
		return res;
	}
	

}
