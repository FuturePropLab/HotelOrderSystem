package businesslogic.room;
import businesslogicservice.RoomHotelInfoService;
import dataservice.RoomDataService;
import po.HotelRoomInfoPO;
import stub.RoomHotelInfo_Stub;
import tools.ResultMessage;
import vo.HotelRoomInfoVO;
/**
 * 委托类
 * 
 * @author chenyuyan
 *
 */
public class RoomHotelInfo {
/**
 * 酒店整体客房信息
 * @param hotel_id
 * @return
 */
	private RoomDataService roomData;
	public HotelRoomInfoVO getRoomInfo(String hotel_id) {
		// TODO Auto-generated method stub
		HotelRoomInfoPO roomInfopo = roomData.getRoomInfo(hotel_id);
		HotelRoomInfoVO roomInfovo = new HotelRoomInfoVO(roomInfopo.getHotelID(),roomInfopo.getHotelName(),roomInfopo.getTypeRoomInfo());
		//return new RoomHotelInfo_Stub().getRoomInfo(hotel_id);
		return roomInfovo;
	}

	public HotelRoomInfoVO editRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		// TODO Auto-generated method stub
		
		//RoomHotelInfo_Stub roomHotelInfo_Stub=new RoomHotelInfo_Stub();
		//return roomHotelInfo_Stub.editRoomInfo(hotelRoomInfo);
		return hotelRoomInfo;
		
	}

	public ResultMessage saveRoomInfo(HotelRoomInfoVO hotelRoomInfo) {
		// TODO Auto-generated method stub
		HotelRoomInfoPO roomInfopo = new HotelRoomInfoPO(hotelRoomInfo.hotelID,hotelRoomInfo.hotelName,hotelRoomInfo.typeRoomInfo);
		//return new RoomHotelInfo_Stub().saveRoomInfo(hotelRoomInfo);
		return roomData.editHotelRoom(roomInfopo);
	}

}
