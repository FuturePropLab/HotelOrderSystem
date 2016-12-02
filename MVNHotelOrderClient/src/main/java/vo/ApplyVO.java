package vo;

import java.time.LocalDate;
import java.util.Date;

import tools.MemberBelongType;

/**
 *  申请信息，包括客户ID、申请的会员类型、生日、企业名称
 *  @author zjy
 */
public class ApplyVO {
	public String customer_ID;
	public MemberBelongType type=MemberBelongType.None;
	public LocalDate birthday;
	public String companyName;
	
	/**
	 *  @param customer_ID  客户ID
	 *  @param type  申请的会员类型
	 */
	public ApplyVO(String customer_ID, MemberBelongType type) {
		super();
		this.customer_ID = customer_ID;
		this.type = type;
	}
}
