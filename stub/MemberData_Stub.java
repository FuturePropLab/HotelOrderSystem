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
import tools.ResultMessage;

public class MemberData_Stub implements MemberService{

	@Override
	public ResultMessage addmember(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifymember(MemberPO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberPO getmember(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addApply(ApplyPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addBack(BackPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyApply(ApplyPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyBack(BackPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ApplyPO> getApplyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplyPO getApply(String apply_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BackPO getBack(String back_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteApply(String apply_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteBack(String back_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
