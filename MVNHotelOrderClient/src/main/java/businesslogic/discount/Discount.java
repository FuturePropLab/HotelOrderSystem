package businesslogic.discount;

import java.util.List;

import stub.DiscountCal_stub;
import stub.Discount_stub;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.OrderInputVO;

public class Discount {
	DiscountType discountType;
	/**
	 * 
	 * @param orderInput
	 * @return 符合订单条件的所有优惠策略
	 */

	public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput) {
		// TODO Auto-generated method stub
		DiscountCal_stub test=new DiscountCal_stub();
		return test.getSuitableDiscount(orderInput);
	}
	/**
	 * 
	 * @param discount_id
	 * @return 被设置为生效或失效的优惠策略 
	 */
	public DiscountVO invalidDiscount(String discount_id) {
		DiscountCal_stub test=new DiscountCal_stub();
		return test.invalidDiscount(discount_id);
		
}
	/**
	 * 
	 * @param dsvo
	 * @return 所有优惠策略 
	 */
	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo){
		DiscountCal_stub test=new DiscountCal_stub();
		return test.CheckDiscount(dsvo);
	}
}
