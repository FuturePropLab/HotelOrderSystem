package tools;
/**
 * 
 * @author LWY
 *
 */
public enum Strategy_webType {
	Period,
	VIP_district,
	Level;
	
	/**
	 * 显示中文名称
	 * @return
	 */
	public String show(){
		switch (this) {
		case Period:
			return "特定时期折扣";
		case VIP_district:
			return "VIP在特定商圈的折扣";
		case Level:
			return "VIP等级折扣";
		}
		
		return null;
	}
}
