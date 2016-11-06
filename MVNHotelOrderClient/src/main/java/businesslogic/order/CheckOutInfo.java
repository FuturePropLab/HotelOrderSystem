package businesslogic.order;

import java.sql.Time;

/**
 * 订单的退房信息
 * @author zjy
 *
 */
public class CheckOutInfo {
	public Time checkOutTime;//实际离开时间
	
	/**
	 * 
	 * @param checkOutTime 实际离开时间
	 */
	public CheckOutInfo(Time checkOutTime) {
		super();
		this.checkOutTime = checkOutTime;
	}


	/**
	 * 
	 * @return 退房信息填写完毕则返回true，否则返回false
	 */
	public boolean filled() {
		return checkOutTime!=null;
	}
}
