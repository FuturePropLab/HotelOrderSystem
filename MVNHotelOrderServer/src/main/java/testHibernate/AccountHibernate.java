package testHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import passwordtool.MD5Util;
import passwordtool.ShaUtil;
import po.AccountPO;
import tools.AccountType;

public class AccountHibernate {
		public static void main(String[] args) throws Exception {
			Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
	        Transaction t = s.beginTransaction(); // 提交用
	        String id = "CS001";
	        String username="zhujunyi";
	        String password = "zhujunyi";
	        MD5Util md = new MD5Util();
	        ShaUtil sh = new ShaUtil();
	        AccountPO po = new AccountPO(id,md.md5Encode(username),sh.shaEncode(password), AccountType.Customer);
	        s.save(po);
	        t.commit();
	       // Query q = s.createSQLQuery("select sa from Student where sno IN (select sno from SC where g > 90)")
	        s.close();
	        Hibernateutils.shutdown();
	       
		}
}
