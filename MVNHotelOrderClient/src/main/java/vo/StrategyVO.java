package vo;
/**
 * 
 * @author LinWenye
 *
 */
public class StrategyVO {
	private DiscountVO_hotel hotel;
	private DiscountVO_web web;
	public double discount;//hotel 和 web 折扣 叠乘
	
	//根据得到的酒店促销策略和网站促销策略，打包为返回给上层的最优促销策略
	public StrategyVO(DiscountVO_hotel hotel, DiscountVO_web web) {
		this.hotel = hotel;
		this.web = web;
		discount=hotel.discount*web.discount;
	}
}
