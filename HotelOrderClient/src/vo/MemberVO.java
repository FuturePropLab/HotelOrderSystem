package vo;

import tools.MemberType;

public class MemberVO {
	public String customer_ID;
	public MemberType memberType;
	
	public MemberVO(String customer_ID, MemberType memberType) {
		super();
		this.customer_ID = customer_ID;
		this.memberType = memberType;
	}
}
