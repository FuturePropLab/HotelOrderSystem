package testHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import passwordtool.DESUtil;
import passwordtool.MD5Util;
import passwordtool.ShaUtil;
import po.AccountPO;
import tools.AccountType;

public class AccountHibernate {
		public static void main(String[] args) throws Exception {
			Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
	        Transaction t = s.beginTransaction(); // 提交用
	        String userid = "CS001";
	        String username="zhujunyi";
	        String password = "zhujunyi";
	        AccountPO po = new AccountPO(userid,DESUtil.encode(username),ShaUtil.shaEncode(password), AccountType.Customer);
	        s.save(po);
	        t.commit();
	       // Query q = s.createSQLQuery("select sa from Student where sno IN (select sno from SC where g > 90)")
	        s.close();
	        Hibernateutils.shutdown();
	       
		}
}
