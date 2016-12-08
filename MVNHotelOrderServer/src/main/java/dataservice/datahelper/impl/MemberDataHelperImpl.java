package dataservice.datahelper.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import DataFactory.Hibernateutils;
import dataservice.datahelper.MemberDataHelper;
import po.MemberPO;
import po.MemberStorePO;
import tools.ResultMessage_Member;

public class MemberDataHelperImpl implements MemberDataHelper {
	
	private static MemberDataHelperImpl memberDataHelperImpl = null;
	
	private MemberDataHelperImpl(){
		
	}
	
	public static MemberDataHelperImpl getInstance(){
		if(memberDataHelperImpl == null){
			memberDataHelperImpl = new MemberDataHelperImpl();
		}
		return memberDataHelperImpl;
	}
	

	public ResultMessage_Member modifyMemberPO(MemberPO memberPO) {
		if("".equals(memberPO.getCustomer_ID()) || memberPO.getCustomer_ID()==null)
			return ResultMessage_Member.Failed;
		
		MemberStorePO memberStorePO  = new MemberStorePO(memberPO);
		
		Session s = Hibernateutils.getSessionFactory().openSession();
		
		try {
			Transaction t = s.beginTransaction();
			s.update(memberStorePO);
			t.commit();
			return ResultMessage_Member.Success;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResultMessage_Member.Failed;
		}finally {
			s.close();
		}
	}

	public MemberPO getMemberByID(String customerID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		MemberStorePO memberStorePO  = (MemberStorePO) s.load(MemberStorePO.class, customerID);
		
		try{
			System.out.println(memberStorePO.getMemberBelongType());
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}finally {
			s.close();
		}		
		MemberPO memberPO  =new MemberPO(memberStorePO);		
		return memberPO;
	}

}
 