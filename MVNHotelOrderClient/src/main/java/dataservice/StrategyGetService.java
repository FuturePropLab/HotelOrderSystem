package dataservice;

import java.util.List;

import po.StrategyPO_hotel;
import po.StrategyPO_web;
import vo.OrderInputCalVO;
/**
 * 
 * @author LWY
 *
 */
public interface StrategyGetService {
	public List<StrategyPO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput);
	public List<StrategyPO_web> getSuitableDiscount_web(OrderInputCalVO orderInput);
}
