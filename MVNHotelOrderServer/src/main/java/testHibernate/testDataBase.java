package testHibernate;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataservice.HotelDataService;
import dataservice.impl.HotelDataServiceImpl;

public class testDataBase {
		public static void main(String[] args) throws RemoteException  {
			
			HotelDataService hotelDataService = new HotelDataServiceImpl();
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
//			List<String> list = hotelDataService.getHotelInfoString("test1");
//			Iterator<String> it = list.iterator();
//			while(it.hasNext()){
//				System.out.println(it.next());
//			}
//			System.out.println(hotelDataService.makeDir("./ImageData/HT001"));
			Hibernateutils.shutdown();
		}
}
