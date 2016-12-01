package businesslogicservice;

import java.util.List;

import tools.ResultMessageDiscount;
import vo.DiscountSearchVO;
import vo.DiscountVO;
/**
 * 
 * @author lwy
 * 分离接口，有待进一步修改
 *
 */
public interface DiscountDealService {
	public ResultMessageDiscount invalidDiscount(String discount_id);
//	public List<DiscountVO> checkDiscount(DiscountSearchVO dsvo);
}
