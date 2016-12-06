package po;

import javax.persistence.Entity;
import javax.persistence.Id;

import tools.Mark;


@Entity
public class OrderAssessPO {
	@Id
	private String orderID;
	private String hotelID;
	
	private int markValue;
	private String assessment;
	
	
	public OrderAssessPO(){
		
	}
	
	/**
	 * 
	 * @param orderID
	 * @param hotelID
	 * @param markValue
	 * @param assessment
	 */
	
	public OrderAssessPO(String orderID , String hotelID, int markValue, String assessment){
		super();
		this.assessment  =assessment;
		this.hotelID  =hotelID;
		this.markValue  =markValue;
		this.orderID  =orderID;
	}
	

	
	
	public OrderAssessPO(String orderID , String hotelID ){
		super();
		this.hotelID  =hotelID;
		this.markValue  =  5;
		this.orderID  =orderID;
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
