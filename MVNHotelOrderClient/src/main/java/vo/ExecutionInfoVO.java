package vo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *  执行订单的信息，包括订单ID、房间号、预计离开时间、实际入住时间、实际离开时间
 *  @author zjy
 */
public class ExecutionInfoVO {
	public String orderID;
	public ArrayList<String> roomNumber;//房间号
	public Date planedLeaveTime;//预计离开时间
	public Date checkInTime;//实际入住时间
	public Date checkOutTime;//实际离开时间
	
	/**
	 *  @param customer_ID  客户ID
	 *  @param type  申请的会员类型
	 */
	public ExecutionInfoVO(String orderID, ArrayList<String> roomNumber, Date planedLeaveTime, Date checkInTime,
			Date checkOutTime) {
		super();
		this.orderID = orderID;
		this.roomNumber = roomNumber;
		this.planedLeaveTime = planedLeaveTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}
}
