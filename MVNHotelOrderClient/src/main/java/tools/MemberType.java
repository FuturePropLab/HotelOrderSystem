package tools;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *  会员类型，包含会员的类型和会员类型信息，客户ID
 *  @author zjy
 */
public class MemberType  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5318461208984318873L;
	MemberBelongType type=MemberBelongType.None;
	LocalDate birthday;
	String companyName;
	String customer_ID;
	int level;
	/**
	 *  @param customer_ID  客户ID
	 */
	public MemberType(String customer_ID) {
		this.customer_ID=customer_ID;
	}
	
	public MemberBelongType getType() {
		return type;
	}

	public void setType(MemberBelongType type) {
		this.type = type;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(String customer_ID) {
		this.customer_ID = customer_ID;
	}
	//没有用
	public int getLevel(){
		return level;
	}
	public void setLevel(int level){
		this.level = level;
	}

}
