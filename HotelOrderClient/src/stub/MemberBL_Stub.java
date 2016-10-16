package stub;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.MemberService;
import businesslogicservice.OrderService;
import tools.MemberType;
import tools.OrderState;
import tools.ResultMessage;
import vo.ApplyResult;
import vo.ApplyVO;
import vo.BackVO;
import vo.ExecutionInfoVO;
import vo.MemberVO;
import vo.OrderInputVO;
import vo.OrderVO;
import vo.SearchHotelVO;

public class MemberBL_Stub implements MemberService{
	private static final String customer_ID_test="000000002";

	@Override
	public MemberVO getMemberInfo(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			MemberVO member=new MemberVO(customer_ID_test, new MemberType(customer_ID_test));
			return member;
		}
		return null;
	}

	@Override
	public ResultMessage addApply(ApplyVO apply) {
		if(apply.customer_ID.equals(customer_ID_test)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage addBack(BackVO back) {
		if(back.customer_ID.equals(customer_ID_test)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public List<ApplyVO> getApplyList() {
		return new ArrayList<ApplyVO>();
	}

	@Override
	public BackVO getBack(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			return new BackVO(customer_ID_test, "reasion", ApplyResult.Succeed);
		}
		return null;
	}

	@Override
	public ResultMessage modifyMemberInfo(MemberVO memberInfo) {
		if(memberInfo.customer_ID.equals(customer_ID_test)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
}
