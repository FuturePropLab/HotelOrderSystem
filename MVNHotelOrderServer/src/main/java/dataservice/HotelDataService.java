package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelPO;
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
	
	
}
