package vo;

import java.sql.Time;
import java.util.ArrayList;

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
	public ArrayList<String> roomNumber;//房间号
	public Time startTime;//未定time用什么类
	public Time latestTime;//最晚订单执行时间
	public Time planedLeaveTime;//预计离开时间
	public Time checkInTime;//实际入住时间
	public Time checkOutTime;//实际离开时间
	public Time revokeTime;//实际撤销时间
	public RoomType roomType;
	public int numberOfRooms;//房间数量
	public int value;//订单的价值
	public int planedPeopleNumber;//预计入住人数
	public boolean child;//有无儿童
	public OrderState orderState;
	public Mark mark;
	public String assessment;

}
