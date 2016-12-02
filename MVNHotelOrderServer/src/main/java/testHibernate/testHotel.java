package testHibernate;

import java.nio.channels.NonWritableChannelException;
import java.rmi.RemoteException;

import DataFactory.Hibernateutils;
import dataservice.HotelDataService;
import dataservice.impl.HotelDataServiceImpl;
import javafx.scene.image.Image;
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
			
			Image image = new Image(url)
			
			
			Hibernateutils.shutdown();
		}
}
