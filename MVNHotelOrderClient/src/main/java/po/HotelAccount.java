package po;

import java.io.Serializable;

public class HotelAccount implements Serializable{

	private static final long serialVersionUID = -3674650463149182777L;
	String userName;
	String customerID;
	String HotelName;
	String hotelAddress;
	String contactWay;
	




	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getCustomerID() {
		return customerID;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}



	public String getHotelName() {
		return HotelName;
	}



	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}



	public String getHotelAddress() {
		return hotelAddress;
	}



	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}



	public String getContactWay() {
		return contactWay;
	}



	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	
	
	
}
