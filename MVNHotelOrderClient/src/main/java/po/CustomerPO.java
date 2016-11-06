package po;

import vo.MemberVO;

public class CustomerPO {


	  private String customeID; //客户的ID
	  private String customerName; //客户的姓名
	  private String gender; //客户的性别
	  private String telephone; //客户饿的电话
	  private MemberPO memberpo; //客户饿的会员信息
	  private int credit;
	  
	 public CustomerPO( String customeID, String customerName,
      String gender, String telephone, MemberVO membervo,int credit){
		   this.customeID = customeID;
		   this.customerName = customerName;
		   this.gender = gender;
		   this.memberpo = memberpo;
		   this.telephone =telephone;
		   this.credit = credit;
	  }
	 
	  public String getCustomeID() {
		return customeID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getGender() {
		return gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public MemberPO getMemberpo() {
		return memberpo;
	}
	
	
	  public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMembervo(MemberPO memberpo) {
		this.memberpo = memberpo;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
