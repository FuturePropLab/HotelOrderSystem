package testHibernate;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dataservice.CustomerDataService;
import dataservice.impl.CustomerDataServiceImpl;
import po.CustomerPO;
import po.MemberPO;
import po.MemberStorePO;

public class testDataBase {
		public static void main(String[] args) throws RemoteException  {
			CustomerDataService customerDataService = new CustomerDataServiceImpl();
//			CustomerPO customerPO = null;
//			try {
//				customerPO = customerDataService.find("CS001");
//			} catch (RemoteException e) {
//				System.out.println("rmi");
//			}
//			customerPO.setMemberpo(null);
//			customerPO.setCustomerID("CS003");
//			customerPO.setCredit(280);
//			customerPO.setTelephone("13601471688");
//			System.out.println(customerDataService.modify(customerPO));
			List<CustomerPO> customerlist = customerDataService.searchCustomer();
			if(customerlist==null){
				System.out.println("null");
			}else{
				Iterator<CustomerPO> it = customerlist.iterator();
				while(it.hasNext()){
					CustomerPO customerPO = it.next();
					System.out.println(customerPO.getCustomerID());
					System.out.println(customerPO.getCustomerName());
					System.out.println(customerPO.getGender());
					System.out.println(customerPO.getCredit());
					MemberPO memberPO = customerPO.getMemberpo();
					System.out.println(memberPO.getMemberType().getType());
					//customerPO.setMemberpo(memberPO);
					System.out.println();
				}
			}
			Hibernateutils.shutdown();
		}
}
