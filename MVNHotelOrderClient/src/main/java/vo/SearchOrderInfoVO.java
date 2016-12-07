package vo;

import java.util.Date;

import tools.OrderState;
/**
 * 搜索订单信息
 * @author zjy
 *
 */
public class SearchOrderInfoVO {
	public String keywords;
	public Date date;
	public OrderState orderState;
	
	/**
	 * 如果某项搜索条件不限，则该项为null
	 * @param accountID 账户ID
	 * @param keywords 关键词
	 * @param date 日期
	 * @param orderState 订单状态
	 */
	public SearchOrderInfoVO(String keywords, Date date, OrderState orderState) {
		super();
		this.keywords = keywords;
		this.date = date;
		this.orderState = orderState;
	}
}
