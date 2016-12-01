package businesslogic.order;

import java.util.Date;

/**
 * 订单的入住信息
 * @author zjy
 *
 */
public class CheckInInfo {
	public Date planedLeaveTime;//预计离开时间
	public Date checkInTime;//实际入住时间
	/**
	 * 
	 * @param date 预计离开时间
	 * @param date2 实际入住时间
	 */
	public CheckInInfo(Date date, Date date2) {
		super();
		this.planedLeaveTime = date;
		this.checkInTime = date2;
	}

	/**
	 * 
	 * @return 入住信息填写完毕则返回true，否则返回false
	 */
	public boolean filled() {
		return planedLeaveTime!=null && checkInTime!=null;
	}
}
