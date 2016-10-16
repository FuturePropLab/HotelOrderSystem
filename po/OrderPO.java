package po;

import java.sql.Time;
import java.util.ArrayList;

import tools.Mark;
import tools.OrderState;
import tools.RoomType;

public class OrderPO {
	private String orderID;
	private String customerID;
	private String hotelID;
	private ArrayList<String> roomNumber;//房间号
	private Time startTime;//未定time用什么类
	private Time latestTime;//最晚订单执行时间
	private Time planedLeaveTime;//预计离开时间
	private Time checkInTime;//实际入住时间
	private Time checkOutTime;//实际离开时间
	private Time revokeTime;//实际撤销时间
	private RoomType roomType;
	private int numberOfRooms;//房间数量
	private int value;//订单的价值
	private int planedPeopleNumber;//预计入住人数
	private boolean child;//有无儿童
	private OrderState orderState;
	private Mark mark;
	private String assessment;
	
	public OrderPO() {
		super();
	}
	public OrderPO(String orderID) {
		super();
		this.orderID = orderID;
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
	public Time getStartTime() {
		return startTime;
	}
	public Time getLatestTime() {
		return latestTime;
	}
	public Time getPlanedLeaveTime() {
		return planedLeaveTime;
	}
	public Time getCheckInTime() {
		return checkInTime;
	}
	public Time getCheckOutTime() {
		return checkOutTime;
	}
	public Time getRevokeTime() {
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
	public void setPlanedLeaveTime(Time planedLeaveTime) {
		this.planedLeaveTime = planedLeaveTime;
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
	
}
