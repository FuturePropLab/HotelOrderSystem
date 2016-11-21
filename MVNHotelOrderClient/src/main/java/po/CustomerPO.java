package po;

import vo.MemberVO;

public class CustomerPO {


	  private String customeID; //瀹㈡埛鐨処D
	  private String customerName; //瀹㈡埛鐨勫鍚�
	  private String gender; //瀹㈡埛鐨勬�у埆
	  private String telephone; //瀹㈡埛楗跨殑鐢佃瘽
	  private MemberPO memberpo; //瀹㈡埛楗跨殑浼氬憳淇℃伅
	  private int credit;
	  private String passworld;
	  
	 public CustomerPO( String customeID, String customerName,
      String gender, String telephone, MemberVO membervo,int credit){
		   this.customeID = customeID;
		   this.customerName = customerName;
		   this.gender = gender;
		   this.memberpo = memberpo;
		   this.telephone =telephone;
		   this.credit = credit;
	  }
	 public CustomerPO(String username,String password,
				String customerName, String telephone, String gender){
				   //this.customeID = customeID;
				   this.customerName = username;
				   this.gender = gender;
				   this.memberpo = memberpo;
				   this.telephone =telephone;
				   
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
