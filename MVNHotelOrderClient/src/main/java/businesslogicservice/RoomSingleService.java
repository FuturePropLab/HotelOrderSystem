package businesslogicservice;

import java.util.Date;

import tools.ResultMessage_Room;
import tools.RoomType;

/**
 * 
 * @author wshwbluebird
 *
 */
public interface RoomSingleService {
	
	/**
	 * 增加房间
	 * @param hotelID
	 * @param RoomNO
	 * @param roomType
	 * @return
	 */
	public ResultMessage_Room addSingleRoom(String hotelID, String RoomNO, RoomType roomType);
	
	/**
	 * 删除房间
	 * @param hotelID
	 * @param roomNO
	 * @return
	 */
	public ResultMessage_Room deleteSingleRoom (String hotelID,String roomNO);
	
	/**
	 * 将房间一段时间设为不可用
	 * @param hotelID
	 * @param roomNO
	 * @param begin
	 * @param end
	 * @return
	 */
	public ResultMessage_Room addDisable (String hotelID,String roomNO , Date begin , Date end);
	
	/**
	 * 删除 不可用的记录
	 * @param hotelID
	 * @param roomNO
	 * @param begin
	 * @return
	 */
	public ResultMessage_Room deleteDisable (String hotelID,String roomNO , Date begin);
	
}
