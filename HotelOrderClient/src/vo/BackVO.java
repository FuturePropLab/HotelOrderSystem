package vo;

import tools.ApplyResult;

/**
 *  申请回复信息，包括客户ID、申请结果、失败原因
 *  @author zjy
 */
public class BackVO {
	public String customer_ID;
	public String reasion;
	public ApplyResult result;
	
	/**
	 *  @param customer_ID  客户ID
	 *  @param reasion  失败原因
	 *  @param result  申请结果
	 */
	public BackVO(String customer_ID, String reasion, ApplyResult result) {
		super();
		this.customer_ID = customer_ID;
		this.reasion = reasion;
		this.result = result;
	}
}
