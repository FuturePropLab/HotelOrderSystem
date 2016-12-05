package testHibernate;

import DataFactory.Hibernateutils;
import dataservice.datahelper.impl.DiscountDataHelperImpl;
import po.DiscountPO_web;
import po.DiscountPO_web_district;
import po.DiscountPO_web_level;
import tools.DiscountState;
import tools.Strategy_webType;

public class testDiscount {
		public static void main(String[] args) {
			//Session s = Hibernateutils.getSessionFactory().openSession();
//			DiscountPO_web_level discountPO_web_level  =
//					new DiscountPO_web_level(9.9, 1, 23, DiscountState.valid, "haha",Strategy_webType.Level);
//			discountPO_web_level.setDiscountID("DS004");
			DiscountDataHelperImpl dataHelperImpl = new DiscountDataHelperImpl();
			
			DiscountPO_web discountPO_web =  dataHelperImpl.getDiscountPO("DS20161205151157239");
			DiscountPO_web_district discountPO_web_district= 
					(DiscountPO_web_district)discountPO_web;
			discountPO_web_district.setCity("nanjing");
			discountPO_web_district.setRemarks("气死朱俊毅");
			System.out.println(dataHelperImpl.modifyDiscountPO(discountPO_web_district));

			Hibernateutils.shutdown();
		}
		
}
