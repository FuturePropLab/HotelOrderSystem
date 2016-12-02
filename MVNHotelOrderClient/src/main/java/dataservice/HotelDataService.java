package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelPO;
import po.ImageInfoPO;
import tools.ResultMessage_Hotel;
import tools.SearchHotel;

public interface HotelDataService extends Remote{
	/**
	 * 
	 * @param hotelPO
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage_Hotel addHotel(HotelPO hotelPO) throws RemoteException;
	
	/**
	 * 
	 * @param hotelPO
	 * @return
	 * @throws RemoteException 
	 */
	public  ResultMessage_Hotel modifyHotel(HotelPO hotelPO) throws RemoteException;
	
	 /**
	  * 
	  * @param hotel_id
	  * @return HotelPO
	 * @throws RemoteException 
	  */
	public HotelPO getHotel (String hotel_id) throws RemoteException;
	
	/**
	 * 
	 * @param searchhotel
	 * @return
	 * @throws RemoteException 
	 */
	public List<HotelPO> searchHotelList(SearchHotel searchhotel) throws RemoteException;
	
	/**
	 * 
	 * @param filename
	 * @return
	 * @throws RemoteException
	 */
	public  ImageInfoPO getImage(String filename) throws RemoteException; 
	
	
	/**
	 * 
	 * @param filename
	 * @param file
	 * @throws RemoteException
	 */
	public ResultMessage_Hotel upload(String filename, byte[] file) throws RemoteException; 
	
	/**
	 * 
	 * @param filename
	 * @param file
	 * @return
	 * @throws RemoteException
	 */
	public byte[] download(String filename) throws RemoteException;
	
	/**
	 * 
	 * @param dir
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Hotel makeDir(String dir)throws RemoteException;
	
	/**
	 * 
	 * @param strs
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Hotel modifyHotelInfoString(String hotelID , List<String> discribes)throws RemoteException;
	
	/**
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public List<String>   getHotelInfoString(String hotelID) throws RemoteException;
}


