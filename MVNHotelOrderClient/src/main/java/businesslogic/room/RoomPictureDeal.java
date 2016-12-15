package businesslogic.room;

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
import tools.RoomType;

public class RoomPictureDeal {
	
	private HotelDataService hotelDataService;
	
	public RoomPictureDeal(){
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
	 public ResultMessage_Hotel uploadRoomPicture(String hotelId , RoomType room,URI uri){
		 String pwd = "./ImageData/"+room.tosave()+"/"+hotelId+".png";	
		 return  upload(pwd, uri);
	 }
	 
	 
	 /**
	  * 
	  * @param hotelId
	  * @return
	  */
	 public URI downloadRoomPicture(String hotelId,RoomType room){
		 String pwd = "./ImageData/"+room.tosave()+"/"+hotelId+".png";
		 String cache = "./Cache/"+room.toString()+hotelId+".png";
		 return download(pwd, cache);
	 }
	 
	
	 
	 private ResultMessage_Hotel upload(String pwd , URI uri){
		  byte[] b;
		  try {
				b = fileToByte(uri);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				return ResultMessage_Hotel.fail;
			}
			 ResultMessage_Hotel rs;
			try {
				rs = hotelDataService.upload(pwd, b);
			} catch (RemoteException e) {
				System.out.println(e.getMessage());
				return ResultMessage_Hotel.fail;
			}
			 return rs;		 
	   }
	   
	 private URI download(String pwd , String cache){
		   byte[] b;
			try {
				b = hotelDataService.download(pwd);
				if(b==null) return null;
			} catch (RemoteException e1) {
				return null;
			}		 
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
