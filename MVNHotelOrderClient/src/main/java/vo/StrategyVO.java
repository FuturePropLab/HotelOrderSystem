package vo;

import java.util.List;

/**
 * 
 * @author LinWenye
 *
 */

public class StrategyVO {
	
	public double price;
	
	public List<StrategyVO_hotel> hotel;
	
	public List<StrategyVO_web> web;
	
	/**
	 * 根据得到的酒店促销策略和网站促销策略，打包为返回给上层的最优促销策略
	 * @param hotelDiscount
	 * @param webDiscount
	 */
	
	public StrategyVO(List<StrategyVO_hotel> hotel, List<StrategyVO_web> webBest) {
		
		this.hotel = hotel;
		this.web = webBest;
	
	}
}
