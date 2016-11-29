package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.StrategyGetService;
import po.DiscountPO_hotel;
import po.DiscountPO_web;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;

/**
 * 
 * @author LWY
 *
 */

public class DiscountGet implements StrategyGetService {

	private dataservice.DiscountHotelDataService hotelDataService;
	private dataservice.DiscountWebDataService webDataService;
	public DiscountGet() {
//		dataService=RemoteHelper.getInstance().getStrategy();
	}
	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) {
		// TODO Auto-generated method stub
		List<DiscountPO_hotel> list= hotelDataService.getHotelDiscount(orderInput.hotelID);
		List<StrategyVO_hotel> res = new LinkedList<StrategyVO_hotel>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			res.add(new StrategyVO_hotel((DiscountPO_hotel) iterator.next()));
		}
		return res;
	}

	public List<StrategyVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) {
		// TODO Auto-generated method stub
		List<DiscountPO_web> list= webDataService.getWebDiscount();
		List<StrategyVO_web> res = new LinkedList<StrategyVO_web>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			res.add(new StrategyVO_web((DiscountPO_web) iterator.next()));
		}
		return res;
	}
	

}
