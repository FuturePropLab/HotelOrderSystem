package dataservice.datahelper.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import dataservice.datahelper.LoginCheckDatahelper;
import passwordtool.MD5Util;
import testHibernate.Hibernateutils;
import tools.AccountType;

/**
 * 
 * @author wshwbluebird
 *
 */
public class LoginCheckDatahelperImpl implements LoginCheckDatahelper {
	

	/**
	 * 
	 */
	public boolean updataAlluserInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 实现借口方法
	 */
	public String passwordInSha(String userid, AccountType accountType) {
		MD5Util md = new MD5Util();
		String md5id = "" ;
		
		//加密失败的情况s
		try {
			md5id = md.md5Encode(userid);
		} catch (Exception e) {
			return "Bad Input";
		}
		
		//用标准的sql方法实现
		Session s = Hibernateutils.getSessionFactory().openSession();  //获取数据库连接池
		Query q = s.createSQLQuery("select password from accountpo where id = '"+md5id
				+"' and accounttype = '"+accountType+"'");
		List<String> passwordlist =  q.list();
		s.close();
		
		//id输入错误的情况
		if(passwordlist.isEmpty())  return "No this Id";
		else return passwordlist.get(0);
	}
//	public static void main(String[] args) {
//		LoginCheckDatahelperImpl impl = new LoginCheckDatahelperImpl();
//		System.out.println(impl.passwordInSha("CS002", AccountType.Customer));
//	}

}
