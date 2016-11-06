package businesslogic.discount;

import java.util.List;

import businesslogicservice.DiscountDealService;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.OrderInputVO;

/**
 * 
 * @author chenyuyan
 *
 */
public class discountCalController implements DiscountDealService {
	
	/**
	 * @param OrderInputVO
	 * @return 调用领域类的方法
	 */
	public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput) {
		Discount discount = new Discount();
		return ((DiscountDealService) discount).getSuitableDiscount(orderInput);
	}

	public DiscountVO invalidDiscount(String discount_id) {
		// TODO Auto-generated method stub
		Discount discount = new Discount();
		return ((DiscountDealService) discount).invalidDiscount(discount_id);
	}

	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo) {
		// TODO Auto-generated method stub
		Discount discount = new Discount();
		return ((DiscountDealService) discount).CheckDiscount(dsvo);
	}

}
