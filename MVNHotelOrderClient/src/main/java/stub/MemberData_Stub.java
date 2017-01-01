package stub;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
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

public class MemberData_Stub implements MemberDataService{
	private static final String customer_ID_test="000000002";
	private static final String apply_id="000000003";
	private static final String back_id="000000004";
	private static final String customer_ID_test2="000000008";
	
	public ResultMessage_Member addMember(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	
	public ResultMessage_Member modifyMember(MemberPO member) {
		if(member!=null){return ResultMessage_Member.Success;}
		else{
			return ResultMessage_Member.Failed;
		}
	}

	
	public MemberPO getMember(String customer_id) {
		if(customer_id.equals(customer_ID_test)){
			MemberType memberType = new MemberType(customer_ID_test);
			LocalDate birthday =  LocalDate.of(2016, 3, 8);
			memberType.setBirthday(birthday);
			
			return new MemberPO(customer_ID_test, new MemberType(customer_ID_test));
		}
		
		else{
			
		MemberType type= new MemberType(customer_id);
		type.setType(MemberBelongType.None);
//		System.out.println("not exit");
		return new MemberPO(customer_id,type);
		
		}
	}

	
	public ResultMessage_Member addApply(ApplyPO po) {
		if(po.getApply_id().equals(apply_id)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}


	public ResultMessage_Member addBack(BackPO po) {
		if(po.getBack_id().equals(back_id)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	
	public ResultMessage_Member modifyApply(ApplyPO po) {
		if(po.getApply_id().equals(apply_id)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	
	public ResultMessage_Member modifyBack(BackPO po) {
		if(po.getBack_id().equals(back_id)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	
	public List<ApplyPO> getApplyList() {
		return new ArrayList<ApplyPO>();
	}

	
	public ApplyPO getApply(String apply_id) {
		if(apply_id.equals(this.apply_id)){
			return new ApplyPO(customer_ID_test, MemberBelongType.Ordinary);
		}
		return null;
	}

	
	public BackPO getBack(String back_id) {
		if(back_id.equals(this.back_id)){
			return new BackPO(customer_ID_test, "reasion", ApplyResult.Succeed);
		}
		return null;
	}

	
	public ResultMessage_Member deleteApply(String apply_id) {
		if(apply_id.equals(this.apply_id)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}

	
	public ResultMessage_Member deleteBack(String back_id) {
		if(back_id.equals(this.back_id)){
			return ResultMessage_Member.Success;
		}
		return ResultMessage_Member.Failed;
	}


	@Override
	public int getLevel(String customerID) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
