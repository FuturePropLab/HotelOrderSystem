package testHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import po.AccountPO;
public class HibernateSearch{
   // private static final Session hibernutil = null;

	public static void main(String[] args) {
        Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
        Transaction t = s.beginTransaction(); // 提交用
        
        AccountPO accountPO = (AccountPO)s.load(AccountPO.class, "CR002");
        System.out.println(accountPO.getUsername());
        System.out.println(accountPO==null);
        

        
        s.close();
        Hibernateutils.shutdown();
       
    }
}
