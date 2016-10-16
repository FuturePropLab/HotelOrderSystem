package vo;

public class BackVO {
	public String customer_ID;
	public String reasion;
	public ApplyResult result;
	
	public BackVO(String customer_ID, String reasion, ApplyResult result) {
		super();
		this.customer_ID = customer_ID;
		this.reasion = reasion;
		this.result = result;
	}
}
