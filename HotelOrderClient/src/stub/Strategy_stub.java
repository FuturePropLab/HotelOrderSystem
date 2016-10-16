package stub;

import java.util.List;

import businesslogicservice.StrategyService;
import vo.DiscountVO;

public class Strategy_stub implements StrategyService {
	public DiscountVO CalculateBestStrategy(List<DiscountVO> discountList){
		DiscountVO bes=new DiscountVO();
		bes=discountList.get(0);
		return bes;
	}

}
