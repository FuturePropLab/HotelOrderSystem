package businesslogic.member;

import java.util.ArrayList;
import java.util.List;

import dataservice.MemberDataService;
import po.ApplyPO;
import po.BackPO;
import tools.ApplyResult;
import tools.MemberBelongType;
import tools.MemberType;
import tools.ResultMessage_Member;
import vo.ApplyVO;
import vo.BackVO;

/**
 * 
 * @author lwy
 *
 */
public class MemberApply {
	
	private MemberDataService  memberDataService;
	
	
	public ResultMessage_Member addApply(ApplyVO apply) {
		MemberType membertype= new MemberType(apply.customer_ID);
		ApplyPO applypo =  new ApplyPO(apply.customer_ID,apply.type);
		
		
		if(apply.type==MemberBelongType.Enterprise) {
			//membertype.setCompanyName(apply.companyName);
			applypo.setCompanyName(apply.companyName);
			}else{
				//membertype.setBirthday(apply.birthday);
				applypo.setBirthday(apply.birthday);
			}
		
		
			
			return memberDataService.addApply(applypo);
			//return new MemberBL_Stub().addApply(apply);

	}
	
	public ResultMessage_Member addBack(BackVO back) {
		
		
		if(back.result==ApplyResult.Failed&&back.reasion!=null){
		BackPO backpo =  new BackPO(back.customer_ID,back.reasion,back.result);
		return memberDataService.addBack(backpo);
		}else if(back.result == ApplyResult.Succeed){
			BackPO backpo = new BackPO(back.customer_ID,back.reasion,back.result);
			return memberDataService.addBack(backpo);
			
		}else{
			return ResultMessage_Member.ReasionNotFound;//如果拒绝通过，则一定要有拒绝原因
		}
		
		
		//return new MemberBL_Stub().addBack(back);

	}

	public List<ApplyVO> getApplyList() {
		List <ApplyPO> applypoList = memberDataService.getApplyList();
		List <ApplyVO> applyvoList = new ArrayList<ApplyVO>();
		for(int i=0;i<applypoList.size();i++){
			ApplyPO apply = applypoList.get(i);
			ApplyVO applyvo = new ApplyVO(apply.getCustomer_ID(),apply.getType());
			applyvoList.add(applyvo);
			
		}
		
		return applyvoList;

	}

	public BackVO getBack(String customer_id) {
		
		if(customer_id==null){
			return null;
		}else{
			
			BackPO backpo = memberDataService.getBack(customer_id);
			BackVO backvo =new BackVO(backpo.customer_ID,backpo.reasion,backpo.result);
			return backvo;
			
			
		}
		//return new MemberBL_Stub().getBack(customer_id);

	}

	public ResultMessage_Member deleteApply(String apply_id) {
		if(apply_id==null)return ResultMessage_Member.NotExit;
		return memberDataService.deleteApply(apply_id);
		
		
		//return new MemberData_Stub().deleteApply(apply_id);

	}

	public ResultMessage_Member deleteBack(String back_id) {
		
		if(back_id==null) return ResultMessage_Member.NotExit;
		return memberDataService.deleteBack(back_id);
		
		//return new MemberData_Stub().deleteBack(back_id);

	}
}
