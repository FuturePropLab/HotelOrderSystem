package testHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class OOhibernate {
	public List<Short> getAgeByScore(){
	      Session s = Hibernateutils.getSessionFactory().openSession();  //查询
	      Query q = s.createSQLQuery("select sa from Student where sno IN (select sno from SC where g > 90)");
	      List<Short> it  = q.list();
	      s.close();
	      Hibernateutils.shutdown();
	      return it;
	}
}
