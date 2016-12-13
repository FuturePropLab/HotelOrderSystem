package businesslogic.member;

import java.util.List;

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
public class Member {
	/**
	 * 分别委托给会员申请及回复 和 会员管理
	 */
	private MemberApply memberApply;
	private MemberManage memberManage;
	
	public Member() {
		memberApply=new MemberApply();
		memberManage=new MemberManage();
	}
	
	/*public ResultMessage_Member addApply(ApplyVO apply) {
		return memberApply.addApply(apply);

	}

	public ResultMessage_Member addBack(BackVO back) {
		return memberApply.addBack(back);

	}

	public List<ApplyVO> getApplyList() {
		return memberApply.getApplyList();

	}

	public BackVO getBack(String customer_id) {
		return memberApply.getBack(customer_id);

	}

	public ResultMessage_Member deleteApply(String apply_id) {
		return memberApply.deleteApply(apply_id);

	}

	public ResultMessage_Member deleteBack(String back_id) {
		return memberApply.deleteBack(back_id);

	}*/

	public MemberVO getMemberInfo(String customer_id) {
		return memberManage.getMemberInfo(customer_id);

	}

	public ResultMessage_Member modifyMemberInfo(MemberVO memberInfo) {
		return memberManage.modifyMemberInfo(memberInfo);

	}

}
