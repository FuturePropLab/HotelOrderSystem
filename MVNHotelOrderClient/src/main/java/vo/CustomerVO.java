package vo;

import po.CustomerPO;

public class CustomerVO {
	  public String customerID; //客户的ID
	  public String customerName; //客户的姓名
	  public String gender; //客户的性别
	  public String telephone; //客户饿的电话
	  public int credit; //客户的信用值
	  public MemberVO membervo; //客户饿的会员信息
	  
	 public CustomerVO( String customerID, String customerName,
        String gender, String telephone, MemberVO membervo,int credit){
		   this.customerID = customerID;
		   this.customerName = customerName;
		   this.gender = gender;
		   this.membervo = membervo;
		   this.telephone =telephone;
		   this.credit = credit;
	  }
	 /**
	  *@author chenyuyan 11/22
	  *构造方法，持久化数据准转换为vo
	  *
	  */
	 public CustomerVO(CustomerPO customerpo){
		 this.customerID=customerpo.getCustomerID();
		 this.customerName=customerpo.getCustomerName();
		 this.gender=customerpo.getGender();
		 this.membervo=new MemberVO(customerpo.getMemberpo().getCustomer_ID(),customerpo.getMemberpo().getMemberType());
		 this.credit=customerpo.getCredit();
		 
	 }
	  
}
