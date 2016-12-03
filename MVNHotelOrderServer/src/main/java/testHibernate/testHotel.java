package testHibernate;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.HotelDataService;
import dataservice.impl.HotelDataServiceImpl;
import po.HotelPO;


public class testHotel {
		public static void main(String[] args) throws RemoteException {
			HotelDataService hotelDataService = new HotelDataServiceImpl();
			List<HotelPO> pos = hotelDataService.searchHotelListFuzzy("蓝鸟");
			
			System.out.println(pos.size());
			for (int i = 0; i < pos.size(); i++) {
				System.out.println(pos.get(i).getHotelName());
			}
			
			
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
			Hibernateutils.shutdown();

		}
}
