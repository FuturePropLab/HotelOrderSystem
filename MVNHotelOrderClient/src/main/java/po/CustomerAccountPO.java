package po;

/**
 * CustomerAccountPO 本来应该陈语嫣写的
 * @author wshwbluebird
 *
 */
public class CustomerAccountPO {
	public String customerId; //客户ID
	public String customerName; //客户姓名
	public String password;  //客户密码
	public CustomerAccountPO(String customerId,String customerName,String password){
		customerId=this.customerId;
		customerName=this.customerName;
		password=this.password;
	}
}
