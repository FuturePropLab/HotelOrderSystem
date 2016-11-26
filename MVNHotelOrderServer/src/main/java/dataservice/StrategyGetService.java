package dataservice;

import java.util.List;

import po.OrderInputCalPO;
import po.StrategyPO_hotel;
import po.StrategyPO_web;
/**
 * 
 * @author LWY
 *
 */
public interface StrategyGetService {
	public List<StrategyPO_hotel> getSuitableDiscount_hotel(OrderInputCalPO orderInput);
	public List<StrategyPO_web> getSuitableDiscount_web(OrderInputCalPO orderInput);
}
