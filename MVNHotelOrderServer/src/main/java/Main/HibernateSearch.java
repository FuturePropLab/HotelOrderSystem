package Main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class HibernateSearch{
   // private static final Session hibernutil = null;

	public static void main(String[] args) {
        Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
        //Transaction t = s.beginTransaction(); // 提交用
        

         Query q = s.createSQLQuery("select sa from Student where sno IN (select sno from SC where g > 90)");
//         List<Object[]> obs = q.list();
//         
//         for(Object[] ob : obs){
//        	 for(int i = 0 ; i < ob.length ; i++){
//        		 System.out.print(ob[i]+" ");
//        	 }
//        	 System.out.println();
//         }
         
        List<Short> it  = q.list();
         
         for(Short ob : it){
        	 System.out.println(ob);
         }
        
//		List<Student> students = s.createQuery("from Student").list();
//        for (Student student : students) {
//
//            System.out.println("sno="+student.getSno()+" sn="+student.getSn());
//            System.out.println("介绍:   "+student.getSi());
//        }
//        
//        System.out.println("****************************************");
//		Criteria c=s.createCriteria(SC.class);
//		List<SC> list=c.list();
//		for (SC sc : list) {
//			System.out.println("sno="+sc.getScpk().getSno()+"   cno="+sc.getScpk().getCno()+"    g:"+sc.getG()); 
//		}
        s.close();
        Hibernateutils.shutdown();
       
    }
}
