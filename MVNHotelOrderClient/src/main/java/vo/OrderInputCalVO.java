package vo;

import tools.RoomType;

/**
 * 输入订单信息供计算
 * 
 * @author LWY
 */
public class OrderInputCalVO {
	public double price;//订房单价
	public String customerID;
	public String hotelID;
	public int days;//根据input得到天数
	public RoomType roomType;
	public int numberOfRooms;

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
	public OrderInputCalVO(OrderInputVO orderInputVO,int days) {
		super();
		this.price=orderInputVO.price;
		this.customerID = orderInputVO.customerID;
		this.hotelID = orderInputVO.hotelID;
		this.days=days;
		this.roomType = orderInputVO.roomType;
		this.numberOfRooms = orderInputVO.numberOfRooms;
	}
}
