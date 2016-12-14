
package stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataservice.HotelDataService;
import po.HotelPO;
import po.ImageInfoPO;
import po.OrderAssessPO;
import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.ResultMessage_Hotel;
import tools.RoomType;
import tools.StandardSearch;
import tools.Star;
import tools.TypeRoomInfo;
import vo.HotelInputVO;

public class HotelData_Stub implements HotelDataService{

	
	public ResultMessage_Hotel addHotelInfo(HotelPO hotelInfo) {
		// TODO Auto-generated method stub
		return ResultMessage_Hotel.fail;
	}

	
	public ResultMessage_Hotel modifyHotelInfo(HotelPO hotelInfoPO) {
		// TODO Auto-generated method stub
		return ResultMessage_Hotel.fail;
	}

	
//	public HotelPO getHotelInfo(String hotel_id) {
//		// TODO Auto-generated method stub
//		HotelPO hotelinfo=new HotelPO();
//		hotelinfo.setComeAddr("xinjiekou");
//		hotelinfo.setFacility("room1");
//		hotelinfo.setGrade("good");
//		hotelinfo.setHotelAddress("nanjing");
//		hotelinfo.setHotelID("100");
//		hotelinfo.setHotelName("ronghua");
		
		
		/*HotelRoomInfo hotelroom=new HotelRoomInfo();
		hotelroom.setHotelID("100");
		hotelroom.setHotelName("ronghua");
		
		
		hotelinfo.setHotelRoomPO(hotelroom);
		
		hotelinfo.setIntroduction("good");
		hotelinfo.setStar(Star.five);
		return hotelinfo;
	}*/


	
	/*public List<HotelPO> searchHotelList(SearchHotel searchhotel) {
		// TODO Auto-generated method stub
		HotelPO hotelinfo=new HotelPO();
		hotelinfo.setComeAddr("xinjiekou");
		hotelinfo.setFacility("room1");
		hotelinfo.setGrade("good");
		hotelinfo.setHotelAddress("nanjing");
		hotelinfo.setHotelID("100");
		hotelinfo.setHotelName("ronghua");
		
		
		HotelRoomInfo hotelroom=new HotelRoomInfo();
		hotelroom.setHotelID("100");
		hotelroom.setHotelName("ronghua");
		
		
		hotelinfo.setHotelRoomPO(hotelroom);
		
		hotelinfo.setIntroduction("good");
		hotelinfo.setStar(Star.five);
		
		List<HotelPO> hotellist=new ArrayList<HotelPO>();
		 hotellist.add(hotelinfo);
		
		return  hotellist;
	}*/


	public ResultMessage_Hotel addHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage_Hotel.success;
	}


	public ResultMessage_Hotel modifyHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public HotelPO getHotel(String hotel_id) throws RemoteException {
		// TODO Auto-generated method stub
		if(hotel_id =="001"){
			HotelAddress add = new HotelAddress("南京", "秦淮区","新街口","aa");
			HotelInputVO hotelInputVO = new HotelInputVO(null,"001","jinling",Star.five,add,null);
			HotelPO hotelPO  = new HotelPO(hotelInputVO);
			HotelFacility facility = new HotelFacility();
			hotelPO.setFacility  (facility);
//			HotelDetailsVO details = new HotelDetailsVO(hotelPO);
//			HotelRoomInfo(String hotelID, St???ring hotelName, List<TypeRoomInfo> typeRoomInfo
			hotelPO.setHotelRoom(new HotelRoomInfo("001","jinling",null));
			return hotelPO;
		}
		return null;
	}


	@Override
	public List<HotelPO> searchHotelList(StandardSearch standardSearch) throws RemoteException {
		// TODO Auto-generated method stub
//		URI hotePictureURI, String hotelID, String hotelName, Star star, HotelAddress hotelAddress,
//		HotelDiscribtionsVO hotelInfoVO
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
//		hotelList = null;
		HotelAddress add = new HotelAddress("南京", "秦淮区","新街口","aa");
		HotelInputVO hotelInputVO = new HotelInputVO(null,"001","jinling",Star.five,add,null);
		HotelPO hotel1  = new HotelPO(hotelInputVO);
		HotelFacility facility = new HotelFacility();
		hotel1.setFacility(facility);
		 List<TypeRoomInfo> typeRoomInfo = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("001", RoomType.Double,10,100.0));
		hotel1.setHotelRoom(new HotelRoomInfo("001","jinling",typeRoomInfo));
		
		HotelAddress add2 = new HotelAddress("南京", "秦淮区","新街口","aa");
		HotelInputVO hotelInputVO2 = new HotelInputVO(null,"002","jinjiang",Star.five,add,null);
		HotelPO hotel2  = new HotelPO(hotelInputVO2);
		
		HotelFacility facility2 = new HotelFacility();
		hotel2.setFacility(facility2);
		 List<TypeRoomInfo> typeRoomInfo2 = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("002", RoomType.Double,10,100.0));
		hotel2.setHotelRoom(new HotelRoomInfo("002","jinling",typeRoomInfo));
		
		
		
		
		
		HotelAddress add3 = new HotelAddress("南京", "秦淮区","夫子庙","aa");
		HotelInputVO hotelInputVO3= new HotelInputVO(null,"003","rujia",Star.five,add,null);
		HotelPO hotel3  = new HotelPO(hotelInputVO3);
		HotelFacility facility3= new HotelFacility();
		hotel3.setFacility(facility3);
		 List<TypeRoomInfo> typeRoomInfo3 = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("003", RoomType.Double,10,100.0));
		hotel3.setHotelRoom(new HotelRoomInfo("003","jinling",typeRoomInfo));
		
		
		
		HotelAddress add4 = new HotelAddress("上海", "xx","xx","aa");
		HotelInputVO hotelInputVO4= new HotelInputVO(null,"004","rujia",Star.five,add,null);
		HotelPO hotel4  = new HotelPO(hotelInputVO4);
		HotelFacility facility4 = new HotelFacility();
		hotel4.setFacility(facility4);
		 List<TypeRoomInfo> typeRoomInfo4 = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("004", RoomType.Double,10,100.0));
		hotel4.setHotelRoom(new HotelRoomInfo("004","jinling",typeRoomInfo));
		
		
		
		
//		System.out.println(standardSearch.getHotelName());
		if (standardSearch.getHotelAddress().getCity()=="南京"&&standardSearch.getHotelAddress().getBusinessCircle()==null&&standardSearch.getHotelName()==null){
			hotelList.add(hotel1);
			hotelList.add(hotel2);
			hotelList.add(hotel3);
		
//			System.out.println("1");
			return hotelList;
		}else if(standardSearch.getHotelAddress().getBusinessCircle()=="夫子庙"){
//			System.out.println("2");
			hotelList.add(hotel3);
//			System.out.println("2");
			return hotelList;
		}else if(standardSearch.getHotelName()=="rujia"){
			hotelList.add(hotel3);
//			System.out.println("3");
//			System.out.println("huode hotel3");
			System.out.println("id是："+hotelList.get(0).getHotelID());
			return hotelList;
		}else if(standardSearch.getHotelAddress().getCity()=="上海"){
			hotelList.add(hotel4);
//			System.out.println("4");
			return hotelList;
		}else{
			hotelList = null;
			return hotelList;
		}
		
//		return hotelList
	}


	@Override
	public ImageInfoPO getImage(String filename) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage_Hotel upload(String filename, byte[] file) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public byte[] download(String filename) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage_Hotel makeDir(String dir) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage_Hotel modifyHotelInfoString(String hotelID, List<String> discribes) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> getHotelInfoString(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		List<String> dis = new ArrayList<String>();
		dis.add("环境好");
		dis.add("设施好");
		return dis;
		
	}


	@Override
	public List<String> getAllDistrictByCity(String city) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> getBusineeCircleByDistrict(String district) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelPO> searchHotelListFuzzy(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OrderAssessPO> gethotelAssessVO(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage_Hotel saveFacility(String hotelID, HotelFacility hotelFacility) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isbooked(String customerID, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
