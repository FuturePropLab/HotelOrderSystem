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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		 String pwd = "./ImageData/HotelFrontPage/"+hotelId+".png";
		 return  upload(pwd, uri);
	 }
	 
	 
	 /**
	  * 
	  * @param hotelId
	  * @return
	  */
	 public URI downloadFrontPicture(String hotelId){
		 String pwd = "./ImageData/HotelFrontPage/"+hotelId+".png";
		 String cache = "./Cache/"+hotelId+".png";
		 return download(pwd, cache);
	 }
	 
	 /**
	  * 
	  * @param hotelID
	  * @return
	  */
	 public ResultMessage_Hotel uploadHotelInfoPic(String hotelID, List<URI> list){
		 String baseurl = "./ImageData/"+hotelID+"/";
		 try {
			hotelDataService.makeDir(baseurl);
		} catch (RemoteException e) {
			return ResultMessage_Hotel.fail;
		}
		ResultMessage_Hotel rs = ResultMessage_Hotel.success;
		Iterator<URI> it = list.iterator();
		String namebase = "/P00";
		int i = 1;
		while(it.hasNext()){			
			ResultMessage_Hotel result = upload(baseurl+namebase+i+".png", it.next());
			i++;
			if(result.equals(ResultMessage_Hotel.fail)){
				rs = ResultMessage_Hotel.fail;
			}
		}	 
		return rs;		  
	 }
	 
	 public List<URI> downloadHotelInfoPic(String hotelID){
		String cachebase = "./Cache/";
		String baseurl = "./ImageData/"+hotelID+"/";
		String namebase = "/P00";
		int i = 1;
		List<URI> list = new ArrayList<URI>();
		while(true){			
			URI uri = download(baseurl+namebase+i+".png", cachebase+namebase+i+hotelID+".png");
			i++;
			if(uri==null){
				break;
			}else{
				list.add(uri);
			}
		}	 
		return list;		  
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
