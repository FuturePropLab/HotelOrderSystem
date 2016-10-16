package vo;

import java.sql.Time;

import tools.RoomType;

public class OrderInputVO {
	public String customerID;
	public String hotelID;
	public Time startTime;//未定time用什么类
	public Time latestTime;//最晚订单执行时间
	public Time planedLeaveTime;//预计离开时间
	public RoomType roomType;
	public int numberOfRooms;
	public int planedPeopleNumber;//预计入住人数
	public boolean child;//有无儿童
	
	public OrderInputVO(String customerID, String hotelID, Time startTime, Time latestTime, Time planedLeaveTime,
			RoomType roomType, int numberOfRooms, int planedPeopleNumber, boolean child) {
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
	}
}
