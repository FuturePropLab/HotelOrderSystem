package businesslogic.hotel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.rmi.RemoteException;

import dataservice.HotelDataService;
import rmi.RemoteHelper;
import tools.ResultMessage_Hotel;

public class PictureDeal {
	
	private HotelDataService hotelDataService;
	public PictureDeal(){
		this.hotelDataService = RemoteHelper.getInstance().getHotelDataService();
	}
	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException 
	 */
	 private byte[] fileToByte(URI uri) throws IOException{ 
         byte[] b = null; 
         File file = new File(uri); 
         b = new byte[(int) file.length()]; 
         BufferedInputStream is = new BufferedInputStream(new FileInputStream(file)); 
         is.read(b); 
         is.close();
     
         return b; 
     } 
	 
	 /**
	  * 
	  * @param hotelId
	  * @param uri
	  * @return
	  */
	 public ResultMessage_Hotel uploadFrontPicture(String hotelId , URI uri){
		byte[] b;
		try {
			b = fileToByte(uri);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}
		 String pwd = "./ImageData/HotelFrontPage/"+hotelId+".png";
		 ResultMessage_Hotel rs;
		try {
			rs = hotelDataService.upload(pwd, b);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Hotel.fail;
		}
		 return rs;		 
	 }
	 
	 public URI downloadFrontPicture(String hotelId){
			 String pwd = "./ImageData/HotelFrontPage/"+hotelId+".png";
			 byte[] b;
			try {
				b = hotelDataService.download(pwd);
				if(b==null) return null;
			} catch (RemoteException e1) {
				return null;
			}
			 String cache = "./Cache/"+hotelId+".png";		 
			 File file = new File(cache); 
	          try { 
	              if (!file.exists()) 
	                  file.createNewFile(); 
	              BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file)); 
	              os.write(b); 
	              os.flush();
	              os.close();
	          } catch (FileNotFoundException e) { 
	              return null; 
	          } catch (IOException e) { 
	              // TODO Auto-generated catch block 
	        	  return null; 
	          } 			
			 return file.toURI();		 
		 }
}
