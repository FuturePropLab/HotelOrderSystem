package businesslogic.customer;

import businesslogic.member.Member;
import tools.MemberType;
import vo.MemberVO;

public class MockMember extends Member implements MemberInfo {
	public String customer_ID_test="000000002";
		
		public MemberVO getMemberInfo(String customer_id) {
			if(customer_id.equals(customer_ID_test)){
				MemberVO member=new MemberVO(customer_ID_test, new MemberType(customer_ID_test));
				return member;
			}
			return null;
		}
	
}
