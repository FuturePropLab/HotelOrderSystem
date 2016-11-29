package dataservice.datahelper.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.CustomerDataHelper;
import po.AccountPO;
import po.CustomerPO;
import po.MemberPO;
import po.MemberStorePO;
import tools.ResultMessage_Modify;
import tools.ResultMessage_signUp;

public class CustomerDataHelperImpl implements CustomerDataHelper {
	
	private static CustomerDataHelperImpl customerDataHelperImpl = null;
	
	private CustomerDataHelperImpl(){
		
	}
	
	public static CustomerDataHelperImpl getInstance(){
		if(customerDataHelperImpl == null)
			customerDataHelperImpl = new CustomerDataHelperImpl();
		return customerDataHelperImpl;
	}
	
	public ResultMessage_signUp add(CustomerPO customerInfo) {		
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{			
			Query q = s.createSQLQuery("select * from customerpo where customerid = '"+customerInfo.getCustomerID()+"' limit 1");			
			if(!q.list().isEmpty()){
				return ResultMessage_signUp.Wrong;
			}
		}catch(Exception e){
			return ResultMessage_signUp.Wrong;
		}
		MemberPO memberPO = customerInfo.getMemberpo();
		customerInfo.setMemberpo(null);
		MemberStorePO memberStorePO = new MemberStorePO(memberPO);
		try {
			Transaction t = s.beginTransaction();
			s.save(customerInfo);
			s.save(memberStorePO);
			t.commit();
		} catch (Exception e) {
			return ResultMessage_signUp.Wrong;
		}
		s.close();
		return ResultMessage_signUp.Success;
	}

	public CustomerPO find(String customer_id) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		CustomerPO customerPO;
		MemberStorePO memberStorePO;
		
		//try{			
			
			// find id in table customerpo
			Criteria crCustomer = s.createCriteria(CustomerPO.class);
			crCustomer.add(Restrictions.eq("customerID", customer_id));
			List<CustomerPO> customerPOs = crCustomer.list();
			if(customerPOs.isEmpty()) return null;
			customerPO = customerPOs.get(0);
			
			// find id in table memberpo
			
			Criteria crMember = s.createCriteria(MemberStorePO.class);
			crMember.add(Restrictions.eq("customerID", customer_id));
			List<MemberStorePO> memberStorePOs = crMember.list();
			if(memberStorePOs.isEmpty()) return null;
			memberStorePO = memberStorePOs.get(0);
			
//		}catch(Exception e){
//			System.out.println("wrong");
//			return null;
//		}finally {
			s.close();
		//}
		System.out.println("id was found");
		MemberPO memberPO = new MemberPO(memberStorePO);
		//System.out.println(memberStorePO.getMemberBelongType());
		customerPO.setMemberpo(memberPO);
		return customerPO;
	}

	public ResultMessage_Modify modify(CustomerPO customerInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerPO> searchCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
