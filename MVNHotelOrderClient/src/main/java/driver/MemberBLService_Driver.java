package driver;

import java.util.List;

import businesslogicservice.MemberService;
import tools.ApplyResult;
import tools.MemberBelongType;
import tools.ResultMessage;
import tools.ResultMessage_Member;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;

public class MemberBLService_Driver {
	private static final String customer_ID_test="000000002";
	
	public boolean drive(MemberService memberService) {
		MemberVO member=memberService.getMemberInfo(customer_ID_test);
		if(member==null){
			return false;
		}
		return false;
		
		/*ResultMessage_Member result=memberService.addApply(new ApplyVO(customer_ID_test, MemberBelongType.Ordinary));
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		result=memberService.addBack(new BackVO(customer_ID_test, "reasion", ApplyResult.Succeed));
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		List<ApplyVO> list=memberService.getApplyList();
		if(list==null){
			return false;
		}
		
		BackVO back=memberService.getBack(customer_ID_test);
		if(back==null){
			return false;
		}
		
		return true;*/
	}

}
