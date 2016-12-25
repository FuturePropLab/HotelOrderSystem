package dataservice.datahelper.impl;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dataservice.datahelper.LoginCheckDatahelper;
import passwordtool.DESUtil;
import passwordtool.ShaUtil;
import po.AccountPO;
import po.StatePO;
import testHibernate.Hibernateutils;
import tools.AccountType;
import tools.ResultMessage_Account;
import tools.ResultMessage_LoginCheck;

/**
 * 
 * @author wshwbluebird
 *
 */
public class LoginCheckDatahelperImpl implements LoginCheckDatahelper {
	
	//单件模式
	private static LoginCheckDatahelperImpl loginCheckDatahelperImpl = null;
	
	public LoginCheckDatahelperImpl(){
		
	}
	
	/**
	 * 单件模式实力化 线程不安全
	 * @return
	 */
	public static LoginCheckDatahelperImpl getInstance(){
		if(loginCheckDatahelperImpl == null){
			loginCheckDatahelperImpl = new LoginCheckDatahelperImpl();
		}
		return  loginCheckDatahelperImpl;
	}
	
	
	
	/**
	 * 实现借口方法
	 */
	public String passwordInSha(String username, AccountType accountType) {
		String DESid = "" ;
		
		//加密失败的情况s
		try {
			DESid =DESUtil.encode(username);
		} catch (Exception e) {
			return "Bad_ID";
		}
		
		//用标准的sql方法实现
		Session s = Hibernateutils.getSessionFactory().openSession();  //获取数据库连接池
		s.clear();
		s.setFlushMode(FlushMode.ALWAYS);
		s.setCacheMode(CacheMode.IGNORE);
		System.out.println(s.getCacheMode());
		s.flush();
		
//		
//		s.clear();
//		Query q = s.createSQLQuery("select password from accountpo where username = '"+DESid
//				+"' and accounttype = '"+accountType+"'");
//		List<String> passwordlist =  q.list();
//		s.close();
		Criteria cr = s.createCriteria(AccountPO.class);
		//cr.setCacheable(true);
		cr.add(Restrictions.eq("username", DESid));
		cr.add(Restrictions.eq("accountType", accountType));
		List<AccountPO> AccountPOs = cr.list();
		//s.evict(AccountPO.class);
		s.clear();
		s.flush();
		s.close();
		//id输入错误的情况
		if(AccountPOs.isEmpty())  return "Bad_ID";
		//AccountPOs.get(0).getPassword();
		else return AccountPOs.get(0).getPassword();
	}

	/**
	 *通过用户名密码获取 id
	 */
	public String getID(String username, String password) {
		String desid,shpass;
		try {
			desid = DESUtil.encode(username);
			shpass = ShaUtil.shaEncode(password);
		} catch (Exception e) {
			return "FAIL";
		}
		Session s = Hibernateutils.getSessionFactory().openSession();  //获取数据库连接池
		Query q = s.createSQLQuery("select userid from accountpo where username = '"
		+desid+"'");
		List<String> idlist =  q.list();
		s.close();
		if(idlist.isEmpty())  return "FAIL";
		return idlist.get(0);
	}

	public ResultMessage_LoginCheck addState(String accountID) {
		StatePO statePO = new StatePO(accountID);
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(statePO);
			t.commit();
			return ResultMessage_LoginCheck.Success;
		} catch (Exception e) {
			return ResultMessage_LoginCheck.hasOn;
		}finally {
			s.close();
		}
	}

	public ResultMessage_LoginCheck deleteState(String accountID) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		StatePO statePO = (StatePO) s.load(StatePO.class, accountID);	
		try {
			Transaction t = s.beginTransaction();
			s.delete(statePO);
			t.commit();
			return ResultMessage_LoginCheck.Success;
		} catch (Exception e) {
			return ResultMessage_LoginCheck.SystemError;
		}finally {
			s.close();
		}
	}

	public ResultMessage_Account deleteAll() {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {
			SQLQuery q = s.createSQLQuery("truncate table StatePO");
			q.executeUpdate();
			return ResultMessage_Account.Success;
		} catch (Exception e) {
			return ResultMessage_Account.Fail;
		}finally {
			s.close();
		}
	}
	
	
//	public static void main(String[] args) {
//		LoginCheckDatahelperImpl impl = new LoginCheckDatahelperImpl();
//		//System.out.println(impl.passwordInSha("zhujunyi", AccountType.Customer));
//		System.out.println(impl.getID("zhujunyi", "zhujunyi"));
//	}


}
