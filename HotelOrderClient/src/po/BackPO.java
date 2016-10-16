package po;

import vo.ApplyResult;

public class BackPO {
	public String customer_ID;
	public String back_id;//返回单的ID
	public String getBack_id() {
		return back_id;
	}

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
		back_id="000000004";
	}
}
