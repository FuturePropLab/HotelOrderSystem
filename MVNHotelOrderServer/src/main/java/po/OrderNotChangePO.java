package po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import tools.RoomType;

@Entity
public class OrderNotChangePO {
	@Id
	private String orderID;
	private Date latestTime;//最晚订单执行时间
	private Date planedLeaveTime;//预计离开时间	

	private RoomType roomType;
	private int numberOfRooms;//房间数量	
	private int value;//订单的价值
	private int planedPeopleNumber;//预计入住人数
	private boolean child;//有无儿童	
	private double price;
	
	public OrderNotChangePO(){
		
	}
	
	
	public OrderNotChangePO(OrderPO orderPO){
		super();
		this.child = orderPO.isChild();
		this.latestTime = orderPO.getLatestTime();
		this.numberOfRooms  =orderPO.getNumberOfRooms();
		this.orderID = orderPO.getOrderID();
		//this.planedCheckOutTime  =orderPO.getPlanedCheckOutTime();
		this.planedLeaveTime = orderPO.getPlanedLeaveTime();
		this.planedPeopleNumber =orderPO.getPlanedPeopleNumber();
		this.price  =orderPO.getPrice();
		this.roomType  =orderPO.getRoomType();
		this.value = orderPO.getValue();
	}
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}

	public Date getPlanedLeaveTime() {
		return planedLeaveTime;
	}

	public void setPlanedLeaveTime(Date planedLeaveTime) {
		this.planedLeaveTime = planedLeaveTime;
	}
	
	@Enumerated(EnumType.STRING)
	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getPlanedPeopleNumber() {
		return planedPeopleNumber;
	}

	public void setPlanedPeopleNumber(int planedPeopleNumber) {
		this.planedPeopleNumber = planedPeopleNumber;
	}

	public boolean isChild() {
		return child;
	}

	public void setChild(boolean child) {
		this.child = child;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
