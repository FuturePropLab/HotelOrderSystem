package dataservice.datahelper.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.CreditLogdataHelper;
import po.CreditLogPO;
import po.CustomerPO;
import tools.ActionType;
import tools.ResultMessage;

public class CreditLogdataHelperImpl implements CreditLogdataHelper {
	
	
	private static CreditLogdataHelperImpl creditLogdataHelperImpl = null;
	
	private CreditLogdataHelperImpl(){
		
	}
	
	public static CreditLogdataHelperImpl getIntance(){
		if(creditLogdataHelperImpl==null){
			creditLogdataHelperImpl = new CreditLogdataHelperImpl();
		}
		return creditLogdataHelperImpl;
	}

	public ResultMessage addCreditLog(CreditLogPO creditLogPO) {
		if(creditLogPO.getActionType().equals(ActionType.Charge)  && creditLogPO.getOrderID()==null){
			String chargeID  = "Charge"+new Date().toString();
			creditLogPO.setOrderID(chargeID);
		}
		
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(creditLogPO);
			t.commit();
			return ResultMessage.Exist;
		} catch (Exception e) {
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}
	}

	public ResultMessage modifyCreditLog(CreditLogPO creditLogPO) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.update(creditLogPO);
			t.commit();
			return ResultMessage.Exist;
		} catch (Exception e) {
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}
	}

	public CreditLogPO getCreditLogPO(String orderID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(CreditLogPO.class);
		cr.add(Restrictions.eq("orderID", orderID));
		List<CreditLogPO>  list = cr.list();
		s.close();		
		return list.get(0);
	}
	
	
	public List<CreditLogPO> getCreditLogPOList(String customerID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		Criteria cr = s.createCriteria(CreditLogPO.class);
		cr.add(Restrictions.eq("customerID", customerID));
		List<CreditLogPO>  list = cr.list();
		s.close();		
		return list;
	}
	
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.CreditLogdataHelper#changeCredit(java.lang.String, int)
	 */
	public ResultMessage changeCredit(String customer_id, int result) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		CustomerPO customerPO  = (CustomerPO) s.load(CustomerPO.class, customer_id);
		//s.close();
		//Session s2 = Hibernateutils.getSessionFactory().openSession();
		try{		
			Transaction t = s.beginTransaction();
			customerPO.setCredit(result);
			s.update(customerPO);
			t.commit();
			return ResultMessage.Exist;
		}catch(Exception e){
			return ResultMessage.NotExist;
		}finally {
			s.close();
		}

	}

}
