package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.MemberDataService;
import po.ApplyPO;
import po.BackPO;
import po.MemberPO;
import tools.ApplyResult;
import tools.MemberType;
import tools.MemberType.Type;
import tools.ResultMessage;

public class MemberData_Stub implements MemberDataService{
	private static final String customer_ID_test="000000002";
	private static final String apply_id="000000003";
	private static final String back_id="000000004";

	
	public ResultMessage addMember(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public ResultMessage modifyMember(MemberPO member) {
		if(member.getCustomer_ID().equals(customer_ID_test)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public MemberPO getMember(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			return new MemberPO(customer_ID_test, new MemberType(customer_ID_test));
		}
		return null;
	}

	
	public ResultMessage addApply(ApplyPO po) {
		if(po.getApply_id().equals(apply_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}


	public ResultMessage addBack(BackPO po) {
		if(po.getBack_id().equals(back_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public ResultMessage modifyApply(ApplyPO po) {
		if(po.getApply_id().equals(apply_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public ResultMessage modifyBack(BackPO po) {
		if(po.getBack_id().equals(back_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public List<ApplyPO> getApplyList() {
		return new ArrayList<ApplyPO>();
	}

	
	public ApplyPO getApply(String apply_id) {
		if(apply_id.equals(this.apply_id)){
			return new ApplyPO(customer_ID_test, Type.Ordinary);
		}
		return null;
	}

	
	public BackPO getBack(String back_id) {
		if(back_id.equals(this.back_id)){
			return new BackPO(customer_ID_test, "reasion", ApplyResult.Succeed);
		}
		return null;
	}

	
	public ResultMessage deleteApply(String apply_id) {
		if(apply_id.equals(this.apply_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
	public ResultMessage deleteBack(String back_id) {
		if(back_id.equals(this.back_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
}
