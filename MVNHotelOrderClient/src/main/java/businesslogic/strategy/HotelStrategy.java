package businesslogic.strategy;

import java.util.List;

import businesslogicservice.DiscountGetService;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.OrderInputVO;
/**
 * 
 * @author LinWenye
 *
 */
//调用DiscountDealService得到符合条件的策略，计算出最优
public class HotelStrategy {
	
	private List<DiscountVO_hotel> strategyList;
	public HotelStrategy(OrderInputVO orderInput) {
		//桩程序
		DiscountGetService disDealService = new MockDiscount("hotel");//桩程序
		
		strategyList = disDealService.getSuitableDiscount_hotel(orderInput);
	}
//计算得到最优

	public DiscountVO_hotel calBest(){
		return (DiscountVO_hotel) strategyList.get(0);
	}
}
