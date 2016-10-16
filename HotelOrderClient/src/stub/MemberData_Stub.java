package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.MemberService;
import dataservice.OrderService;
import po.ApplyPO;
import po.BackPO;
import po.MemberPO;
import po.OrderPO;
import po.SearchOrderInfo;
import tools.MemberType;
import tools.MemberType.Type;
import vo.ApplyResult;
import tools.ResultMessage;

public class MemberData_Stub implements MemberService{
	private static final String customer_ID_test="000000002";
	private static final String apply_id="000000003";
	private static final String back_id="000000004";

	@Override
	public ResultMessage addMember(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage modifyMember(MemberPO member) {
		if(member.getCustomer_ID().equals(customer_ID_test)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public MemberPO getMember(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			return new MemberPO(customer_ID_test, new MemberType(customer_ID_test));
		}
		return null;
	}

	@Override
	public ResultMessage addApply(ApplyPO po) {
		if(po.getApply_id().equals(apply_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage addBack(BackPO po) {
		if(po.getBack_id().equals(back_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage modifyApply(ApplyPO po) {
		if(po.getApply_id().equals(apply_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage modifyBack(BackPO po) {
		if(po.getBack_id().equals(back_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public List<ApplyPO> getApplyList() {
		return new ArrayList<ApplyPO>();
	}

	@Override
	public ApplyPO getApply(String apply_id) {
		if(apply_id.equals(this.apply_id)){
			return new ApplyPO(customer_ID_test, Type.Ordinary);
		}
		return null;
	}

	@Override
	public BackPO getBack(String back_id) {
		if(back_id.equals(this.back_id)){
			return new BackPO(customer_ID_test, "reasion", ApplyResult.Succeed);
		}
		return null;
	}

	@Override
	public ResultMessage deleteApply(String apply_id) {
		if(apply_id.equals(this.apply_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage deleteBack(String back_id) {
		if(back_id.equals(this.back_id)){
			return ResultMessage.Exist;
		}
		return ResultMessage.NotExist;
	}

	
}
