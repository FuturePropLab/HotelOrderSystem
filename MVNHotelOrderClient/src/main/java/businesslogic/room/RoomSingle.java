package businesslogic.room;

import java.rmi.RemoteException;
import java.util.Date;

import dataservice.RoomDataService;
import rmi.RemoteHelper;
import tools.ResultMessage_Room;
import tools.RoomType;

/**
 * 处理单独房间的委托类
 * @author wshwbluebird
 *
 */
public class RoomSingle  {
	private RoomDataService roomDataService;
	
	public RoomSingle(){
		roomDataService = RemoteHelper.getInstance().getRoomDataService();
	}
	public ResultMessage_Room addSingleRoom(String hotelID, String RoomNO, RoomType roomType) {
		try {
			return roomDataService.addRoom(hotelID, RoomNO, roomType);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Room.fail;
		}
	}

	public ResultMessage_Room deleteSingleRoom(String hotelID, String roomNO) {
		try {
			return roomDataService.deleteRoom(hotelID, roomNO);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Room.fail;
		}
	}

	public ResultMessage_Room addDisable(String hotelID, String roomNO, Date begin, Date end) {
		try {
			return roomDataService.addRecord(hotelID, roomNO, begin, end);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Room.fail;
		}
	}

	public ResultMessage_Room deleteDisable(String hotelID, String roomNO, Date begin) {
		try {
			return roomDataService.deleteRecord(hotelID, roomNO, begin);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			return ResultMessage_Room.fail;
		}

	}

}
