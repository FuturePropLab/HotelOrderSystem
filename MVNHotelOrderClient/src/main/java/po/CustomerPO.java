package po;

import java.io.Serializable;

public class CustomerPO implements Serializable{


	  /**
	 * 序列化id
	 */
	private static final long serialVersionUID = -4620814777325515534L;
	
	
	  private String customerID; 
	  private String customerName; //客户姓名
	  private String gender; //性别
	  private String telephone; //电话
	  private MemberPO memberpo; //会员信息
	  private int credit;
	  
	  
	  
	 public CustomerPO( String customerID, String customerName,
      String gender, String telephone, MemberPO memberpo,int credit){
		   this.customerID = customerID;
		   this.customerName = customerName;
		   this.gender = gender;
		   this.memberpo = memberpo;
		   this.telephone =telephone;
		   this.credit = credit;
	  }
	 
	/* public CustomerPO(String username,String password,
				String customerName, String telephone, String gender){
				   //this.customeID = customeID;
				   this.customerName = username;
				   this.gender = gender;
				    this.userName=username;
				    this.password=password;
				   this.telephone =telephone;
				   
			  }*/
	
	 
	  public String getCustomerID() {
		return customerID;
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
