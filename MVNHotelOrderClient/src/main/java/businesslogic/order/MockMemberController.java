package businesslogic.order;

import tools.MemberBelongType;
import tools.MemberType;
import vo.CustomerVO;
import vo.MemberVO;

public class MockMemberController {
	public MemberVO getMemberInfo(String customer_id){

		if(customer_id=="0001"){
		MemberType memberType = new MemberType("0001");
		memberType.setType(MemberBelongType.Enterprise);
		return new MemberVO(customer_id, 
				memberType);}
		else if(customer_id=="0002"){
			MemberType memberType = new MemberType("0001");
			memberType.setType(MemberBelongType.None);
			return new MemberVO(customer_id, 
					memberType);}
		else if(customer_id=="0003"){
			MemberType memberType = new MemberType("0001");
			memberType.setType(MemberBelongType.None);
			return new MemberVO(customer_id, 
					memberType);
		}
		else{
			MemberType memberType = new MemberType("0001");
			memberType.setType(MemberBelongType.None);
			return new MemberVO(customer_id, 
					memberType);
						
					}
		
		
	
		
	}
}
