package dataservice.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DataFactory.DataHelperUtils;
import dataservice.HotelDataService;
import dataservice.datahelper.HotelDataHelper;
import po.HotelAddressPO;
import po.HotelBasePO;
import po.HotelFacilityPO;
import po.HotelPO;
import po.ImageInfoPO;
import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.ResultMessage_Hotel;
import tools.SearchHotel;

public class HotelDataServiceImpl implements HotelDataService {
	
	private HotelDataHelper hotelDataHelper;
	
	public HotelDataServiceImpl(){
		this.hotelDataHelper = DataHelperUtils.getHotelDataHelper();
	}
	
	public ResultMessage_Hotel addHotel(HotelPO hotelPO) throws RemoteException {
		String hotelID = hotelPO.getHotelID();
		if(hotelID==null || "".equals(hotelID))
			return ResultMessage_Hotel.fail;
		
		//base
		HotelBasePO hotelBasePO = new HotelBasePO(hotelPO);		
		if(hotelBasePO.getHotelName()==null && "".equals(hotelBasePO.getHotelName())){
			hotelBasePO.setHotelName(null);
		}
		hotelDataHelper.addHotelBasePO(hotelBasePO);
		
		//facility
		HotelFacility hotelFacility;
		String elString = null;
		if(hotelPO.getFacility()!=null){
			hotelFacility  = hotelPO.getFacility();	
		
		}else{
			hotelFacility = new HotelFacility(elString);
		}
		HotelFacilityPO hotelFacilityPO = new HotelFacilityPO(hotelID , hotelFacility);
		hotelDataHelper.addHotelFacilityPO(hotelFacilityPO);
		
		//roominfo same to modify
		if(hotelPO.getHotelRoom()!=null){
			HotelRoomInfo RoomInfo = hotelPO.getHotelRoom();
			hotelDataHelper.modifyHotelRoomInfo(RoomInfo);		
		}
		//address
		HotelAddress hotelAddress;
		if(hotelPO.getHotelAddress()!=null){
			hotelAddress = hotelPO.getHotelAddress();
		}else{
			hotelAddress = new HotelAddress(null, null, null, null);
		}
		HotelAddressPO hotelAddressPO = new HotelAddressPO(hotelID, hotelAddress);		
		hotelDataHelper.addHotelAddressPO(hotelAddressPO);				
		return ResultMessage_Hotel.success;
		
	}

	public ResultMessage_Hotel modifyHotel(HotelPO hotelPO) throws RemoteException  {
		String hotelID = hotelPO.getHotelID();
		//System.out.println("2344: "+hotelPO.getHotelID());
		if(hotelID==null || "".equals(hotelID))
			return ResultMessage_Hotel.fail;
		HotelBasePO hotelBasePO = new HotelBasePO(hotelPO);
		
		
		//whether update base
		hotelDataHelper.modifyHotelBasePO(hotelBasePO);
		
		
		
		//whether update facility
		if(hotelPO.getFacility()!=null){
			HotelFacility hotelFacility = hotelPO.getFacility();
			HotelFacilityPO hotelFacilityPO  = new HotelFacilityPO(hotelID , hotelFacility);
			hotelDataHelper.modifyHotelFacilityPO(hotelFacilityPO);
		}
		
		if(hotelPO.getHotelRoom()!=null&&hotelPO.getHotelRoom().getTypeRoomInfo()!=null){
			System.out.println("here");
			HotelRoomInfo RoomInfo = hotelPO.getHotelRoom();
			hotelDataHelper.modifyHotelRoomInfo(RoomInfo);		
		}
		
		if(hotelPO.getHotelAddress()!=null){
			HotelAddress hotelAddress = hotelPO.getHotelAddress();
			HotelAddressPO hotelAddressPO = new HotelAddressPO(hotelID, hotelAddress);		
			hotelDataHelper.modifyHotelAddressPO(hotelAddressPO);			
		}		
		return ResultMessage_Hotel.success;
	}

	public HotelPO getHotel(String hotel_id) throws RemoteException  {
		HotelBasePO hotelBasePO = hotelDataHelper.getHotelBasePO(hotel_id);
		if(hotelBasePO == null )  return null;
		HotelAddressPO hotelAddressPO = hotelDataHelper.getHotelAddressPO(hotel_id);
		HotelFacilityPO hotelFacilityPO = hotelDataHelper.getHotelFacilityPO(hotel_id);
		HotelRoomInfo hotelRoomInfo = hotelDataHelper.getHotelRoomInfo(hotel_id);
		
		HotelPO hotelPO = new HotelPO(hotelBasePO, hotelAddressPO, 
				null, hotelRoomInfo, hotelFacilityPO);		
		return hotelPO;
	}

	public List<HotelPO> searchHotelList(SearchHotel searchhotel) throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

	public ImageInfoPO getImage(String filename) throws RemoteException {
		ImageInfoPO imageInfoPO = new ImageInfoPO();
	    imageInfoPO.setPictureName(filename);
	    File file = new File("./ImageData/image/test.png");
	    imageInfoPO.setPicture(file);
		return imageInfoPO;
	}

	public ResultMessage_Hotel upload(String filename, byte[] fileContent) throws RemoteException {
		  File file = new File(filename); 
          try { 
              if (!file.exists()) 
                  file.createNewFile(); 
              BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file)); 
              os.write(fileContent); 
              os.flush();
              os.close();
          } catch (FileNotFoundException e) { 
              // TODO Auto-generated catch block 
              e.printStackTrace(); 
          } catch (IOException e) { 
              // TODO Auto-generated catch block 
              e.printStackTrace(); 
          } 	
          return ResultMessage_Hotel.success;
	}

	public byte[] download(String filename) throws RemoteException {
		  byte[] b = null; 
          try { 
              File file = new File(filename); 
              b = new byte[(int) file.length()]; 
              BufferedInputStream is = new BufferedInputStream(new FileInputStream(file)); 
              is.read(b);
              is.close();
          } catch (FileNotFoundException e) { 
               return null;
          } catch (IOException e) { 
              return null;
          } 
          return b; 
      }

	public ResultMessage_Hotel makeDir(String dir) throws RemoteException {
		System.out.println(dir);
		File file = new File(dir);
		//System.out.println(dir);
		System.out.println(file.isDirectory());
		if(file.isDirectory()) {
			 File[] files = file.listFiles();//声明目录下所有的文件 files[];
		       for (int i = 0;i < files.length;i ++) {//遍历目录下所有的文件
		             files[i].delete();//把每个文件用这个方法进行迭代
		       }
		}
		file.mkdirs();
		return ResultMessage_Hotel.success;
	}

	public ResultMessage_Hotel modifyHotelInfoString(String hotelID, List<String> discribes) throws RemoteException {
		if(discribes==null)  return ResultMessage_Hotel.success;
		String baseurl = "./ImageData/info/"+hotelID+".txt";
		File file = new File(baseurl);
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				return ResultMessage_Hotel.fail;
			}
		FileWriter writer;
        try {
            writer = new FileWriter(file);
            Iterator<String> it = discribes.iterator();
            while(it.hasNext()){
            	writer.write(it.next());
            	writer.write('\n');
            }          
            writer.flush();
            writer.close();
            return ResultMessage_Hotel.success;
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	return ResultMessage_Hotel.success;
        }

	}

	public List<String> getHotelInfoString(String hotelID) throws RemoteException {
		String baseurl = "./ImageData/info/"+hotelID+".txt";
		File file = new File(baseurl);
		if(!file.exists())  return null;
		List<String> list = new ArrayList<String>();
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str ;
			while((str=br.readLine())!=null){
				list.add(str.trim());
			}
			
			br.close();
			reader.close();
			return list;
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}

	} 
	
} 


