package businesslogic.room;

import java.rmi.RemoteException;
import java.util.Date;

import dataservice.RoomDataService;
import rmi.RemoteHelper;
import stub.RoomData_Stub;
import tools.ResultMessage_Room;
import tools.RoomType;
import vo.RoomVO;

/**
 * 处理单独房间的委托类
 * @author wshwbluebird
 *
 */
public class RoomSingle  {
	private RoomDataService roomDataService;
	
	public RoomSingle(){
//		roomDataService = RemoteHelper.getInstance().getRoomDataService();
		roomDataService = new RoomData_Stub();//TEST
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
	
	
	/**
	 * 没有 只是为了  不报错
	 * @param roomVO
	 * @return
	 */
	public Object editSingleRoom(RoomVO roomVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
