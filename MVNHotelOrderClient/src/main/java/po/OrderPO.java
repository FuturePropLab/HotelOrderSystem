package po;

import java.awt.SecondaryLoop;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import tools.Mark;
import tools.OrderState;
import tools.RoomType;
import vo.OrderVO;
/**
 * 
 * @author zjy
 *
 */
public class OrderPO implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2359170002512854429L;
	private String orderID;
	private String customerID;
	private String hotelID;
	private Date startTime;//未定time用什么类	
	
	private OrderState orderState;
	
	private Date latestTime;//最晚订单执行时间
	private Date planedLeaveTime;//预计离开时间	
	private Date planedCheckOutTime;//预计退房时间
	
	private RoomType roomType;
	private int numberOfRooms;//房间数量
	
	private int value;//订单的价值
	private int planedPeopleNumber;//预计入住人数
	private boolean child;//有无儿童	
	private double price;
	
	
	private ArrayList<String> roomNumber;//房间号

	private Mark mark;
	private String assessment;
	
	private Date checkOutTime;//实际离开时间
	private Date revokeTime;//实际撤销时间
	private Date checkInTime;//实际入住时间	
	
	public OrderPO() {
		super();
	}
	/**
	 * 仅供测试用
	 * @param orderID 订单ID
	 */
	public OrderPO(String orderID) {
		super();
		this.orderID = orderID;
		this.customerID="customerID";
		this.hotelID="hotelID";
		this.roomNumber=new ArrayList<String>();
		this.roomNumber.add("8888");
		this.startTime=new Date();
		this.latestTime=new Date(new Date().getTime()+60*1000);
		this.planedLeaveTime=new Date();
		this.planedCheckOutTime=new Date();
		this.checkInTime=new Time(0);
		this.checkOutTime=new Time(0);
		this.revokeTime=null;
		this.roomType=RoomType.EluxeSuite;
		this.numberOfRooms=1;
		this.value=100;
		this.planedPeopleNumber=1;
		this.child=false;
		this.orderState=OrderState.Unexecuted;
		this.mark=null;
		this.assessment=null;
	}
	public OrderPO(String orderID, String customerID, String hotelID, ArrayList<String> roomNumber, Date startTime,
			Date latestTime,Date planedLeaveTime, Date checkInTime, Date planedCheckOutTime,Date checkOutTime, Date revokeTime,
			RoomType roomType, int numberOfRooms, int value, int planedPeopleNumber, boolean child,
			OrderState orderState, Mark mark, String assessment,double price) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.hotelID = hotelID;
		this.roomNumber = roomNumber;
		this.startTime = startTime;
		this.latestTime = latestTime;
		this.planedLeaveTime=planedLeaveTime;
		this.checkInTime = checkInTime;
		this.planedCheckOutTime=planedCheckOutTime;
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
		this.price=price;
	}
	
	/**
	 * wsw 增加了一个新的初始化方法
	 * @param order
	 */
	public OrderPO(Order order){
		super();
		this.orderID = order.getOrderID();
		this.customerID = order.getCustomerID();
		this.hotelID = order.getHotelID();
		this.roomNumber = order.getRoomNumber();
		this.startTime = order.getStartTime();
		this.latestTime =  order.getLatestTime();
		this.planedLeaveTime =  order.getPlanedLeaveTime();
		this.checkInTime =  order.getCheckInTime();
		this.planedCheckOutTime=order.getPlanedCheckOutTime();
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
	
	/**
	 * wsw 增加了一个新的初始化方法
	 * @param orderVO
	 */
	public OrderPO(OrderVO orderVO){
		super();
		this.orderID = orderVO.orderID;
		this.customerID = orderVO.customerID;
		this.hotelID = orderVO.hotelID;
		this.roomNumber = orderVO.roomNumber;
		this.startTime = orderVO.startTime;
		this.latestTime = orderVO.latestTime;
		this.planedLeaveTime=orderVO.planedLeaveTime;
		this.checkInTime = orderVO.checkInTime;
		this.planedCheckOutTime = orderVO.planedCheckOutTime;
		this.checkOutTime = orderVO.checkOutTime;
		this.revokeTime = orderVO.revokeTime;
		this.roomType = orderVO.roomType;
		this.numberOfRooms = orderVO.numberOfRooms;
		this.value = orderVO.value;
		this.planedPeopleNumber = orderVO.planedPeopleNumber;
		this.child = orderVO.child;
		this.orderState = orderVO.orderState;
		this.mark = orderVO.mark;
		this.assessment = orderVO.assessment;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public String getHotelID() {
		return hotelID;
	}
	public ArrayList<String> getRoomNumber() {
		return roomNumber;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getLatestTime() {
		return latestTime;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public Date getRevokeTime() {
		return revokeTime;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public int getValue() {
		return value;
	}
	public int getPlanedPeopleNumber() {
		return planedPeopleNumber;
	}
	public boolean isChild() {
		return child;
	}
	public OrderState getOrderState() {
		return orderState;
	}
	public Mark getMark() {
		return mark;
	}
	public String getAssessment() {
		return assessment;
	}
	public double getPrice() {
		return price;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public void setRoomNumber(ArrayList<String> roomNumber) {
		this.roomNumber = roomNumber;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public void setLatestTime(Time latestTime) {
		this.latestTime = latestTime;
	}
	public void setCheckInTime(Time checkInTime) {
		this.checkInTime = checkInTime;
	}
	public void setCheckOutTime(Time checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public void setRevokeTime(Time revokeTime) {
		this.revokeTime = revokeTime;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setPlanedPeopleNumber(int planedPeopleNumber) {
		this.planedPeopleNumber = planedPeopleNumber;
	}
	public void setChild(boolean child) {
		this.child = child;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	public void setMark(Mark mark) {
		this.mark = mark;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPlanedCheckOutTime() {
		return planedCheckOutTime;
	}
	public void setPlanedCheckOutTime(Date planedCheckOutTime) {
		this.planedCheckOutTime = planedCheckOutTime;
	}
	public Date getPlanedLeaveTime() {
		return planedLeaveTime;
	}
	public void setPlanedLeaveTime(Date planedLeaveTime) {
		this.planedLeaveTime = planedLeaveTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}
	
}
