package businesslogic.order;

import java.sql.Time;

/**
 * 订单的入住信息
 * @author zjy
 *
 */
public class CheckInInfo {
	public Time planedLeaveTime;//预计离开时间
	public Time checkInTime;//实际入住时间
	/**
	 * 
	 * @return 入住信息填写完毕则返回true，否则返回false
	 */
	public boolean filled() {
		return planedLeaveTime!=null && checkInTime!=null;
	}
}
