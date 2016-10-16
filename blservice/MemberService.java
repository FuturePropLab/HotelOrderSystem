package blservice;

import java.util.List;

import po.MemberInfo;
import tools.ResultMessage;
import vo.ApplyVO;
import vo.BackVO;
import vo.ExecutionInfoVO;
import vo.MemberVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;

public interface MemberService {
	public MemberVO getMemberInfo(String customer_id);
	public ResultMessage addApply(ApplyVO apply);
	public ResultMessage addBack(BackVO back);
	public List<ApplyVO> getApplyList();
	public BackVO getBack(String customer_id);
	public ResultMessage modifyMemberInfo (MemberVO memberInfo);
}
