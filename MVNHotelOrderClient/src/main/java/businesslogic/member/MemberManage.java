package businesslogic.member;

import dataservice.MemberDataService;
import po.MemberPO;
import stub.MemberBL_Stub;
import stub.MemberData_Stub;
import tools.ResultMessage;
import tools.ResultMessage_Member;
import vo.MemberVO;

/**
 * 
 * @author lwy
 *
 */
public class MemberManage {
	
	private MemberDataService memberDataService;
	public MemberVO getMemberInfo(String customer_id) {
		if(customer_id==null)return null;
		else {
			MemberPO memberpo = memberDataService.getMember(customer_id);
			
			return new MemberVO(memberpo.getCustomer_ID(),memberpo.getMemberType());
			
		
		
		}
		
	}

	public ResultMessage_Member modifyMemberInfo(MemberVO memberInfo) {
		
		if(memberInfo.customer_ID==null){
			return ResultMessage_Member.NotExit;
			}else{
				
				MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
				
				return memberDataService.modifyMember(memberPO);
			}
		
		
		//MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
		
	//	return new MemberBL_Stub().modifyMemberInfo(memberInfo);

	}

}
