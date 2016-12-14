package businesslogic.room;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataservice.RoomDataService;
import rmi.RemoteHelper;
import stub.RoomData_Stub;
import tools.ResultMessage_Room;
import tools.RoomDescription;
import tools.RoomType;
import vo.RoomDescriptionVO;


/**
 * 处理房间信息的委托类
 * @author wshwbluebird
 *
 */
public class RoomManager {
/**
 * 酒店整体客房信息
 * @param hotel_id
 * @return
 */
	private RoomDataService roomDataService;
	private RoomPictureDeal roomPictureDeal;
	public RoomManager(){
		this.roomDataService = RemoteHelper.getInstance().getRoomDataService();
		roomPictureDeal = new RoomPictureDeal();
//		this.roomDataService =new RoomData_Stub();
//		this.roomPictureDeal = new RoomPictureDeal();
	}
	
	public RoomDescriptionVO getRoomInfo(String hotelID, RoomType roomType) {
		RoomDescription roomDescription = new RoomDescription();
		roomDescription.setRoomType(roomType);
		try {
			roomDescription.setDescription(roomDataService.getRoomInfoString(hotelID, roomType));
		} catch (RemoteException e) {
			roomDescription.setDescription(null);
		}
		roomDescription.setTypeimage(roomPictureDeal.downloadRoomPicture(hotelID, roomType));
		RoomDescriptionVO roomDescriptionVO  =new RoomDescriptionVO(roomDescription);
		return roomDescriptionVO;
	}

	public ResultMessage_Room saveRoomInfo(String hotelID ,RoomDescriptionVO roomDescriptionVO) {
		try {
			roomPictureDeal.uploadRoomPicture(hotelID, roomDescriptionVO.roomType, roomDescriptionVO.typeimage);
			roomDataService.modifyRoomInfoString(hotelID, roomDescriptionVO.roomType, roomDescriptionVO.description);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Room.fail;
		}		
		return ResultMessage_Room.success;
	}
	
	public List<String> getAllRoomByType(String hotelID, RoomType roomType) {
		try {
			return roomDataService.getAvailbleRoomNoByType(hotelID, roomType, null, null);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return new ArrayList<String>();
		}
	}

	public List<String> getAvaiableRoomBytime(String hotelID, RoomType roomType, Date begin, Date end) {
		try {
			return roomDataService.getAvailbleRoomNoByType(hotelID, roomType, begin, end);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return new ArrayList<String>();
		}
	}

	public int getAllNumberByType(String hotelID, RoomType roomType) {
		try {
			return roomDataService.getTotalNumberRoomByType(hotelID, roomType);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int getAvaiableNumberByTime(String hotelID, RoomType roomType, Date begin, Date end) {	
		return  getAvaiableRoomBytime(hotelID, roomType, begin, end).size();
	}
	
	
	public ResultMessage_Room changePrice(String hotelID, RoomType roomType, double price) {
		try {
			return roomDataService.changePrice(hotelID, roomType, price);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage_Room.fail;
		}
	}

}
