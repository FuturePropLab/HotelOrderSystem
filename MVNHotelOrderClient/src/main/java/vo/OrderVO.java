package vo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import po.OrderPO;
import tools.Mark;
import tools.OrderState;
import tools.RoomType;
/**
 * 订单的信息，因信息太多，暂时不提供直接由构造方法设置属性的方式
 * @author zjy
 *
 */
public class OrderVO {
	public String orderID;
	public String customerID;
	public String hotelID;
	public double price;//订单的总价（折后）
	public ArrayList<String> roomNumber;//房间号
	public Date startTime;//下单时间
	public Date latestTime;//最晚订单执行时间
	public Date planedLeaveTime;//预计离开时间
	public Date checkInTime;//实际入住时间
	public Date checkOutTime;//实际离开时间
	public Date revokeTime;//实际撤销时间
	public RoomType roomType;
	public int numberOfRooms;//房间数量
	public int value;//订单的价值
	public int planedPeopleNumber;//预计入住人数
	public boolean child;//有无儿童
	public OrderState orderState;
	public Mark mark;
	public String assessment;
	
	public OrderVO(){
		
	}

	/**
	 * 
	 * @param orderID 订单ID
	 * @param customerID 客户ID
	 * @param hotelID 酒店ID
	 * @param price 订单的总价（折后）
	 * @param roomNumber 房间号
	 * @param startTime 下单时间
	 * @param latestTime 最晚订单执行时间
	 * @param planedLeaveTime 预计离开时间
	 * @param checkInTime 实际入住时间
	 * @param checkOutTime 实际离开时间
	 * @param revokeTime 实际撤销时间，如果没有撤销，则为null
	 * @param roomType 房间类型
	 * @param numberOfRooms 房间数量
	 * @param value 订单的价值
	 * @param planedPeopleNumber 预计入住人数
	 * @param child 有无儿童
	 * @param orderState 订单状态
	 * @param mark 评分
	 * @param assessment 评价 
	 */
	public OrderVO(String orderID, String customerID, String hotelID, double price, ArrayList<String> roomNumber,
			Date startTime, Date latestTime, Date planedLeaveTime, Date checkInTime, Date checkOutTime, Date revokeTime,
			RoomType roomType, int numberOfRooms, int value, int planedPeopleNumber, boolean child,
			OrderState orderState, Mark mark, String assessment) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.hotelID = hotelID;
		this.price = price;
		this.roomNumber = roomNumber;
		this.startTime = startTime;
		this.latestTime = latestTime;
		this.planedLeaveTime = planedLeaveTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.revokeTime = revokeTime;
		this.roomType = roomType;
		this.numberOfRooms = numberOfRooms;
		this.value = value;
		this.planedPeopleNumber = planedPeopleNumber;
		this.child = child;
		this.orderState = orderState;
		this.mark = mark;
		this.assessment = assessment;
	}

}
