package tools;

import java.io.Serializable;
import java.util.List;

public class HotelRoomInfo implements Serializable {
	private static final long serialVersionUID = 7235643209883289946L;;
	private String hotelID;
	private String hotelName;
	private List<TypeRoomInfo> typeRoomInfo;
	
	/**
	 * 
	 * @param hotelID
	 * @param hotelName
	 * @param typeRoomInfo
	 */
	public HotelRoomInfo(String hotelID, String hotelName, List<TypeRoomInfo> typeRoomInfo) {
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.typeRoomInfo= typeRoomInfo;
	}
	/**
	 * 推荐使用
	 * @param hotelID
	 * @param typeRoomInfo
	 */
	public HotelRoomInfo(String hotelID, List<TypeRoomInfo> typeRoomInfo) {
		this.hotelID = hotelID;
		this.hotelName = null;
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
