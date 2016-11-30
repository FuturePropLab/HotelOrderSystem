package po;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import tools.HotelRoomInfo;
import tools.TypeRoomInfo;

@Entity
public class HotelRoomInfoPO {
	private String hotelID;
	private String hotelName;
	private List<TypeRoomInfo> typeRoomInfo;
	
	public HotelRoomInfoPO(HotelRoomInfo hotelRoomInfo) {
		this.hotelID = hotelRoomInfo.getHotelID();
		this.hotelName = hotelRoomInfo.getHotelName();
		this.typeRoomInfo= hotelRoomInfo.getTypeRoomInfo();
	}
	public HotelRoomInfoPO() {
		super();
	}
	
	@Id	
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
