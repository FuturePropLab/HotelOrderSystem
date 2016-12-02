package stub;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.MemberService;
import tools.ApplyResult;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage_Member;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;

public class MemberBL_Stub implements MemberService{
	private static final String customer_ID_test="000000002";

	
	public MemberVO getMemberInfo(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			MemberVO member=new MemberVO(customer_ID_test, new MemberType(customer_ID_test));
			return member;
		}
		return null;
	}


	public ResultMessage_Member addApply(ApplyVO apply) {
		if(apply.customer_ID.equals(customer_ID_test)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	
	public ResultMessage_Member addBack(BackVO back) {
		if(back.customer_ID.equals(customer_ID_test)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	public List<ApplyVO> getApplyList() {
		return new ArrayList<ApplyVO>();
	}


	public BackVO getBack(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			return new BackVO(customer_ID_test, "reasion", ApplyResult.Succeed);
		}
		return null;
	}

	public ResultMessage_Member modifyMemberInfo(MemberVO memberInfo) {
		if(memberInfo.customer_ID.equals(customer_ID_test)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	
}
