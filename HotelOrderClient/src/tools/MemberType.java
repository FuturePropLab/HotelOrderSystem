package tools;

import java.util.Date;

public class MemberType {
	Type type=Type.None;
	Date birthday;
	String companyName;
	String customer_ID;
	
	public MemberType(String customer_ID) {
		this.customer_ID=customer_ID;
	}
	
	public enum Type{
		Ordinary,
		Enterprise,
		None
	}
}
