package dataservice.datahelper;

import java.util.Date;
import java.util.List;

import tools.ResultMessage_Room;
import tools.RoomType;

public interface RoomDateHelper {
	   /**
	    * 增加房间
	    * @param hotelID
	    * @param RoomNO
	    * @param roomtype
	    * @return
	    */
	 	public ResultMessage_Room addRoom(String hotelID,String RoomNO , RoomType roomtype);
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param RoomNO
	 	 * @return
	 	 */
	 	public ResultMessage_Room deleteRoom(String hotelID,String RoomNO);
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param RoomNO
	 	 * @param begin
	 	 * @param end
	 	 * @return
	 	 */
	 	public ResultMessage_Room addRecord(String hotelID,String RoomNO,Date begin,Date end);
	 	
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param RoomNO
	 	 * @param begin
	 	 * @return
	 	 */
	 	public ResultMessage_Room deleteRecord(String hotelID,String RoomNO,Date begin);
	 	
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param roomType
	 	 */
	 	public List<String>  getRoomNobyType(String hotelID , RoomType roomType);
	 	
	 	
	 	/**
	 	 * 看该房间在时间段是否可用
	 	 * @param hotelID
	 	 * @param roomNO
	 	 * @param begin
	 	 * @param end
	 	 * @return
	 	 */
	 	public boolean  isAvailableRoom(String hotelID , String roomNO , Date begin ,Date end);
	 	
	 	/**
	 	 * 批量修改酒店信息中的名字
	 	 * @param hotelID
	 	 * @param hotelName
	 	 * @return
	 	 */
	 	public ResultMessage_Room modifyTypeToomInfoName(String hotelID , String hotelName);
	 	
	 	/**
	 	 * change this room 's price
	 	 * @param hotelID
	 	 * @param roomType
	 	 * @param price
	 	 * @return
	 	 */	 	
	 	public ResultMessage_Room modifyTypeRoomPrice (String hotelID , RoomType roomType, double price);
	 	
	 	/**
	 	 * 
	 	 * @param hotelID
	 	 * @param roomNO
	 	 * @return
	 	 */
	 	public ResultMessage_Room deleteRecord(String hotelID, String roomNO);
}
