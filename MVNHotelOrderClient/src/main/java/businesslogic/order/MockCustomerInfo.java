package businesslogic.order;

import tools.MemberBelongType;
import tools.MemberType;
import vo.CustomerVO;
import vo.MemberVO;
/**
 * 
 * @author zjy
 *
 */
public class MockCustomerInfo implements CustomerInfo{

	public CustomerVO getCustomer(String customerID) {
		// TODO Auto-generated method stub
		
		if(customerID=="0001"){
		MemberType memberType = new MemberType("0001");
		memberType.setType(MemberBelongType.Enterprise);
		return new CustomerVO(customerID, "customerName", "gender", "telephone", new MemberVO(customerID, 
				memberType),30);}
		else if(customerID=="0002"){
			MemberType memberType = new MemberType("0001");
			memberType.setType(MemberBelongType.None);
			return new CustomerVO(customerID, "customerName", "gender", "telephone", new MemberVO(customerID, 
					memberType),40);}
		else if(customerID=="0003"){
			MemberType memberType = new MemberType("0001");
			memberType.setType(MemberBelongType.None);
			return new CustomerVO(customerID, "customerName", "gender", "telephone", new MemberVO(customerID, 
					memberType),100);
		}
		else{
			MemberType memberType = new MemberType("0001");
			memberType.setType(MemberBelongType.None);
			return new CustomerVO(customerID, "customerName", "gender", "telephone", new MemberVO(customerID, 
					memberType),100);	
					}
		}
	}


