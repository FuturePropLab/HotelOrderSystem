//
//package stub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//
//import dataservice.HotelDataService;
//import po.HotelPO;
//import tools.HotelRoomInfo;
//import tools.ResultMessage_Hotel;
//import tools.SearchHotel;
//import tools.Star;
//
//public class HotelData_Stub implements HotelDataService{
//
//	
//	public ResultMessage_Hotel addHotelInfo(HotelPO hotelInfo) {
//		// TODO Auto-generated method stub
//		return ResultMessage_Hotel.fail;
//	}
//
//	
//	public ResultMessage_Hotel modifyHotelInfo(HotelPO hotelInfoPO) {
//		// TODO Auto-generated method stub
//		return ResultMessage_Hotel.fail;
//	}
//
//	
////	public HotelPO getHotelInfo(String hotel_id) {
////		// TODO Auto-generated method stub
////		HotelPO hotelinfo=new HotelPO();
////		hotelinfo.setComeAddr("xinjiekou");
////		hotelinfo.setFacility("room1");
////		hotelinfo.setGrade("good");
////		hotelinfo.setHotelAddress("nanjing");
////		hotelinfo.setHotelID("100");
////		hotelinfo.setHotelName("ronghua");
//		
//		
//		HotelRoomInfo hotelroom=new HotelRoomInfo();
//		hotelroom.setHotelID("100");
//		hotelroom.setHotelName("ronghua");
//		
//		
//		hotelinfo.setHotelRoomPO(hotelroom);
//		
//		hotelinfo.setIntroduction("good");
//		hotelinfo.setStar(Star.five);
//		return hotelinfo;
//	}
//
//	
//	public List<HotelPO> searchHotelList(SearchHotel searchhotel) {
//		// TODO Auto-generated method stub
//		HotelPO hotelinfo=new HotelPO();
//		hotelinfo.setComeAddr("xinjiekou");
//		hotelinfo.setFacility("room1");
//		hotelinfo.setGrade("good");
//		hotelinfo.setHotelAddress("nanjing");
//		hotelinfo.setHotelID("100");
//		hotelinfo.setHotelName("ronghua");
//		
//		
//		HotelRoomInfo hotelroom=new HotelRoomInfo();
//		hotelroom.setHotelID("100");
//		hotelroom.setHotelName("ronghua");
//		
//		
//		hotelinfo.setHotelRoomPO(hotelroom);
//		
//		hotelinfo.setIntroduction("good");
//		hotelinfo.setStar(Star.five);
//		
//		List<HotelPO> hotellist=new ArrayList<HotelPO>();
//		 hotellist.add(hotelinfo);
//		
//		return  hotellist;
//	}
//
//
//	public ResultMessage_Hotel addHotel(HotelPO hotelPO) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public ResultMessage_Hotel modifyHotel(HotelPO hotelPO) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public HotelPO getHotel(String hotel_id) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
