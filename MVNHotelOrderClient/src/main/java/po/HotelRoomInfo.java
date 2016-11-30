package po;

import java.util.List;

import tools.TypeRoomInfo;

public class HotelRoomInfo {
	private String hotelID;
	private String hotelName;
	private List<TypeRoomInfo> typeRoomInfo;
	
	public HotelRoomInfo(String hotelID, String hotelName, List<TypeRoomInfo> typeRoomInfo) {
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.typeRoomInfo= typeRoomInfo;
	}
	public HotelRoomInfo() {
		super();
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public List<TypeRoomInfo> getTypeRoomInfo() {
		return typeRoomInfo;
	}
	public void setTypeRoomInfo(List<TypeRoomInfo> typeRoomInfo) {
		this.typeRoomInfo = typeRoomInfo;
	}
	
	
}
