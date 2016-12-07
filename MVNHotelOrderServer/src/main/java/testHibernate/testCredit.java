package testHibernate;

import java.rmi.RemoteException;
import java.util.Date;

import dataservice.CreditDataService;
import dataservice.impl.CreditdataServiceImpl;
import po.CreditLogPO;
import tools.ActionType;

public class testCredit {
		public static void main(String[] args) throws RemoteException {
			CreditDataService creditDataService = new CreditdataServiceImpl();
//			CreditLogPO creditLogPO =new CreditLogPO
//					("CS001", ActionType.Charge, null, new Date(), 400, 100);
//			System.out.println(creditDataService.add(creditLogPO));	
			//System.out.println(creditDataService.getLogList("CS001").size());
			System.out.println(creditDataService.changeCredit("CS001", 400));
		}
}
