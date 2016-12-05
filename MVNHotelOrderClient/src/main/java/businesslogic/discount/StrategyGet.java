package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogic.strategy.StrategyGetService;
import po.DiscountPO_hotel;
import po.DiscountPO_web;
import tools.DiscountState;
import vo.DiscountVO_web;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

/**
 * 
 * @author LWY
 * 分别得到供计算的网站和酒店优惠策略，Strategy模块调用
 */

public class StrategyGet implements StrategyGetService {

	private dataservice.DiscountHotelDataService hotelDataService;
	private dataservice.DiscountWebDataService webDataService;
	
	public StrategyGet() {
//		dataService=RemoteHelper.getInstance().getStrategy();
	}
	
	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) {
		
		List<DiscountPO_hotel> list= hotelDataService.getHotelDiscount(orderInput.hotelID);
		List<StrategyVO_hotel> res = new LinkedList<StrategyVO_hotel>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			DiscountPO_hotel temp =((DiscountPO_hotel) iterator.next());
			if(temp.getDiscountState()==DiscountState.valid)
			res.add( new StrategyVO_hotel(temp));
		}
		return res;
	}

	public List<DiscountVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) {
		
		List<DiscountPO_web> list= webDataService.getWebDiscount();
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			DiscountPO_web temp =((DiscountPO_web) iterator.next());
			if(temp.getDiscountState()==DiscountState.valid)
			res.add( new FactoryDiscount().converToVO(temp));
		}
		return res;
	}
	

}