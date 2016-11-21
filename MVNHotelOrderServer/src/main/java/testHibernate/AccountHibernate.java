package testHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import passwordtool.MD5Util;
import passwordtool.ShaUtil;
import tools.AccountType;

public class AccountHibernate {
		public static void main(String[] args) throws Exception {
			Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
	        Transaction t = s.beginTransaction(); // 提交用
	        String id = "ID001";
	        String password = "nothing";
	        MD5Util md = new MD5Util();
	        ShaUtil sh = new ShaUtil();
	        AccountPO po = new AccountPO(md.md5Encode(id),sh.shaEncode(password), "what", AccountType.Customer);
	        s.save(po);
	        t.commit();
	       // Query q = s.createSQLQuery("select sa from Student where sno IN (select sno from SC where g > 90)")
	        s.close();
	        Hibernateutils.shutdown();
	       
		}
}
