package runner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.HotelDataService;
import javafx.scene.image.Image;
import rmi.RemoteHelper;

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
		  HotelDataService hotelInputVO = RemoteHelper.getInstance().getHotelDataService();
		  Image image = new Image("file:./src/main/resources/images/room.png");
		  File file = new File(image.impl_getUrl());
		  //File file = (File) object;
		  System.out.println(file.exists());
		  byte[] b = null; 
          try {  
              b = new byte[(int) file.length()]; 
              BufferedInputStream is = new BufferedInputStream(new FileInputStream(file)); 
              is.read(b); 
              is.close();
          } catch (FileNotFoundException e) { 
          // TODO Auto-generated catch block 
              e.printStackTrace(); 
          } catch (IOException e) { 
              // TODO Auto-generated catch block 
              e.printStackTrace(); 
          }
          
          hotelInputVO.upload("room.png", b);
//		 
		  
	}
	
	public static void main(String[] args) throws RemoteException{
		ClientRunner cr = new ClientRunner();
		cr.test();
	}
}
