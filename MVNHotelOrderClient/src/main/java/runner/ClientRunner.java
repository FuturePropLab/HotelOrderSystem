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
import java.util.Calendar;
import java.util.Date;

import businesslogic.discount.DiscountHotelController;
import businesslogicservice.DiscountHotelService;
import dataservice.OrderDataService;
import po.OrderPO;
import rmi.RemoteHelper;
import tools.OrderState;
import tools.RoomType;
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
		
//		DiscountHotelService discountHotelService = DiscountHotelController.getInstance();
		
//		DiscountVO_hotel discountVO_hotel = 
//				new DiscountVO_hotel(
//						6, LocalDate.of(2016, 12, 4), LocalDate.of(2016, 12, 6), "很豪华", false);
//		discountHotelService.addHotelDiscount("330", discountVO_hotel);
//		DiscountVO_hotel discountVO_hotel = discountHotelService.getHotelDiscount("330").get(0);
//		System.out.println(discountVO_hotel.remarks);
		
		
		
		

//		DiscountHotelDataService discountHotelDataService = RemoteHelper.getInstance().getDiscountHotelDataService();
//		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel
//				(DiscountState.valid, Strategy_hotelType.CooperateEnterprise, null, 8.5,  LocalDate.now(),
//						LocalDate.of(2016, 12, 31), "王帅惟设计的2", true, "朱俊毅粉丝后援团2");
//		System.out.println(discountHotelDataService.getHotelDiscount("HT000").isEmpty());
//		LoginCheckService loginCheckService = RemoteHelper.getInstance().getLoginCheckService();
//		System.out.println(loginCheckService.checkLogin("zhujunyi", "zhujunyi", AccountType.Customer));
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 21); // 控制时
		calendar.set(Calendar.MINUTE, 15);    // 控制分
	    calendar.set(Calendar.SECOND, 0);    // 控制秒
		OrderDataService orderDataService  =RemoteHelper.getInstance().getOrderDataService();
		OrderPO order = new 
				OrderPO("OD09", "CS002", "HT001", null, new Date(), calendar.getTime(), new Date(2016-1900, 11, 15), 
						null, null, null, null, RoomType.Double, 1, 3, 1, true, OrderState.Unexecuted, null, null, 180);
		System.out.println(orderDataService.add(order));

		 
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
