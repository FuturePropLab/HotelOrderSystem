package po;

import java.io.Serializable;

import businesslogic.hotel.HotelInfo;
import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.Star;
import vo.HotelInputVO;

public class HotelPO implements Serializable{
	private static final long serialVersionUID = -132346433963059143L;
	private String hotelID;
	private String hotelName;
	private HotelAddress hotelAddress; //地址类 ，已经包括商圈的东西
	private double grade;
	private HotelFacility facility;
	private HotelRoomInfo hotelRoom;
	private Star star;
	
	public HotelPO(HotelInputVO hotelInputVO){
		super();
		this.hotelID = hotelInputVO.hotelID;
		this.hotelName = hotelInputVO.HotelName;
		this.facility =hotelInputVO.hotelFacility;
		this.hotelRoom =hotelInputVO.hotelRoomInfo;
		this.hotelAddress = hotelInputVO.hotelAddress;
		this.star = hotelInputVO.star;
	}
	
	/**
	 * 
	 * @param hotelID
	 * @param hotelName
	 */
	public HotelPO(String hotelID , String hotelName){
		this.hotelID = hotelID;
		this.hotelName = hotelName;
	}
	
	/**
	 * 
	 * @param hotelID
	 */
	public HotelPO(String hotelID){
		this.hotelID = hotelID;
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
