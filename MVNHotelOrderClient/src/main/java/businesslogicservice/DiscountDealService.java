package businesslogicservice;

import java.util.List;

import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;

public interface DiscountDealService {

		public List<DiscountVO_hotel> getSuitableDiscount_hotel(OrderInputVO orderInput);
		public List<DiscountVO_web> getSuitableDiscount_web(OrderInputVO orderInput);
		public DiscountVO invalidDiscount(String discount_id);
		public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo);
}
