package testHibernate;

import java.rmi.RemoteException;

import DataFactory.DataHelperUtils;
import DataFactory.Hibernateutils;
import dataservice.HotelDataService;
import dataservice.datahelper.HotelDataHelper;
import dataservice.impl.HotelDataServiceImpl;
import po.HotelBasePO;
import po.HotelFacilityPO;
import po.HotelPO;
import tools.HotelFacility;
import tools.Star;

public class testHotel {
		public static void main(String[] args) throws RemoteException {
			HotelDataService hotelDataService = new HotelDataServiceImpl();
			String id  = "HT0410";
			HotelFacility hotelFacility = new HotelFacility();
			hotelFacility.setElseFacility("学习桌");
			hotelFacility.setAirCondition(true);
			hotelFacility.setGym(true);
			HotelFacilityPO hotelFacilityPO = new HotelFacilityPO(id, hotelFacility);
			//HotelBasePO hotelBasePO = new HotelBasePO(id, null, 0, Star.three);
			HotelPO hotelPO = new HotelPO();
			hotelPO.setFacility(hotelFacility);
			hotelPO.setHotelID(id);
			hotelPO.setStar(Star.one);
			hotelDataService.modifyHotel(hotelPO);
			
			
			Hibernateutils.shutdown();
		}
}
