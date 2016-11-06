package vo;

public class CustomerVO {
	  public String customerID; //客户的ID
	  public String customerName; //客户的姓名
	  public String gender; //客户的性别
	  public String telephone; //客户饿的电话
	  public MemberVO membervo; //客户饿的会员信息
	  
	 public CustomerVO( String customerID, String customerName,
        String gender, String telephone, MemberVO membervo){
		   this.customerID = customerID;
		   this.customerName = customerName;
		   this.gender = gender;
		   this.membervo = membervo;
		   this.telephone =telephone;
	  }
	  
}
