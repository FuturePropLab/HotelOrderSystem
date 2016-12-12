package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import tools.ResultMessage_Room;
import tools.RoomType;

public interface RoomDataService extends Remote{
	/**
	    * 增加房间
	    * @param hotelID
	    * @param RoomNO
	    * @param roomtype
	    * @return
	 * @throws RemoteException 
	    */
	 	public ResultMessage_Room addRoom(String hotelID,String RoomNO , RoomType roomtype) throws RemoteException;
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param RoomNO
	 	 * @return
	 	 * @throws RemoteException 
	 	 */
	 	public ResultMessage_Room deleteRoom(String hotelID,String RoomNO) throws RemoteException;
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param RoomNO
	 	 * @param begin
	 	 * @param end
	 	 * @return
	 	 * @throws RemoteException 
	 	 */
	 	public ResultMessage_Room addRecord(String hotelID,String RoomNO,Date begin,Date end) throws RemoteException;
	 	
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param RoomNO
	 	 * @param begin
	 	 * @return
	 	 * @throws RemoteException 
	 	 */
	 	public ResultMessage_Room deleteRecord(String hotelID,String RoomNO,Date begin) throws RemoteException;
	 	
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param roomType
	 	 * @throws RemoteException 
	 	 */
	 	public List<String>  getAvailbleRoomNoByType(String hotelID , RoomType roomType,Date begin,Date end) throws RemoteException;
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param roomType
	 	 * @return
	 	 * @throws RemoteException 
	 	 */
	 	public int getTotalNumberRoomByType(String hotelID , RoomType roomType) throws RemoteException;
	 	
	 	
	 	public int getAvaiableNumberRoomByType(String hotelID , RoomType roomType,Date begin,Date end) throws RemoteException;
	 	
	 	
	 	/**
		 * 
		 * @param strs
		 * @return
		 * @throws RemoteException
		 */
		public ResultMessage_Room modifyRoomInfoString(String hotelID ,RoomType roomType, List<String> discribes)throws RemoteException;
		
		/**
		 * 
		 * @param hotelID
		 * @return
		 * @throws RemoteException
		 */
		public List<String>   getRoomInfoString(String hotelID, RoomType roomType) throws RemoteException;
			
		
		/**
		 * 
		 * @param hotelID
		 * @param roomType
		 * @param price
		 * @return
		 * @throws RemoteException
		 */
		public ResultMessage_Room changePrice(String hotelID ,RoomType roomType , double price) throws RemoteException;
}
