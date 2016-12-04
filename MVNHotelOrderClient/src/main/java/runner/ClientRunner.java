package runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.room.RoomManageController;
import businesslogic.room.RoomSingleController;
import rmi.RemoteHelper;
import tools.RoomType;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	
	public ClientRunner() {
		linkToServer();
		

	}
	
	private void linkToServer(){
		try {
			File file = new File("TxtData/port.txt");
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			String port = str.trim();
			br.close();
			reader.close();
			System.out.println(port);
			remoteHelper = RemoteHelper.getInstance();
			System.out.println("ready to link");
			remoteHelper.setRemote(Naming.lookup("rmi://"+port+":8888/DataRemoteObject"));
			System.out.println("linked");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void test() throws RemoteException{		
//		  HotelManageController manageHotelController =  HotelManageController.getInstance();
//		  File file1 = new File("/Users/wshwbluebird/Desktop/pc004.png");
//		  File file2 = new File("/Users/wshwbluebird//Desktop/pc002.png");
//		  File file3 = new File("/Users/wshwbluebird//Desktop/pc003.png");
//		  System.out.println(file1.exists());
//		  System.out.println(file2.exists());
//		  System.out.println(file3.exists());
//		  List<URI> list = new ArrayList<URI>();
//		  list.add(file1.toURI());
//		  list.add(file2.toURI());
//		  list.add(file3.toURI());
////		  
//		  List<String> deList = new ArrayList<String>();;
//		  deList.add("朱俊毅最帅!!!!!");
//		  deList.add("wsw");
//		  HotelDiscribtionsVO hotelDiscribtionsVO = new HotelDiscribtionsVO();
//		  hotelDiscribtionsVO.discribes =deList;
//		  hotelDiscribtionsVO.pictureURI= list;
		  
		  
//		 HotelFacilityVO hotelFacilityVO = new HotelFacilityVO();
//		 hotelFacilityVO.hotelID = "HT001";
//		 hotelFacilityVO.other = "王帅惟大笨蛋!!!";
//		 hotelFacilityVO.facilityImage = file1.toURI();
//		 HotelInputVO hotelInputVO = new HotelInputVO("HT001",  hotelFacilityVO ,null,null);
//		// hotelInputVO.hotePictureURI = file1.toURI();
//		 System.out.println(manageHotelController.saveHotelInfo(hotelInputVO));
//		  
//		  HotelFacilityVO hotelFacilityVO = HotelDealController.getInstance().gethotelFacilityVO("HT001");
//		  System.out.println(hotelFacilityVO.other);
//		  System.out.println(hotelFacilityVO.facilityImage.toString());
		  
//		  HotelDealService hotelDealService = HotelDealController.getInstance();
//		  List<String> list = hotelDealService.getAllDistrictByCity("北京");
//		  System.out.println(list==null);
//		  for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
//		
//		HotelDealService hotelDealService  = HotelDealController.getInstance();
//		SearchHotelVO searchHotelVO = new SearchHotelVO
//				("北京", "西城", "大悦城", null, null, null, null, false);
//		HotelDataService hotelDataService  =RemoteHelper.getInstance().getHotelDataService();
//		List<HotelPO> hotelPOs= hotelDataService.searchHotelList(new StandardSearch(searchHotelVO));
//		System.out.println(hotelPOs==null);
//		System.out.println(hotelPOs.get(0).);
		

//	   TypeRoomInfo typeRoomInfo = hotelPO.getHotelRoom().getTypeRoomInfo().get(0);
//	   System.out.println(typeRoomInfo==null);
				  
          
//		RoomDataService roomDataService = RemoteHelper.getInstance().getRoomDataService();
//		System.out.println(roomDataService.getTotalNumberRoomByType("HT001", RoomType.Double));
//
//		System.out.println(roomDataService.getAvaiableNumberRoomByType("HT001", RoomType.Double,
//				new Date(), new Date(2017-1900, 11, 23)));
		  
//		  RoomDataService roomDataService
//		List<String> list = new ArrayList<String>();
//		list.add("good");
//		list.add("very nice");
//		File file3 = new File("/Users/wshwbluebird//Desktop/pc003.png");
//		RoomDescriptionVO roomDescriptionVO = new RoomDescriptionVO(RoomType.Double, list, file3.toURI());
//		RoomDescriptionVO roomDescriptionVO=RoomManageController.getInstance().getRoomInfo("HT001", RoomType.Single);
//		System.out.println(roomDescriptionVO.typeimage==null);
//		System.out.println(roomDescriptionVO.description);
		Date date1 = new Date(2016-1900, 11, 17);
		Date date2 = new Date(2016-1900, 11, 12);
		Date date3 = new Date(2016-1900, 11, 14);
		Date date4 = new Date(2016-1900, 11, 16);
		
		RoomSingleController roomSingleController  =RoomSingleController.getInstance();
		RoomManageController roomManageController = RoomManageController.getInstance();
//		System.out.println(roomSingleController.addDisable("HT001", "307", date2, date1));
//		System.out.println(roomSingleController.addDisable("HT001", "401", date3, date1));
//		System.out.println(roomSingleController.addDisable("HT001", "302", date2, date1));
		System.out.println(roomManageController.getAllRoomByType("HT001", RoomType.Double));
		System.out.println(roomManageController.getAvaiableRoomBytime
				("HT001", RoomType.Double, date2, date1));
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
