package dataservice.datahelper.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import DataFactory.Hibernateutils;
import dataservice.datahelper.AccountDataHelper;
import passwordtool.DESUtil;
import passwordtool.ShaUtil;
import po.AccountPO;
import po.CustomerPO;
import po.MemberPO;
import po.MemberStorePO;
import tools.AccountType;
import tools.ResultMessage;
import tools.ResultMessage_Account;

/**
 * 
 * @author wshwbluebird
 *
 */
public class AccountDataHelperImpl implements AccountDataHelper{
	private static AccountDataHelperImpl accountDataHelperImpl = null;
	
	private AccountDataHelperImpl(){
		
	}
	/**
	 * 获取单件实例化方法
	 * @return
	 */
	public static AccountDataHelperImpl getInstance(){
		if(accountDataHelperImpl==null){
			accountDataHelperImpl = new AccountDataHelperImpl();
		}
		return accountDataHelperImpl;
	}
	
	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.AccountDataHelper#resetPassword(java.lang.String, java.lang.String)
	 */
	public ResultMessage_Account resetPassword(String userid, String newPassword) {
		String password;
		try {
			 password = ShaUtil.shaEncode(newPassword);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			return ResultMessage_Account.InvalidInput; 
		}
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			
			Query q = s.createSQLQuery("select * from accountpo where userid = '"+userid+"' limit 1");
			
			if(q.list().isEmpty()){
				return ResultMessage_Account.Fail;
			}
			Transaction t = s.beginTransaction(); 
			
			
			//System.out.println("begin...");
			SQLQuery query =  s.createSQLQuery("update accountpo set password = '"
			+password+"' where userid = '"+userid+"'");
			//q.addEntity(AccountPO.class);
			query.executeUpdate();
			t.commit();
			
			return ResultMessage_Account.Success;
		}catch(Exception e){
			return ResultMessage_Account.SystemError;
		}finally {
			s.close();
		}
	}

	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.AccountDataHelper#getAccountByUserName(java.lang.String)
	 */
	public AccountPO getAccountByUserName(String username) {
		String shaUsername = DESUtil.encode(username);
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {		
			Criteria cr = s.createCriteria(AccountPO.class);
			cr.add(Restrictions.eq("username", shaUsername));
			List<AccountPO> accountPOs = cr.list();
			if(accountPOs.isEmpty()) return null;
			AccountPO accountPO =  accountPOs.get(0);
			String sha = accountPO.getUsername();
			accountPO.setUsername(DESUtil.decode(sha));
			return accountPO;
		} catch (Exception e) {
			return null;
		}finally {
			s.close();
		}
	}

	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.AccountDataHelper#getAccountByID(java.lang.String)
	 */
	public AccountPO getAccountByID(String userid) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try {		
			Criteria cr = s.createCriteria(AccountPO.class);
			cr.add(Restrictions.eq("userid", userid));
			List<AccountPO> accountPOs = cr.list();
			if(accountPOs.isEmpty()) return null;
			AccountPO accountPO =  accountPOs.get(0);
			String sha = accountPO.getUsername();
			accountPO.setUsername(DESUtil.decode(sha));
			return accountPO;
		} catch (Exception e) {
			return null;
		}finally {
			s.close();
		}
	}

	
	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.AccountDataHelper#addAccount(po.AccountPO)
	 */
	public ResultMessage_Account addAccount(AccountPO accountPO) {
		String userid = accountPO.getUserid();
		String username = DESUtil.encode(accountPO.getUsername());
		String password;
		try {
			password = ShaUtil.shaEncode(accountPO.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResultMessage_Account.InvalidInput;
		}
		Session s = Hibernateutils.getSessionFactory().openSession();
		//check if the userid or username already exits
		try {	
			Query q = s.createSQLQuery("select * from accountpo where username = '" + username + "' limit 1");
			if (!q.list().isEmpty()) {
				return ResultMessage_Account.InvalidInput;
			}
			q = s.createSQLQuery("select * from accountpo where userid = '" + userid + "' limit 1");
			if (!q.list().isEmpty()) {
				return ResultMessage_Account.InvalidGennerateID;
			}
		} catch (Exception e) {
			s.close();
			return ResultMessage_Account.SystemError;
		}
		//加密存储
		accountPO.setPassword(password);
		accountPO.setUsername(username);
		
		try {
			//插入数据
			Transaction t = s.beginTransaction();
			s.save(accountPO);
			t.commit();
			return ResultMessage_Account.Success;
		} catch (Exception e) {
			return ResultMessage_Account.SystemError;
		}finally {
			s.close();
		}
	}

	/*@
	 * (non-Javadoc)
	 * @see dataservice.datahelper.AccountDataHelper#deleteAccount(java.lang.String)
	 */
	public ResultMessage_Account deleteAccount(String userid) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		try{
			Transaction t =s.beginTransaction();
			AccountPO accountPO = (AccountPO)s.load(AccountPO.class, userid);  //加载id为 userid的accountPO
			if(accountPO==null){
				return ResultMessage_Account.Fail;
			}
			
			s.delete(accountPO);
			t.commit();
			return ResultMessage_Account.Success;
		}catch(Exception e){
			return ResultMessage_Account.SystemError;
		}finally {
			s.close();
		}
	
	}
	public List<AccountPO> getAccountList(AccountType accountType) {
		Session s = Hibernateutils.getSessionFactory().openSession();
		List<AccountPO> accountlist;
		try{
			accountlist = s.createSQLQuery("select * from accountpo where accounttype = '"+accountType+"'").addEntity(AccountPO.class).list();
			System.out.println(accountlist.size());
			Iterator<AccountPO> it = accountlist.iterator();
			while(it.hasNext()){
				AccountPO accountPO = it.next();
				accountPO.setPassword(null);
				String encodeUsername = accountPO.getUsername();
				accountPO.setUsername(DESUtil.decode(encodeUsername));
			}	
		}catch(Exception e){
			return null;
		}finally {
			s.close();
		}
		return accountlist;
	}

}
