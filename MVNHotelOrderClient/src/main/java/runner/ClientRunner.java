package runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.hotel.ManageHotelController;
import dataservice.HotelDataService;
import rmi.RemoteHelper;
import tools.HotelFacility;
import vo.HotelDiscribtionsVO;
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
		  ManageHotelController manageHotelController =  ManageHotelController.getInstance();
		  File file1 = new File("/Users/wshwbluebird/Desktop/pc001.png");
		  File file2 = new File("/Users/wshwbluebird//Desktop/pc002.png");
		  File file3 = new File("/Users/wshwbluebird//Desktop/pc003.png");
		  System.out.println(file1.exists());
		  System.out.println(file2.exists());
		  System.out.println(file3.exists());
		  List<URI> list = new ArrayList<URI>();
		  list.add(file1.toURI());
		  list.add(file2.toURI());
		  list.add(file3.toURI());
//		  
		  List<String> deList = new ArrayList<String>();;
		  deList.add("朱俊毅最帅!!!!!");
		  deList.add("wsw");
		  HotelDiscribtionsVO hotelDiscribtionsVO = new HotelDiscribtionsVO();
		  hotelDiscribtionsVO.discribes =deList;
		  hotelDiscribtionsVO.pictureURI= list;
		  
		  HotelInputVO hotelInputVO = new HotelInputVO("HT001", new HotelFacility(), hotelDiscribtionsVO, null);
		  hotelInputVO.hotePictureURI = file1.toURI();
		 System.out.println(manageHotelController.saveHotelInfo(hotelInputVO));
		  
		  
          

		  
		  
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
