package po;

import java.io.Serializable;

public class CustomerAccount implements Serializable{

	private static final long serialVersionUID = -7732757005565441630L;
	String userName;
	String customerID;
	String customerName;
	String gender;
	String contactWay;
	
	
	
	public CustomerAccount(AccountPO accountPO , CustomerPO customerPO){
		this.userName = accountPO.getUsername();
		this.customerID = customerPO.getCustomerID();
		this.contactWay = customerPO.getTelephone();
		this.customerName = customerPO.getCustomerName();
		this.gender = customerPO.getGender();
	}
	
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactWay() {
		return contactWay;
	}
	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	
	
}
