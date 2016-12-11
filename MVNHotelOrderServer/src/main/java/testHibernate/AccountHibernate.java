package testHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dataservice.datahelper.AccountDataHelper;
import po.AccountPO;
import po.HotelFacilityPO;
import tools.AccountType;
import tools.HotelFacility;

public class AccountHibernate {
		public static void main(String[] args) throws Exception {
			//Session s = Hibernateutils.getSessionFactory().openSession();  //查询用
	        //Transaction t = s.beginTransaction(); // 提交用
	        AccountDataHelper accountDataHelper = DataFactory.DataHelperUtils.getAccountDataHelper();
	        
	        AccountPO accountPO = new AccountPO("AD001", "admin", "admin", AccountType.Administor);
	        System.out.println(accountDataHelper.addAccount(accountPO));
	        //HotelBasePO hotelBasePO = new HotelBasePO("HT001", "朱俊逸皇家酒店", 10.0, Star.five);
	        //s.save(hotelBasePO);
	        //t.commit();
//	        HotelFacility hotelFacility = new HotelFacility();
//	        hotelFacility.setAirCondition(true);
//	        hotelFacility.setComputer(true);
//	        HotelFacilityPO hotelFacilityPO =  new HotelFacilityPO("HT001",hotelFacility);
//	        s.save(hotelFacilityPO);
//	        t.commit();        
//	        s.close();
	        Hibernateutils.shutdown();
	        
	        
		}
	
}
