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

import businesslogic.discount.DiscountHotelController;
import businesslogicservice.DiscountHotelService;
import rmi.RemoteHelper;
import vo.DiscountVO_hotel;

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
//		 DiscountWebDataService discountWebDataService =
//				 RemoteHelper.getInstance().getDiscountWebDAteService();
//		 List<DiscountPO_web> list = discountWebDataService.getWebDiscount();
//		 for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getDiscountState());
//			System.out.println(list.get(i).getDiscount());
//		}
//		
//		DiscountHotelDataService discountHotelDataService = RemoteHelper.getInstance().getDiscountHotelDataService();
//		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel
//				(DiscountState.valid, Strategy_hotelType.CooperateEnterprise, null, 9.5,  LocalDate.now(),
//						LocalDate.of(2016, 12, 31), "王帅惟设计的", false, "朱俊毅粉丝后援团");
//		System.out.println(discountHotelDataService.getHotelDiscount("HT000").isEmpty());
		
		DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
		
//		DiscountVO_hotel discountVO_hotel = 
//				new DiscountVO_hotel(
//						6, LocalDate.of(2016, 12, 4), LocalDate.of(2016, 12, 6), "很豪华", false);
//		discountHotelService.addHotelDiscount("330", discountVO_hotel);
		DiscountVO_hotel discountVO_hotel = discountHotelService.getHotelDiscount("330").get(0);
		System.out.println(discountVO_hotel.remarks);
		
		
		
		

//		DiscountHotelDataService discountHotelDataService = RemoteHelper.getInstance().getDiscountHotelDataService();
//		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel
//				(DiscountState.valid, Strategy_hotelType.CooperateEnterprise, null, 8.5,  LocalDate.now(),
//						LocalDate.of(2016, 12, 31), "王帅惟设计的2", true, "朱俊毅粉丝后援团2");
//		System.out.println(discountHotelDataService.getHotelDiscount("HT000").isEmpty());
//		LoginCheckService loginCheckService = RemoteHelper.getInstance().getLoginCheckService();
//		System.out.println(loginCheckService.checkLogin("zhujunyi", "zhujunyi", AccountType.Customer));

		 
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
