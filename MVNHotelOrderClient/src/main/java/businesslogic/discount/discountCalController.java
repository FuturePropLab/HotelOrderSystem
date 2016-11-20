package businesslogic.discount;

import java.util.List;

import businesslogicservice.DiscountGetService;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;

/**
 * 
 * @author chenyuyan
 *
 */
public class discountCalController implements DiscountGetService {
	
	/**
	 * @param OrderInputVO
	 * @return 符合条件的优惠策略
	 */
	/*public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput) {
		Discount discount = new Discount();
		return ((DiscountDealService) discount).getSuitableDiscount(orderInput);
	}*/

//	public DiscountVO invalidDiscount(String discount_id) {
//		// TODO Auto-generated method stub
//		Discount discount = new Discount();
//		return ((DiscountGetService) discount).invalidDiscount(discount_id);
//	}
//
//	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo) {
//		// TODO Auto-generated method stub
//		Discount discount = new Discount();
//		return ((DiscountGetService) discount).CheckDiscount(dsvo);
//	}

	public List<DiscountVO_hotel> getSuitableDiscount_hotel(OrderInputVO orderInput) {
		// TODO Auto-generated method stub
		Discount discount = new Discount();
		return ((DiscountGetService) discount).getSuitableDiscount_hotel(orderInput);
		
	}

	public List<DiscountVO_web> getSuitableDiscount_web(OrderInputVO orderInput) {
		// TODO Auto-generated method stub
		Discount discount = new Discount();
		return ((DiscountGetService) discount).getSuitableDiscount_web(orderInput);	}

}
