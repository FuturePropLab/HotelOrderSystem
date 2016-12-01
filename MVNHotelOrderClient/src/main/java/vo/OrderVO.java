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
	public ArrayList<String> roomNumber;//房间号
	public Date startTime;//未定time用什么类
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
	 * wsw 新增的初始化方法
	 * @param order
	 */
	public OrderVO(OrderPO order){
		this.orderID = order.getOrderID();
		this.customerID = order.getCustomerID();
		this.hotelID = order.getHotelID();
		this.roomNumber = order.getRoomNumber();
		this.startTime = order.getStartTime();
		this.latestTime =  order.getLatestTime();
		this.planedLeaveTime =  order.getPlanedLeaveTime();
		this.checkInTime =  order.getCheckInTime();
		this.checkOutTime =  order.getCheckOutTime();
		this.revokeTime =  order.getRevokeTime();
		this.roomType =  order.getRoomType();
		this.numberOfRooms =  order.getNumberOfRooms();
		this.value =  order.getValue();
		this.planedPeopleNumber =  order.getPlanedPeopleNumber();
		this.child =  false;
		this.orderState =  order.getOrderState();
		this.mark =  order.getMark();
		this.assessment =  order.getAssessment();
	}

}
