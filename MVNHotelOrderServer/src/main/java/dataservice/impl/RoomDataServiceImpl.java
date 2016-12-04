package dataservice.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataservice.RoomDataService;
import dataservice.datahelper.RoomDateHelper;
import dataservice.datahelper.impl.RoomDateHelperImpl;
import tools.ResultMessage_Room;
import tools.RoomType;

public class RoomDataServiceImpl implements RoomDataService {
	
	private RoomDateHelper roomDateHelper;
	
	public RoomDataServiceImpl(){
		this.roomDateHelper = RoomDateHelperImpl.getInstantce();
	}
	
	public ResultMessage_Room addRoom(String hotelID, String RoomNO, RoomType roomtype)throws RemoteException {
		return roomDateHelper.addRoom( hotelID,  RoomNO,  roomtype);
	}

	public ResultMessage_Room deleteRoom(String hotelID, String RoomNO)throws RemoteException {
		return roomDateHelper.deleteRoom(hotelID, RoomNO);
	}

	public ResultMessage_Room addRecord(String hotelID, String RoomNO, Date begin, Date end) throws RemoteException{
		return roomDateHelper.addRecord(hotelID, RoomNO, begin, end);
	}

	public ResultMessage_Room deleteRecord(String hotelID, String RoomNO, Date begin)throws RemoteException {
		return roomDateHelper.deleteRecord(hotelID, RoomNO, begin);
	}

	public List<String> getAvailbleRoomNoByType(String hotelID, RoomType roomType, Date begin, Date end)throws RemoteException {
		List<String> allList = roomDateHelper.getRoomNobyType(hotelID, roomType);
		if(begin==null || end == null)   return allList;
		if(begin.after(end)) return new ArrayList<String>();
		List<String> returnlist = new ArrayList<String>();
		Iterator<String> it = allList.iterator();
		while(it.hasNext()){
			String roomNO= it.next();
			if(roomDateHelper.isAvailableRoom(hotelID, roomNO, begin, end))
				returnlist.add(roomNO);
		}
		return returnlist;
	}

	public int getTotalNumberRoomByType(String hotelID, RoomType roomType) throws RemoteException{
		return roomDateHelper.getRoomNobyType(hotelID, roomType).size();
	}

	public int getAvaiableNumberRoomByType(String hotelID, RoomType roomType, Date begin, Date end)
			throws RemoteException {
		return getAvailbleRoomNoByType(hotelID, roomType, begin, end).size();
	}

	public ResultMessage_Room modifyRoomInfoString(String hotelID, RoomType roomType, List<String> discribes)
			throws RemoteException {
		if(discribes==null)  return ResultMessage_Room.success;
		String baseurl = "./ImageData/"+roomType.toString()+"/DES"+hotelID+".txt";
		File file = new File(baseurl);
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				return ResultMessage_Room.fail;
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
            return ResultMessage_Room.success;
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        	return ResultMessage_Room.success;
        }

	}

	public List<String> getRoomInfoString(String hotelID, RoomType roomType) throws RemoteException {
		String baseurl = "./ImageData/"+roomType.toString()+"/DES"+hotelID+".txt";
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
