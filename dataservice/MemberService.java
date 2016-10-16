package dataservice;

import java.util.List;

import po.ApplyPO;
import po.BackPO;
import po.MemberPO;
import tools.ResultMessage;

public interface MemberService {

	public ResultMessage addmember(String customer_id);
	public ResultMessage modifymember(MemberPO member);
	public MemberPO getmember(String customer_id);
	public ResultMessage addApply(ApplyPO po);
	public ResultMessage addBack (BackPO po);
	public ResultMessage modifyApply(ApplyPO po);
	public ResultMessage modifyBack(BackPO po);
	public List<ApplyPO> getApplyList ();
	public ApplyPO getApply(String apply_id);
	public BackPO getBack (String back_id);
	public ResultMessage deleteApply(String apply_id);
	public ResultMessage deleteBack (String back_id);
}
