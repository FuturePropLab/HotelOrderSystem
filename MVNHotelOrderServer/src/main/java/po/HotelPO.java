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
	private static final long serialVersionUID = -132346433963059143L;
	private String hotelID;
	private String hotelName;
	private HotelAddress hotelAddress; //地址类 ，已经包括商圈的东西
	private double grade;
	private HotelFacility facility;
	private HotelRoomInfo hotelRoom;
	private Star star;
	
	
	public HotelPO(){
		super();
	}
	public HotelPO(HotelBasePO hotelBasePO , HotelAddressPO hotelAddressPO,  HotelInfo introduction
			      ,  HotelRoomInfo hotelRoomInfo, HotelFacilityPO facilityPO){
			this.hotelID = hotelBasePO.getHotelID();
			this.grade  =hotelBasePO.getGrade();
			this.hotelName = hotelBasePO.getHotelName();
			this.star = hotelBasePO.getStar();
			
			//TODO
			this.facility = new HotelFacility(facilityPO);
			
			this.hotelAddress = new HotelAddress(hotelAddressPO);
			
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

	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}

	
	
	
}
