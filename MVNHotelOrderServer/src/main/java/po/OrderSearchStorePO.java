package po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import tools.OrderState;


@Entity
public class OrderSearchStorePO {
	private String orderID;
	private String customerID;
	private String hotelID;
	private Date startTime;//未定time用什么类		
	private Date checkOutTime;//实际离开时间
	private Date revokeTime;//实际撤销时间
	private Date checkInTime;//实际入住时间	
	private OrderState orderState;
	
	
	public OrderSearchStorePO(){
		
	}


	public String getOrderID() {
		return orderID;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}


	public String getCustomerID() {
		return customerID;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public String getHotelID() {
		return hotelID;
	}


	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Enumerated(EnumType.STRING)
	public OrderState getOrderState() {
		return orderState;
	}


	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}


	public Date getCheckOutTime() {
		return checkOutTime;
	}


	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}


	public Date getRevokeTime() {
		return revokeTime;
	}


	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}


	public Date getCheckInTime() {
		return checkInTime;
	}


	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	
	
}
