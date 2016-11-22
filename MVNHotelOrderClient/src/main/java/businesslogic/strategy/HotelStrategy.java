package businesslogic.strategy;

import java.util.List;

import businesslogic.discount.DiscountCalController;
import businesslogicservice.DiscountGetService;
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

//	public HotelStrategy(OrderInputVO orderInput) {
//桩程序
//		DiscountGetService disDealService = new MockDiscount("hotel");
		
//		strategyList = disDealService.getSuitableDiscount_hotel(orderInput);
//	}
	
	public HotelStrategy (OrderInputVO orderInput){
		DiscountGetService discount=new DiscountCalController();
		strategyList = discount.getSuitableDiscount_hotel(orderInput);
	}
	
//计算得到最优

	public DiscountVO_hotel calBest(){
		
		double min=1.0;
		DiscountVO_hotel res = new DiscountVO_hotel(null, 1, null, null);
		
		for(int i=0;i<strategyList.size();i++){
			
			if(strategyList.get(i).discount<min){
				
				min=strategyList.get(i).discount;
				
				res.discount=min;
				res.Discount_id=strategyList.get(i).Discount_id;
				res.EndDate=strategyList.get(i).EndDate;
				res.startDate=strategyList.get(i).startDate;
			}
		}
		return res;
	}
}
