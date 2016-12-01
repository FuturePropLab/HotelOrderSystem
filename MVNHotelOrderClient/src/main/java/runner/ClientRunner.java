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
import java.util.ArrayList;
import java.util.List;

import businesslogic.account.HotelAccountController;
import businesslogic.hotel.ManageHotelController;
import businesslogicservice.ManageHotelInfoService;
import dataservice.HotelDataService;
import po.HotelPO;
import rmi.RemoteHelper;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.RoomType;
import tools.TypeRoomInfo;
import vo.HotelInputVO;

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
		  ManageHotelInfoService manageHotelInfoService = ManageHotelController.getInstance();
		  HotelInputVO hotelInputVO =new HotelInputVO("lanniao", "zhujunyi");
		  System.out.println(manageHotelInfoService.addHotel(hotelInputVO));
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
