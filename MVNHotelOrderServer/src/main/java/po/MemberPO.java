package po;

import java.io.Serializable;

import tools.MemberType;

public class MemberPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5615587847050855837L;
	private String customer_ID;
	private MemberType memberType;
	
	public String getCustomer_ID() {
		return customer_ID;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public MemberPO(String customer_ID, MemberType memberType) {
		super();
		this.customer_ID = customer_ID;
		this.memberType = memberType;
	}
}
