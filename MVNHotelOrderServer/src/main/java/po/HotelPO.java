package po;

import java.io.Serializable;

import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelInfo;
import tools.HotelRoomInfo;
import tools.Star;

/**
 * 传过来的 HotelPO
 * @author wshwbluebird
 *
 */
public class HotelPO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7655858599343856811L;
	private String hotelID;
	private String hotelName;
	private HotelAddress hotelAddress; //地址类 ，已经包括商圈的东西
	private double grade;
	private HotelInfo introduction; //包含排版等一系列信息
	private HotelFacility facility;
	private HotelRoomInfo hotelRoom;
	private Star star;
	
	public HotelPO(HotelBasePO hotelBasePO , HotelAddressPO hotelAddressPO,  HotelInfo introduction
			      ,  HotelRoomInfo hotelRoomInfo, HotelFacilityPO facilityPO){
			this.hotelID = hotelBasePO.getHotelID();
			this.grade  =hotelBasePO.getGrade();
			this.hotelName = hotelBasePO.getHotelName();
			this.star = hotelBasePO.getStar();
			
			this.facility = new HotelFacility(facilityPO);
			
			this.hotelAddress = new HotelAddress(hotelAddressPO);
			
			//TODO
			this.introduction  =null;
			this.hotelRoom = hotelRoomInfo;
			
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
	public HotelAddress getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(HotelAddress hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	
	public HotelFacility getFacility() {
		return facility;
	}
	public void setFacility(HotelFacility facility) {
		this.facility = facility;
	}
	
	public HotelRoomInfo getHotelRoom() {
		return hotelRoom;
	}
	public void setHotelRoom(HotelRoomInfo hotelRoom) {
		this.hotelRoom = hotelRoom;
	}
	public Star getStar() {
		return star;
	}
	public void setStar(Star star) {
		this.star = star;
	}
	public HotelInfo getIntroduction() {
		return introduction;
	}
	public void setIntroduction(HotelInfo introduction) {
		this.introduction = introduction;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
	
	
}
