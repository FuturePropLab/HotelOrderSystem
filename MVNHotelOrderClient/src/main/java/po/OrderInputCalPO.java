package po;

import java.util.Calendar;

import tools.RoomType;

public class OrderInputCalPO {
	private double price;//订房单价
	private String customerID;
	private String hotelID;
	private Calendar startTime;
	private Calendar planedLeaveTime;// 预计离开时间
	private RoomType roomType;
	private int numberOfRooms;

	/**
	 * @param price
	 *            订房的单价
	 * @param customer_ID
	 *            客户ID
	 * @param hotelID
	 *            酒店ID
	 * @param startTime
	 *            订单开始时间
	 * @param latestTime
	 *            最晚订单执行时间
	 * @param planedLeaveTime
	 *            预计离开时间
	 * @param roomType
	 *            房间类型
	 * @param numberOfRooms
	 *            预订的房间数量
	 * @param planedPeopleNumber
	 *            预计入住人数
	 * @param child
	 *            是否有儿童
	 */
	public OrderInputCalPO(double price,String customerID, String hotelID, Calendar startTime, Calendar planedLeaveTime,
			RoomType roomType, int numberOfRooms) {
		super();
		this.price=price;
		this.customerID = customerID;
		this.hotelID = hotelID;
		this.startTime = startTime;
		this.planedLeaveTime = planedLeaveTime;
		this.roomType = roomType;
		this.numberOfRooms = numberOfRooms;
	}
}
