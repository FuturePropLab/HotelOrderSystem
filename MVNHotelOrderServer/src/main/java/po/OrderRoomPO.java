package po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderRoomPO {
	@Id
	private String orderID;
	private String RoomNumber;
	
	public OrderRoomPO(){
		
	}
	
	public OrderRoomPO(String orderID, String RoomNumebr){
		this.orderID  = orderID;
		this.RoomNumber = RoomNumebr;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}
	
	
}
