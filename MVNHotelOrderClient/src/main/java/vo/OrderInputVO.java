package vo;

import java.sql.Time;
import java.util.Date;

import tools.RoomType;

/**
 *  生成订单信息
 *  @author zjy
 */
public class OrderInputVO {
	public String customerID;
	public String hotelID;
	public Date startTime;//未定time用什么类
	public Date latestTime;//最晚订单执行时间
	public Date planedLeaveTime;//预计离开时间
	public RoomType roomType;
	public int numberOfRooms;
	public int planedPeopleNumber;//预计入住人数
	public boolean child;//有无儿童
	public double price;
	
	/**
	 *  @param customer_ID  客户ID
	 *  @param hotelID  酒店ID
	 *  @param startTime  订单开始时间
	 *  @param latestTime  最晚订单执行时间
	 *  @param planedLeaveTime  预计离开时间
	 *  @param roomType  房间类型
	 *  @param numberOfRooms  预订的房间数量
	 *  @param planedPeopleNumber  预计入住人数
	 *  @param child  是否有儿童
	 *  @param price 订单总价
	 */
	public OrderInputVO(String customerID, String hotelID, Date startTime, Date latestTime, Date planedLeaveTime,
			RoomType roomType, int numberOfRooms, int planedPeopleNumber, boolean child,double price) {
		super();
		this.customerID = customerID;
		this.hotelID = hotelID;
		this.startTime = startTime;
		this.latestTime = latestTime;
		this.planedLeaveTime = planedLeaveTime;
		this.roomType = roomType;
		this.numberOfRooms = numberOfRooms;
		this.planedPeopleNumber = planedPeopleNumber;
		this.child = child;
		this.price=price;
	}
}
