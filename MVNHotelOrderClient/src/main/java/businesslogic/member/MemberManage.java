package businesslogic.member;

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
		return new MemberBL_Stub().getMemberInfo(customer_id);

	}

	public ResultMessage modifyMemberInfo(MemberVO memberInfo) {
		return new MemberBL_Stub().modifyMemberInfo(memberInfo);

	}

}
