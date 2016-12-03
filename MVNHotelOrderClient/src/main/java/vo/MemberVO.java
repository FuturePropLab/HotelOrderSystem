package vo;

import tools.MemberType;

/**
 *  会员信息，包括客户ID、会员类型
 *  @author zjy
 */
public class MemberVO {
	public String customer_ID;
	public MemberType memberType;
	public int level;
	/**
	 *  @param customer_ID  客户ID
	 *  @param memberType  会员类型
	 */
	public MemberVO(String customer_ID, MemberType memberType) {
		super();
		this.customer_ID = customer_ID;
		this.memberType = memberType;
	}
}
