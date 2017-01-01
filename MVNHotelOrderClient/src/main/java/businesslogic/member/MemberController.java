package businesslogic.member;

import java.rmi.RemoteException;
import java.util.List;

import businesslogic.credit.Credit;
import businesslogic.credit.CreditController;
import businesslogicservice.MemberService;
import dataservice.DiscountWebDataService;
import dataservice.MemberDataService;
import dataservice.OrderDataService;
import rmi.RemoteHelper;
import tools.ResultMessage;
import tools.ResultMessage_Member;
import vo.ApplyVO;
import vo.BackVO;
import vo.MemberVO;

/**
 * 
 * @author lwy
 *
 */
public class MemberController implements MemberService{

	private MemberManage member;
	private MemberDataService memberDataService;
	private static MemberController memberController;
	private DiscountWebDataService discountWebDataService;
	private MemberController() {
		// TODO Auto-generated constructor stub
		this.member = new MemberManage();
	} 
	
	
	
	public static MemberController getInstance(){
		if(memberController==null) memberController=new MemberController();
		return memberController;
	}
	public MemberController(MemberDataService memberDataService){
		this.memberDataService = memberDataService;
	}
	
	public MemberVO getMemberInfo(String customer_id) {
		// TODO Auto-generated method stub
		MemberVO memberVO = member.getMemberInfo(customer_id);
		int level = 0;
		try {
			memberDataService = RemoteHelper.getInstance().getMemberDataService();
			level = memberDataService.getLevel(customer_id);
		} catch (RemoteException e) {
			level = 0;
		}
		memberVO.level  =level;
		System.out.println("2017:  memberVO.level :"  +memberVO.level);
		
		
		return memberVO;
	}

	/*public ResultMessage_Member addApply(ApplyVO apply) {
		// TODO Auto-generated method stub
		return member.addApply(apply);
	}

	public ResultMessage_Member addBack(BackVO back) {
		// TODO Auto-generated method stub
		return member.addBack(back);
	}

	public List<ApplyVO> getApplyList() {
		// TODO Auto-generated method stub
		return member.getApplyList();
	}

	public BackVO getBack(String customer_id) {
		// TODO Auto-generated method stub
		return member.getBack(customer_id);
	}
*/
	public ResultMessage_Member modifyMemberInfo(MemberVO memberInfo) {
		// TODO Auto-generated method stub
		return member.modifyMemberInfo(memberInfo);
	}

}
