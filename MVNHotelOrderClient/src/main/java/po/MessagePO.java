package po;

import java.io.Serializable;

public class MessagePO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7167401006530812145L;
	
	private String customerID;
	private String message;
	private String orderID;
	
	
	public MessagePO(){
		super();
	}
	
	public MessagePO(String customerID,String message, String orderID){
		this.customerID = customerID;
		this.message = message;
		this.orderID  = orderID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	
}
