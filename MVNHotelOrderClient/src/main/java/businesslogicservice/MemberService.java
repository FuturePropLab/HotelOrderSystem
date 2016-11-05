package businesslogicservice;

import java.util.List;

import tools.ResultMessage;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;

public interface MemberService {
	public MemberVO getMemberInfo(String customer_id);
	public ResultMessage addApply(ApplyVO apply);
	public ResultMessage addBack(BackVO back);
	public List<ApplyVO> getApplyList();
	public BackVO getBack(String customer_id);
	public ResultMessage modifyMemberInfo (MemberVO memberInfo);
}
