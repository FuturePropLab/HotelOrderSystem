package po;

import tools.Star;
import vo.HotelRoomInfoVO;

public class HotelInfoPO {

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
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getComeAddr() {
		return ComeAddr;
	}
	public void setComeAddr(String comeAddr) {
		ComeAddr = comeAddr;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public HotelRoomInfoPO getHotelRoomPO() {
		return hotelRoomPO;
	}
	public void setHotelRoomPO(HotelRoomInfoPO hotelRoomPO) {
		this.hotelRoomPO = hotelRoomPO;
	}
	public Star getStar() {
		return star;
	}
	public void setStar(Star star) {
		this.star = star;
	}
	private String hotelID;
	private String hotelName;
	private  String hotelAddress;
	private  String ComeAddr;
	private String grade;//评分
	private String introduction;//简介
	private  String facility;//设备
	private  HotelRoomInfoPO hotelRoomPO;//客房信息
	private Star star;//星级
	
}
