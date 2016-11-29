package po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import tools.MemberBelongType;

@Entity
public class MemberStorePO {
	private String customerID;
	private MemberBelongType memberBelongType;
	private Date birthday;
	private String companyName;
	
	
	//hiberbate use this constructor  do not delete
	public MemberStorePO(){
		
	}
	
	//默认的构造方法
	public MemberStorePO(String customerID ,MemberBelongType memberBelongType,	Date birthday,
	String companyName ){
		this.birthday = birthday;
		this.companyName = companyName;
		this.customerID = customerID;
		this.memberBelongType = memberBelongType;
	}
	
	//用传过来的memberPO 进行构造
	public MemberStorePO(MemberPO memberPO){
		this.customerID = memberPO.getCustomer_ID();
		this.birthday = memberPO.getMemberType().getBirthday();
		this.memberBelongType = memberPO.getMemberType().getType();
		this.companyName = memberPO.getMemberType().getCompanyName();
	}
	@Id
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	@Enumerated(EnumType.STRING)
	public MemberBelongType getMemberBelongType() {
		return memberBelongType;
	}

	public void setMemberBelongType(MemberBelongType memberBelongType) {
		this.memberBelongType = memberBelongType;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}	
