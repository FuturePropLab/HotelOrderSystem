package testHibernate;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.HotelDataService;
import dataservice.impl.HotelDataServiceImpl;
import po.HotelPO;
import tools.HotelAddress;
import tools.RoomType;
import tools.StandardSearch;


public class testHotel {
		public static void main(String[] args) throws RemoteException {
			HotelDataService hotelDataService = new HotelDataServiceImpl();
			StandardSearch search  = new StandardSearch();
			search.setHotelAddress(new HotelAddress("北京", null, null, null));
			search.setRoomType(RoomType.Standard);
			List<HotelPO> pos = hotelDataService.searchHotelList(search);
			
			System.out.println("noaho!!!!!!!!!!!!!!!!!");
			pos.forEach(t->System.out.println(t.getHotelName()));
//			
//			System.out.println(pos.size());
//			for (int i = 0; i < pos.size(); i++) {
//				System.out.println(pos.get(i).getHotelName());
//			}
//			HotelDataHelper hotelDataHelper = DataHelperUtils.getHotelDataHelper();
			//System.out.println(hotelDataHelper.isbooked("CS002", "HT001"));
//			String hotelID = "HT0410";
//			String hotelName= "蓝鸟之家";
//			TypeRoomInfo typeRoomInfo1 = new TypeRoomInfo(hotelID, hotelName, RoomType.Single, 0, 0.0);
//			hotelDataHelper.addTypeRoomInfo(typeRoomInfo1);
//			
//			TypeRoomInfo typeRoomInfo2 = new TypeRoomInfo(hotelID, hotelName, RoomType.Double, 0, 0.0);
//			hotelDataHelper.addTypeRoomInfo(typeRoomInfo2);
//			
//			TypeRoomInfo typeRoomInfo3 = new TypeRoomInfo(hotelID, hotelName, RoomType.Standard, 0, 0.0);
//			hotelDataHelper.addTypeRoomInfo(typeRoomInfo3);
//			
//			TypeRoomInfo typeRoomInfo4 = new TypeRoomInfo(hotelID, hotelName, RoomType.EluxeSuite, 0, 0.0);
//			hotelDataHelper.addTypeRoomInfo(typeRoomInfo4);
//			
//			TypeRoomInfo typeRoomInfo5 = new TypeRoomInfo(hotelID, hotelName, RoomType.Suites, 0, 0.0);
//			hotelDataHelper.addTypeRoomInfo(typeRoomInfo5);
//			
			//System.out.println(hotelDataService.makeDir("./ImageData/test/test"));
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
//			StandardSearch search = new StandardSearch();
//			search.setHotelAddress(new 
//					HotelAddress("北京", "西城", null, null));
			//search.setStar(Star.one);
//			search.setHigh(1000);
//			search.setRoomType(RoomType.Double);
//			search.setHotelName("皇家");
//			List<HotelPO> list = hotelDataService.searchHotelList(search);
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).getHotelName());
//				System.out.println(list.get(i).getStar());
//			}
			//Hibernateutils.shutdown();

		}
}
