package businesslogic.strategy;

import tools.MemberBelongType;
import tools.MemberType;
import vo.MemberVO;

public class MockMember {
	public MemberVO getMemberInfo(String id){
		MemberType type = new MemberType(id);
		type.setType(MemberBelongType.Enterprise);
		type.setCompanyName("chenming");
		type.setLevel(5);
		MemberVO member = new MemberVO(id,type);
		return member;
		
		
	}
}
