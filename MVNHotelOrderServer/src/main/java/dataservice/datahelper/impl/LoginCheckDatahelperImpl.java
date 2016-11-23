package dataservice.datahelper.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import dataservice.datahelper.LoginCheckDatahelper;
import passwordtool.DESUtil;
import passwordtool.MD5Util;
import passwordtool.ShaUtil;
import testHibernate.Hibernateutils;
import tools.AccountType;

/**
 * 
 * @author wshwbluebird
 *
 */
public class LoginCheckDatahelperImpl implements LoginCheckDatahelper {
	
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
		Query q = s.createSQLQuery("select password from accountpo where username = '"+DESid
				+"' and accounttype = '"+accountType+"'");
		List<String> passwordlist =  q.list();
		s.close();
		
		//id输入错误的情况
		if(passwordlist.isEmpty())  return "Bad_ID";
		else return passwordlist.get(0);
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
		+desid+"' and password = '"+shpass+"'");
		List<String> idlist =  q.list();
		s.close();
		if(idlist.isEmpty())  return "FAIL";
		return idlist.get(0);
	}
	
	
//	public static void main(String[] args) {
//		LoginCheckDatahelperImpl impl = new LoginCheckDatahelperImpl();
//		//System.out.println(impl.passwordInSha("zhujunyi", AccountType.Customer));
//		System.out.println(impl.getID("zhujunyi", "zhujunyi"));
//	}


}
