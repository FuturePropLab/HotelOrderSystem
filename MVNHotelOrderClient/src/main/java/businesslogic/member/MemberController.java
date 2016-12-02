package businesslogic.member;

import java.util.List;

import businesslogicservice.MemberService;
import tools.ResultMessage;
import tools.ResultMessage_Member;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;

/**
 * 
 * @author lwy
 *
 */
public class MemberController implements MemberService{

	private Member member;
	
	public MemberVO getMemberInfo(String customer_id) {
		// TODO Auto-generated method stub
		return member.getMemberInfo(customer_id);
	}

	public ResultMessage_Member addApply(ApplyVO apply) {
		// TODO Auto-generated method stub
		return member.addApply(apply);
	}

	public ResultMessage_Member addBack(BackVO back) {
		// TODO Auto-generated method stub
		return member.addBack(back);
	}

	public List<ApplyVO> getApplyList() {
		// TODO Auto-generated method stub
		return member.getApplyList();
	}

	public BackVO getBack(String customer_id) {
		// TODO Auto-generated method stub
		return member.getBack(customer_id);
	}

	public ResultMessage_Member modifyMemberInfo(MemberVO memberInfo) {
		// TODO Auto-generated method stub
		return member.modifyMemberInfo(memberInfo);
	}

}
