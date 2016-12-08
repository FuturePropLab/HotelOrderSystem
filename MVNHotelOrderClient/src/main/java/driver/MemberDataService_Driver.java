package driver;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.MemberDataService;
import po.ApplyPO;
import po.BackPO;
import po.MemberPO;
import tools.ApplyResult;
import tools.MemberBelongType;
import tools.MemberType;
import tools.ResultMessage;
import tools.ResultMessage_Member;

public class MemberDataService_Driver {
	private static final String customer_ID_test="000000002";
	private static final String apply_id="000000003";
	private static final String back_id="000000004";
	
	public boolean drive(MemberDataService memberService) {
//		ResultMessage_Member result=memberService.addMember(customer_ID_test);
//		if(result.equals(ResultMessage.NotExist)){
//			return false;
//		}
		
		ResultMessage_Member result = null;
		try {
			result = memberService.modifyMember(new MemberPO(customer_ID_test, new MemberType(customer_ID_test)));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		MemberPO member = null;
		try {
			member = memberService.getMember(customer_ID_test);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(member==null){
			return false;
		}
		
		/*result=memberService.addApply(new ApplyPO(customer_ID_test, MemberBelongType.Ordinary));
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		result=memberService.addBack(new BackPO(customer_ID_test, "reasion", ApplyResult.Succeed));
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		result=memberService.modifyApply(new ApplyPO(customer_ID_test, MemberBelongType.Ordinary));
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		result=memberService.modifyBack(new BackPO(customer_ID_test, "reasion", ApplyResult.Succeed));
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		List<ApplyPO> list=memberService.getApplyList();
		if(list==null){
			return false;
		}
		
		ApplyPO applyPO=memberService.getApply(apply_id);
		if(applyPO==null){
			return false;
		}
		
		result=memberService.deleteApply(apply_id);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}
		
		result=memberService.deleteBack(back_id);
		if(result.equals(ResultMessage.NotExist)){
			return false;
		}*/
		
		
		return true;
	}

}
