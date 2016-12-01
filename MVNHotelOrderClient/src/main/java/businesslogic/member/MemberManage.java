package businesslogic.member;

import po.MemberPO;
import stub.MemberBL_Stub;
import stub.MemberData_Stub;
import tools.ResultMessage;
import vo.MemberVO;

/**
 * 
 * @author lwy
 *
 */
public class MemberManage {
	public MemberVO getMemberInfo(String customer_id) {
		if(customer_id!=null)return new MemberBL_Stub().getMemberInfo(customer_id);
		else return null;
	}

	public ResultMessage modifyMemberInfo(MemberVO memberInfo) {
		MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
		
		return new MemberBL_Stub().modifyMemberInfo(memberInfo);

	}

}
