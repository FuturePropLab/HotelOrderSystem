package testHibernate;

import java.rmi.RemoteException;

import DataFactory.Hibernateutils;
import dataservice.HotelDataService;
import dataservice.impl.HotelDataServiceImpl;
import po.ImageInfoPO;


public class testHotel {
		public static void main(String[] args) throws RemoteException {
			HotelDataService hotelDataService = new HotelDataServiceImpl();
			System.out.println(hotelDataService.makeDir("./ImageData/test/test"));
//			String id  = "HT0410";
//			HotelFacility hotelFacility = new HotelFacility();
//			hotelFacility.setElseFacility("学习桌");
//			hotelFacility.setAirCondition(true);
//			hotelFacility.setGym(true);
//			HotelFacilityPO hotelFacilityPO = new HotelFacilityPO(id, hotelFacility);
//			//HotelBasePO hotelBasePO = new HotelBasePO(id, null, 0, Star.three);
//			HotelPO hotelPO = new HotelPO();
//			hotelPO.setFacility(hotelFacility);
//			hotelPO.setHotelID(id);
//			hotelPO.setStar(Star.one);
//			hotelDataService.modifyHotel(hotelPO);
//			
//						
			Hibernateutils.shutdown();

		}
}
