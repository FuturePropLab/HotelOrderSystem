package businesslogic.member;

import java.rmi.RemoteException;

import businesslogic.customer.CustomerDealController;
import businesslogicservice.CustomerDealService;
import dataservice.MemberDataService;
import po.MemberPO;
import rmi.RemoteHelper;
import stub.MemberBL_Stub;
import stub.MemberData_Stub;
import tools.MemberBelongType;
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
//	public MemberData_Stub memberStub;
	/**
	 * chenyuyan，测试用构造方法
	 * @param customer_id
	 * @return
	 */
	public MemberManage(MemberData_Stub memberStub){
		this.memberDataService = memberStub;
	}
	public MemberManage(){
		memberDataService=RemoteHelper.getInstance().getMemberDataService();
	}
	
	public MemberVO getMemberInfo(String customer_id) {
//		memberStub = new MemberData_Stub();
//		memberDataService = RemoteHelper.getInstance().getMemberDataService();
		if(customer_id==null)return null;
		else {
			MemberPO memberpo;
			
				
				try {
					memberpo = memberDataService.getMember(customer_id);
				} catch (RemoteException e) {
					return null;
				}
				return new MemberVO(memberpo.getCustomer_ID(),memberpo.getMemberType());
			
//			return new MemberVO(memberpo.getCustomer_ID(),memberpo.getMemberType());
			
		
		
		}
		
	}

	public ResultMessage_Member modifyMemberInfo(MemberVO memberInfo) {
		memberDataService = RemoteHelper.getInstance().getMemberDataService();
		MemberManage manage = new MemberManage();
		
		MemberType memberType = manage.getMemberInfo(memberInfo.customer_ID).memberType;
//		MemberType memberType = memberStub.getMember(memberInfo.customer_ID).getMemberType();
//		System.out.println(memberInfo.customer_ID);
//		memberStub = new MemberData_Stub();
//		MemberPO memberpo = memberDataService.getMember(memberInfo.customer_ID);
//		MemberType memberType = memberpo.getMemberType();
		ResultMessage_Member result = null;
//		MockCustomer customer = new MockCustomer();
		//是否注册过
		if(memberType.getType().equals(MemberBelongType.None)){//没有注册过 
			if(memberInfo.memberType.getType().equals(MemberBelongType.Ordinary)){
				//普通会员，判断信用值
				
				CustomerDealService customer = CustomerDealController.getInstance();
				try {
					int credit = customer.getCustomerInfo(memberInfo.customer_ID).credit;
//					System.out.println(credit);
					if(credit>=800){
						MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
						result = memberDataService.modifyMember(memberPO);
						//result= memberDataService.modifyMember(memberPO);
					}else{
						result = ResultMessage_Member.Failed;
					}
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result= ResultMessage_Member.Failed;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result= ResultMessage_Member.Failed;
				}
				
				
				
			}else if(memberInfo.memberType.getType().equals(MemberBelongType.Enterprise)){
				MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
				
									try {
										result= memberDataService.modifyMember(memberPO);
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
//				result = memberStub.modifyMember(memberPO);
			}
			
		}
		
		else{//注册过，修改信息
			MemberPO memberPO = new MemberPO(memberInfo.customer_ID,memberInfo.memberType);
			
			try {
				result= memberDataService.modifyMember(memberPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = ResultMessage_Member.Failed;
			}
		
		}
		return result;
		
	}

}
