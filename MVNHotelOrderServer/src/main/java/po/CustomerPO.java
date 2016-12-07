package po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
	  
	  
	  /**
	   * hibernate use this do not delete 
	   */
	 public CustomerPO(){
		 
	 }
	 
	 /**
	  * i use this consrtuct
	  * @param customerID
	  * @param customerName
	  * @param gender
	  * @param telephone
	  * @param memberpo
	  * @param credit
	  */
	 public CustomerPO( String customerID, String customerName,
      String gender, String telephone, MemberPO memberpo,int credit){
		   this.customerID = customerID;
		   this.customerName = customerName;
		   this.gender = gender;
		   this.memberpo = memberpo;
		   this.telephone =telephone;
		   this.credit = credit;
	  }


	 @Id
	public String getCustomerID() {
		return customerID;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public MemberPO getMemberpo() {
		return memberpo;
	}



	public void setMemberpo(MemberPO memberpo) {
		this.memberpo = memberpo;
	}



	public int getCredit() {
		return credit;
	}



	public void setCredit(int credit) {
		this.credit = credit;
	}

}
