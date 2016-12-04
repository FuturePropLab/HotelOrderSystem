package businesslogicservice;

import java.util.Date;
import java.util.List;

import tools.ResultMessage_Room;
import tools.RoomType;
import vo.RoomDescriptionVO;

public interface RoomManageService {
	/**
	 *获得改种房间类型的信息
	 * @param hotel_id
	 * @param roomType
	 * @return
	 */
	public RoomDescriptionVO  getRoomInfo(String hotel_id, RoomType roomType); 
	
	/**
	 * 存储房间类型信息
	 * @param hotelID
	 * @param roomDescriptionVO
	 * @return
	 */
	public ResultMessage_Room saveRoomInfo(String hotelID ,RoomDescriptionVO roomDescriptionVO);
	
	/**
	 * 获得该酒店该类型所有房间号
	 * @param hotelID
	 * @param roomType
	 * @return
	 */
	public List<String> getAllRoomByType(String hotelID , RoomType roomType);
	
	/**
	 * 获得该酒店该类型在规定时间内可用的房间号
	 * @param hotelID
	 * @param roomType
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<String>  getAvaiableRoomBytime (String hotelID , RoomType roomType , Date begin,Date end );
	
	/**
	 * 获得该酒店该类型所有的房间个数
	 * @param hotelID
	 * @param roomType
	 * @return
	 */
	public int getAllNumberByType(String hotelID , RoomType roomType);
	
	/**
	 * 获得该酒店该类型在规定时间内可用的房间个数
	 * @param hotelID
	 * @param roomType
	 * @param begin
	 * @param end
	 * @return
	 */
	public int getAvaiableNumberByTime(String hotelID , RoomType roomType , Date begin,Date end);
}
