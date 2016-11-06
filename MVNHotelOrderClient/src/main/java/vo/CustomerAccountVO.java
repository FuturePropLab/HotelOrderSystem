package vo;

public class CustomerAccountVO {
	public String customerId;
	public String customerName;
	public String password;
	public CustomerAccountVO(String customerId,String customerName,String password){
		this.customerId=customerId;
		this.customerName=customerName;
		this.password=password;
	}
}
