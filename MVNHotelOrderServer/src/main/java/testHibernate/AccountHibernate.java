package testHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import passwordtool.DESUtil;
import passwordtool.MD5Util;
import passwordtool.ShaUtil;
import po.AccountPO;
import po.CustomerPO;
import po.MemberPO;
import po.MemberStorePO;
import tools.AccountType;
import tools.MemberBelongType;
import tools.MemberType;

public class AccountHibernate {
		public static void main(String[] args) throws Exception {
			Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
	        Transaction t = s.beginTransaction(); // 提交用
	        String customerid = "CS001";
	        String customerName="朱俊逸";
	        String gender = "男";
	        String telelphone = "13654323421";
	        
	        MemberType memberType = new MemberType("CS001");
			memberType.setCompanyName("开心大酒店");
			memberType.setType(MemberBelongType.Enterprise);
			MemberPO memberPO = new MemberPO("CS001", memberType);
			
			MemberStorePO po = new MemberStorePO(memberPO);
	        //MemberPO memberPO  =null;
	        //CustomerPO po = new CustomerPO(customerid, customerName, gender, telelphone, memberPO, 20);
	        //AccountPO po = new AccountPO(userid,DESUtil.encode(username),ShaUtil.shaEncode(password), AccountType.Customer);
	        s.save(po);
	        t.commit();
	       // Query q = s.createSQLQuery("select sa from Student where sno IN (select sno from SC where g > 90)")
	        s.close();
	        Hibernateutils.shutdown();
	       
		}
}
