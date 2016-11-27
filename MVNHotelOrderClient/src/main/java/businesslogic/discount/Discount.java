package businesslogic.discount;

import java.util.List;

import dataservice.DiscountDealDataService;
import stub.DiscountCal_stub;
import tools.ResultMessage2;
import vo.DiscountSearchVO;
import vo.DiscountVO;

public class Discount {
	
	private DiscountDealDataService discountDealDataService;
	
	public Discount(){
//		discountDealDataService=
	}
//	/**
//	 * 
//	 * @param orderInput
//	 * @return 返回符合条件的优惠
//
//	 * @return 符合订单条件的所有优惠策略
//	 */

//	public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput) {
//		// TODO Auto-generated method stub
//		DiscountCal_stub test=new DiscountCal_stub();	
//		return test.getSuitableDiscount(orderInput);
//	}
	/**
	 * 
	 * @param discount_id
	 * @return 优惠策略设为无效
	 * @return 被设置为生效或失效的优惠策略 
	 */
	public ResultMessage2 invalidDiscount(String discount_id) {
//		DiscountCal_stub test=new DiscountCal_stub();
//		return test.invalidDiscount(discount_id);
		return discountDealDataService.invalidDiscount(discount_id);
		
}
	/**
//	 * 
//	 * @param dsvo
//	 * @return 返回符合搜索条件的优惠 
//	 * @return 所有优惠策略 
//	 */
	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo){
		DiscountCal_stub test=new DiscountCal_stub();
		return test.CheckDiscount(dsvo);
	}
}
