package tools;

/**
 * 
 * @author LWY
 *
 */
public enum Strategy_hotelType {
	Birthday, OrderMore, CooperateEnterprise, Period;
	
	/**
	 * 显示中文名称
	 * @return
	 */
	public String show(){
		switch (this) {
		case Birthday:
			return "生日特惠";
		case OrderMore:
			return "三间房及以上特惠";
		case CooperateEnterprise:
			return "合作企业特惠";
		case Period:
			return "特定时期特惠";
		}
		
		return null;
	}
}
