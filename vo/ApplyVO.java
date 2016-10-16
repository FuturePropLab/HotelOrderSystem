package vo;

import java.util.Date;

import tools.MemberType.Type;

public class ApplyVO {
	public String customer_ID;
	public Type type=Type.None;
	public Date birthday;
	public String companyName;
	
	public ApplyVO(String customer_ID, Type type) {
		super();
		this.customer_ID = customer_ID;
		this.type = type;
	}
}
