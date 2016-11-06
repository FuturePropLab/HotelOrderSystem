package businesslogicservice;

import java.util.List;

import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.OrderInputVO;

public interface DiscountDealService {

		public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput);
		public DiscountVO invalidDiscount(String discount_id);
		public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo);
		
}
