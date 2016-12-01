package businesslogic.order;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import tools.RoomType;

/**
 * 订单的下单信息
 * @author zjy
 *
 */
public class PlacingOrderInfo {
	public String customerID;
	public RoomType roomType;
	public int numberOfRooms;//房间数量
	public ArrayList<String> roomNumber;//房间号
	public String hotelID;
	public Date startTime;//未定time用什么类,下单时间
	public Date latestTime;//最晚订单执行时间
	public Date planedLeaveTime;//预计离开时间
	public int planedPeopleNumber;//预计入住人数
	public boolean child;//有无儿童
	public double price;
	/**
	 * 
	 * @param customerID 客户ID
	 * @param roomType 房间类型
	 * @param numberOfRooms 房间号码
	 * @param roomNumber 房间数量
	 * @param hotelID 酒店ID
	 * @param startTime 下单时间
	 * @param latestTime 最晚到店时间
	 * @param planedLeaveTime 预计离开时间
	 * @param planedPeopleNumber 预计入住人数
	 * @param child 有无儿童
	 * @param price 房间单价
	 */
	public PlacingOrderInfo(String customerID, RoomType roomType, int numberOfRooms, ArrayList<String> roomNumber,
			String hotelID, Date startTime, Date latestTime, Date planedLeaveTime, int planedPeopleNumber,
			boolean child,double price) {
		super();
		this.customerID = customerID;
		this.roomType = roomType;
		this.numberOfRooms = numberOfRooms;
		this.roomNumber = roomNumber;
		this.hotelID = hotelID;
		this.startTime = startTime;
		this.latestTime = latestTime;
		this.planedLeaveTime = planedLeaveTime;
		this.planedPeopleNumber = planedPeopleNumber;
		this.child = child;
		this.price=price;
	}
}
