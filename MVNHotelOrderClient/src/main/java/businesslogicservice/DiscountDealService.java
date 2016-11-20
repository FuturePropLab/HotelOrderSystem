package businesslogicservice;

import java.util.List;

import vo.DiscountSearchVO;
import vo.DiscountVO;
/**
 * 
 * @author lwy
 * 分离接口，有待进一步修改
 *
 */
public interface DiscountDealService {
	public DiscountVO invalidDiscount(String discount_id);
	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo);
}
