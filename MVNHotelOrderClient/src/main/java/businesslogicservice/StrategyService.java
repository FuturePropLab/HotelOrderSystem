package businesslogicservice;

import java.util.List;

import vo.DiscountVO;

public interface StrategyService {
	public DiscountVO CalculateBestStrategy(List<DiscountVO> discountList);
}
