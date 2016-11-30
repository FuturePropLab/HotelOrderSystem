package testHibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dataservice.datahelper.AddressDataHelper;
import dataservice.datahelper.impl.AddressDataHelperImpl;
import passwordtool.DESUtil;
import passwordtool.MD5Util;
import passwordtool.ShaUtil;
import po.AccountPO;
import po.CityDistributePO;
import po.CustomerPO;
import po.DistributeCommercialPO;
import po.MemberPO;
import po.MemberStorePO;
import tools.AccountType;
import tools.MemberBelongType;
import tools.MemberType;

public class AccountHibernate {
		public static void main(String[] args) throws Exception {
//			Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
//	        Transaction t = s.beginTransaction(); // 提交用
//	        s.close();
//	        Hibernateutils.shutdown();
			
			AddressDataHelper addressDataHelper = new AddressDataHelperImpl();
			List<String> distributes = addressDataHelper.getDistributeList("北京");
			Iterator<String>  it = distributes.iterator();
			while(it.hasNext()){
				String dis = it.next();
				System.out.println(dis);
				List<String> bs = addressDataHelper.getBusinessCircleList(dis);
				Iterator<String>  bsit= bs.iterator();
				while(bsit.hasNext()){
					System.out.println(bsit.next());
				}
				
				System.out.println();
			}
	       
		}
}
