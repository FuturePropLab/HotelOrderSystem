package businesslogic.member;

import dataservice.MemberDataService;
import po.MemberPO;
import stub.MemberBL_Stub;
import stub.MemberData_Stub;
import tools.MemberType;
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
		MemberManage manage = new MemberManage();
		
		MemberType memberType = manage.getMemberInfo(memberInfo.customer_ID).memberType;
		//≈–∂œ «∑Ò÷ÿ∏¥◊¢≤·
		if(memberType==null){
			
			MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
			
			return memberDataService.modifyMember(memberPO);
		}
		
		else{
			return ResultMessage_Member.Failed;
		}
		
		//MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
		
	//	return new MemberBL_Stub().modifyMemberInfo(memberInfo);

	}

}
