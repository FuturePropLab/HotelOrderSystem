package po;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class OrderAssessPO {
	@Id
	private String orderID;
	private String hotelID;
	
	private int markValue;
	private String assessment;
	
	
	public OrderAssessPO(){
		
	}


	public String getOrderID() {
		return orderID;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}


	public String getHotelID() {
		return hotelID;
	}


	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}


	public int getMarkValue() {
		return markValue;
	}


	public void setMarkValue(int markValue) {
		this.markValue = markValue;
	}


	public String getAssessment() {
		return assessment;
	}


	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	
	
	
}
