package dataservice.datahelper.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.MemberDataHelper;
import po.CustomerPO;
import po.DiscountPO_web_level;
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

	
	public ResultMessage_Member addMemberPO(MemberPO memberPO) {
		if("".equals(memberPO.getCustomer_ID()) || memberPO.getCustomer_ID()==null)
			return ResultMessage_Member.Failed;
		
		MemberStorePO memberStorePO  = new MemberStorePO(memberPO);
		
		Session s = Hibernateutils.getSessionFactory().openSession();
		
		try {
			Transaction t = s.beginTransaction();
			s.save(memberStorePO);
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

	@Override
	public int getLevel(String customerID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		CustomerPO customerPO = (CustomerPO) s.load(CustomerPO.class, customerID);
		try{
			System.out.println(customerPO.getCredit());
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}finally {
			s.close();
		}
		
		int credit = customerPO.getCredit();
		s = Hibernateutils.getSessionFactory().openSession();
		Criteria crnew = s.createCriteria(DiscountPO_web_level.class);
		List<DiscountPO_web_level> discountPO_web_level = crnew.list();
		s.close();
		
		int level = 0 ;
		int i = 0;
		while(credit > 0 && i < discountPO_web_level.size()){
			int temp = discountPO_web_level.get(i).getLevelUpCredit();
			if(credit>=temp )
				level++;
			credit -= temp;
			i++;
		}
		
		return level;
	}

}
 