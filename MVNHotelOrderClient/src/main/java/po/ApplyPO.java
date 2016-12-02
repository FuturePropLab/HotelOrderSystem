package po;

import java.time.LocalDate;
import java.util.Date;

import tools.MemberBelongType;

public class ApplyPO {
	private String customer_ID;
	private String apply_id;//申请单的ID
	public String getApply_id() {
		return apply_id;
	}

	private MemberBelongType type=MemberBelongType.None;
	private LocalDate birthday;
	private String companyName;
	
	public void setType(MemberBelongType type) {
		this.type = type;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomer_ID() {
		return customer_ID;
	}

	public MemberBelongType getType() {
		return type;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getCompanyName() {
		return companyName;
	}

	public ApplyPO(String customer_ID, MemberBelongType type) {
		super();
		this.customer_ID = customer_ID;
		this.type = type;
		apply_id="000000003";
	}
}
