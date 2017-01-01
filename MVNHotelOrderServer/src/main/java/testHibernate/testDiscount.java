package testHibernate;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import dataservice.DiscountHotelDataService;
import dataservice.DiscountWebDataService;
import dataservice.datahelper.impl.DiscountWebDataHelperImpl;
import dataservice.impl.DiscountHotelDataServiceImpl;
import dataservice.impl.DiscountWebServiceImpl;
import po.DiscountPO_hotel;
import po.DiscountPO_web;
import po.DiscountPO_web_level;
import tools.DiscountState;
import tools.Strategy_hotelType;
import tools.Strategy_webType;

public class testDiscount {
		public static void main(String[] args) throws RemoteException {
			
	//		DiscountWebDataService discountWebDataService = new DiscountWebServiceImpl();
	//		List<DiscountPO_web> list = discountWebDataService.getWebDiscount();
		
			
			//Session s = Hibernateutils.getSessionFactory().openSession();
//			DiscountPO_web_level discountPO_web_level  =
//					new DiscountPO_web_level(9.8, 3, 23, DiscountState.valid, "haha",Strategy_webType.Level);
//			discountPO_web_level.setDiscountID("DS004");
//			
			DiscountHotelDataService dataService = new DiscountHotelDataServiceImpl();
			System.out.println(dataService.invalidDiscount("DSH20170101131603880"));
			
//			DiscountDataHelperImpl dataHelperImpl = new DiscountDataHelperImpl();
//			
//			DiscountPO_web discountPO_web =  dataHelperImpl.getDiscountPO("DS001");
//			DiscountPO_web_level discountPO_web_level= 
//					(DiscountPO_web_level)discountPO_web;
			//discountPO_web_level.setDiscount(8.8);
//			discountPO_web_level.setLv(1);
			//discountPO_web_level.setRemarks("气死朱俊毅");
//			System.out.println(dataHelperImpl.modifyDiscountPO(discountPO_web_level));
			
//			System.out.println(dataHelperImpl.getALLDiscountPOList());

//			Hibernateutils.shutdown();
		}
		
}
