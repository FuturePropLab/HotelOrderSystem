package dataservice;

import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelPO;
import po.ImageInfoPO;
import po.OrderAssessPO;
import tools.HotelFacility;
import tools.ResultMessage_Hotel;
import tools.SearchHotel;
import tools.StandardSearch;

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
	public List<HotelPO> searchHotelList(StandardSearch standardSearch) throws RemoteException;
	
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
	 * @throws FileNotFoundException 
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
	
	/**
	 * 
	 * @param city
	 * @return
	 * @throws RemoteException 
	 */
	public List<String> getAllDistrictByCity(String city) throws RemoteException;
	
	/**
	 * 
	 * @param district
	 * @return
	 */
	public List<String> getBusineeCircleByDistrict(String district)throws RemoteException;
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws RemoteException
	 */
	public List<HotelPO> searchHotelListFuzzy(String input) throws RemoteException;
	
	
	/**
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public List<OrderAssessPO> gethotelAssessVO(String hotelID) throws RemoteException;
	
	/**
	 * 
	 * @param hotelID
	 * @param hotelFacility
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Hotel saveFacility(String hotelID , HotelFacility hotelFacility) throws RemoteException;
	
	/**
	 * 
	 * @param customerID
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public  boolean isbooked(String customerID , String hotelID)throws RemoteException;
	
	/**
	 * 
	 * @param hotelID
	 * @param hotelName
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Hotel modifyHotelName(String hotelID , String hotelName)throws RemoteException;
	
}
