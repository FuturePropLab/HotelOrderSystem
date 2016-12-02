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
import java.util.Iterator;
import java.util.List;

import businesslogic.hotel.PictureDeal;
import rmi.RemoteHelper;
import tools.ResultMessage_Hotel;

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
		  //HotelDataService hotelInputVO = RemoteHelper.getInstance().getHotelDataService();
		  PictureDeal pictureDeal = new PictureDeal();
//		  File file1 = new File("./src/main/resources/images/room.png");
//		  File file2 = new File("./src/main/resources/images/asiahotel.jpg");
//		  File file3 = new File("./src/main/resources/images/images.jpg");
//		  System.out.println(file1.exists());
//		  System.out.println(file2.exists());
//		  System.out.println(file3.exists());
//		  List<URI> list = new ArrayList<URI>();
//		  list.add(file1.toURI());
//		  list.add(file2.toURI());
//		  list.add(file3.toURI());
		  List<URI> list = pictureDeal.downloadHotelInfoPic("HT002");
		  System.out.println(list.size());
		  Iterator<URI> it = list.iterator();
		  while(it.hasNext()){			
			System.out.println(it.next().toString());
		 }	 
		  
		  
		  
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
