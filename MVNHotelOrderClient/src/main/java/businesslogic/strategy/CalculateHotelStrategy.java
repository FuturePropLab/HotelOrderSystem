package businesslogic.strategy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.StrategyGet;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;

/**
 * 酒店优惠策略具体计算
 * @author LinWenye
 */

public class CalculateHotelStrategy {

	private List<StrategyVO_hotel> strategyList;
	private OrderInputCalVO orderInputCalVO;

	public double price = -1;

	// public HotelStrategy(OrderInputVO orderInput) {
	// 桩程序
	// DiscountGetService disDealService = new MockDiscount("hotel");

	// strategyList = disDealService.getSuitableDiscount_hotel(orderInput);
	// }

	/**
	 * 
	 * @param orderInput
	 *            构造方法
	 */
	public CalculateHotelStrategy(OrderInputCalVO orderInput) {
		StrategyGetService discount = new StrategyGet();
		strategyList = discount.getSuitableDiscount_hotel(orderInput);
		this.orderInputCalVO = orderInput;
	}

	/**
	 * 
	 * @return 最优酒店策略
	 */
	public List<StrategyVO_hotel> calBest() {

		List<StrategyVO_hotel> res = new LinkedList<StrategyVO_hotel>();
		
		for (long i = orderInputCalVO.startDate.toEpochDay(); i < orderInputCalVO.endDate.toEpochDay(); i++) {
			
			StrategyVO_hotel single =null;
			List<StrategyVO_hotel> temp = new LinkedList<StrategyVO_hotel>();
			
			Iterator<StrategyVO_hotel> iter = strategyList.iterator();
			double min = 0;//不可叠加的策略减去的额度
			double all = 0;//可叠加的策略减去的总额
			
			while (iter.hasNext()) {
				
				StrategyVO_hotel strategyVO_hotel = iter.next();
				FactoryConcreteHotelStrategy factoryConcreteHotelStrategy = new FactoryConcreteHotelStrategy();
				HotelStrategyInterface hotelStrategyInterface = factoryConcreteHotelStrategy.getConcreteInstance(strategyVO_hotel);
				
				double calculate = hotelStrategyInterface.calculate(orderInputCalVO, strategyVO_hotel,i);
				
				strategyVO_hotel.minusPrice = calculate;
				
				if(strategyVO_hotel.superimpose==true){
					temp.add(strategyVO_hotel);
					all+=strategyVO_hotel.minusPrice;
				}
				else if (calculate < min) {
					min = calculate;
					single = strategyVO_hotel;
				}

			}
			
			//不重复地添加进使用的优惠策略
			if(all<=min){
				Iterator<StrategyVO_hotel> iterator1 = temp.iterator();
				while (iterator1.hasNext()){
					boolean exist = false;
					StrategyVO_hotel compare = iterator1.next();
					Iterator<StrategyVO_hotel> iterator2 = res.iterator();
					while (iterator2.hasNext()) {
						StrategyVO_hotel compare2 = iterator2.next();
						if(compare2.discount==compare.discount&&compare2.type==compare.type){
							exist=true;
						}
					}
					if(!exist) res.add(compare);
				}
			}
			else{
				boolean exist = false;
				Iterator<StrategyVO_hotel> iterator = res.iterator();
				while (iterator.hasNext()) {
					StrategyVO_hotel compare2 = iterator.next();
					if (compare2.discount == single.discount && compare2.type == single.type) {
						exist = true;
					}
				}
				if (!exist)
					res.add(single);
			}
		}
		return res;
	}
}
