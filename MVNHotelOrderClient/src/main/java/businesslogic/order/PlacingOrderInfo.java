package businesslogic.order;

import java.sql.Time;
import java.util.ArrayList;

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
	public Time startTime;//未定time用什么类,下单时间
	public Time latestTime;//最晚订单执行时间
	public Time planedLeaveTime;//预计离开时间
	public int planedPeopleNumber;//预计入住人数
	public boolean child;//有无儿童
}
