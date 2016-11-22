package businesslogicservice;

import java.util.List;

import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;
/**
 * 
 * @author lwy
 * change: 分离接口 ，使策略计算时不调用冗余接口。
 */
public interface DiscountGetService {
		/**
		 * 
		 * @param orderInput
		 * @return
		 */
		public List<DiscountVO_hotel> getSuitableDiscount_hotel(OrderInputVO orderInput);
		public List<DiscountVO_web> getSuitableDiscount_web(OrderInputVO orderInput);

}
