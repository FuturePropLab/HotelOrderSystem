package businesslogic.member;

import java.util.List;

import tools.ResultMessage;
import vo.ApplyVO;
import vo.BackVO;
import stub.MemberBL_Stub;
import stub.MemberData_Stub;

/**
 * 
 * @author lwy
 *
 */
public class MemberApply {
	
	public ResultMessage addApply(ApplyVO apply) {
		return new MemberBL_Stub().addApply(apply);

	}

	public ResultMessage addBack(BackVO back) {
		return new MemberBL_Stub().addBack(back);

	}

	public List<ApplyVO> getApplyList() {
		return new MemberBL_Stub().getApplyList();

	}

	public BackVO getBack(String customer_id) {
		return new MemberBL_Stub().getBack(customer_id);

	}

	public ResultMessage deleteApply(String apply_id) {
		return new MemberData_Stub().deleteApply(apply_id);

	}

	public ResultMessage deleteBack(String back_id) {
		return new MemberData_Stub().deleteBack(back_id);

	}
}
