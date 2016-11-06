package po;

/**
 * CustomerAccountPO 本来应该陈语嫣写的
 * @author wshwbluebird
 *
 */
public class CustomerAccountPO {
	private String customerId; //客户ID
	private String customerName; //客户姓名
	private String password;  //客户密码
	public CustomerAccountPO(String customerId,String customerName,String password){
		this.customerId = customerId;
		this.customerName =customerName;
		this.password = password;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
