package po;

import tools.MemberType;

public class MemberPO {
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
