package vo;
/**
 * 
 * @author LinWenye
 *
 */
public class StrategyVO {
	
	public StrategyVO_hotel hotel;
	
	public StrategyVO_web web;
	
	public double discount;//hotel 和 web 折扣 叠乘
	
	/**
	 * 根据得到的酒店促销策略和网站促销策略，打包为返回给上层的最优促销策略
	 * @param hotelDiscount
	 * @param webDiscount
	 */
	
	public StrategyVO(StrategyVO_hotel hotel, StrategyVO_web webBest) {
		this.hotel = hotel;
		this.web = webBest;
		discount=hotel.discount*webBest.discount;
	}
}
