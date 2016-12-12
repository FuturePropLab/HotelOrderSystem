package businesslogic.room;

import java.util.Date;
import java.util.List;

import businesslogicservice.RoomManageService;
import tools.ResultMessage_Room;
import tools.RoomType;
import vo.RoomDescriptionVO;

public class RoomManageController implements RoomManageService{
	
	private RoomManager roomManager;
	
	private static RoomManageController roomManageController = null;
	
	private RoomManageController(){
		roomManager = new RoomManager();
	}
	
	public static RoomManageController getInstance(){
		if(roomManageController == null)
			roomManageController = new RoomManageController();
		return roomManageController;
	}
	
	public RoomDescriptionVO getRoomInfo(String hotelID, RoomType roomType) {
		return roomManager.getRoomInfo(hotelID, roomType);
	}

	public ResultMessage_Room saveRoomInfo(String hotelID ,RoomDescriptionVO roomDescriptionVO) {
		return roomManager.saveRoomInfo(hotelID, roomDescriptionVO);
	}

	public List<String> getAllRoomByType(String hotelID, RoomType roomType) {
		return roomManager.getAllRoomByType(hotelID, roomType);
	}

	public List<String> getAvaiableRoomBytime(String hotelID, RoomType roomType, Date begin, Date end) {
		return roomManager.getAvaiableRoomBytime(hotelID, roomType, begin, end);
	}

	public int getAllNumberByType(String hotelID, RoomType roomType) {
		return roomManager.getAllNumberByType(hotelID, roomType);
	}

	public int getAvaiableNumberByTime(String hotelID, RoomType roomType, Date begin, Date end) {
		return roomManager.getAvaiableNumberByTime(hotelID, roomType, begin, end);
	}

	@Override
	public ResultMessage_Room changePrice(String hotelID, RoomType roomType, double price) {
		return roomManager.changePrice(hotelID, roomType, price);
	}
	
}
