package tools;

import java.util.Date;

import Exception.OutOfBoundsException;

/**
 *  会员类型，包含会员的类型和会员类型信息，客户ID
 *  @author zjy
 */
public class MemberType {
	Type type=Type.None;
	Date birthday;
	String companyName;
	String customer_ID;
	
	/**
	 *  @param customer_ID  客户ID
	 */
	public MemberType(String customer_ID) {
		this.customer_ID=customer_ID;
	}
	
	/**
	 *  会员的类型
	 *  @author zjy
	 */
	public enum Type{
		Ordinary,
		Enterprise,
		None
	}
}
