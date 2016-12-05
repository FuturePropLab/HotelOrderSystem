package testHibernate;

import DataFactory.Hibernateutils;
import dataservice.datahelper.impl.DiscountDataHelperImpl;
import po.DiscountPO_web_district;
import tools.DiscountState;
import tools.Strategy_webType;

public class testDiscount {
		public static void main(String[] args) {
			//Session s = Hibernateutils.getSessionFactory().openSession();
//			DiscountPO_web_level discountPO_web_level  =
//					new DiscountPO_web_level(9.9, 5, 23, DiscountState.valid, "haha",Strategy_webType.Level);
//			discountPO_web_level.setDiscountID("DS002");
			DiscountDataHelperImpl dataHelperImpl = new DiscountDataHelperImpl();
//			System.out.println(dataHelperImpl.getDiscountPOWebDistrictList("DS008").isEmpty());
			
//			DiscountPO_web_district discountPO_web_district = 
//					new DiscountPO_web_district(11, "beijing", "district", "hllo", 6.9, 
//							DiscountState.valid, "气死我了", Strategy_webType.VIP_district);
//			
//			System.out.println(dataHelperImpl.getDiscountPOWebDistrictList());
//			DiscountPO_web_level discountPO_web_level = (DiscountPO_web_level) s.load(DiscountPO_web_level.class, "DS001");
//			System.out.println(discountPO_web_level.getDiscountID());
//			DiscountPO_web d = discountPO_web_level;
//			DiscountPO_web_level i = (DiscountPO_web_level)d;
			//System.out.println(discountPO_web_level.);
			//System.out.println(i.getLevelUpCredit());
			//System.out.println(test.getLevelUpCredit());
//			Transaction t = s.beginTransaction();
//			s.save(discountPO_web_level);
//			t.commit();
			//s.close();
			Hibernateutils.shutdown();
		}
		
}
