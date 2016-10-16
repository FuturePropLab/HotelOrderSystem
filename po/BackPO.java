package po;

import vo.ApplyResult;

public class BackPO {
	public String customer_ID;
	public String reasion;
	public ApplyResult result;
	
	public void setReasion(String reasion) {
		this.reasion = reasion;
	}

	public void setResult(ApplyResult result) {
		this.result = result;
	}

	public String getCustomer_ID() {
		return customer_ID;
	}

	public String getReasion() {
		return reasion;
	}

	public ApplyResult getResult() {
		return result;
	}

	public BackPO(String customer_ID, String reasion, ApplyResult result) {
		super();
		this.customer_ID = customer_ID;
		this.reasion = reasion;
		this.result = result;
	}
}
