package po;

public class HotelInfoPO {
	
	private String hotelID;
	private String hotelName;
	private String hotelAddress;
	private String district;
	private String starLevel;
	private String grade;
	private String introduction;
	private String facility;
	private HotelRoomInfoPO hotelRoomPO;
	
	public void setHotelID(String id){
		this.hotelID = id;
	}
	public String getHotelID(){
		return this.hotelID;
	}
	
	public void setHotelName(String name){
		this.hotelName = name;
	}
	public String getHotelName(){
		return this.hotelName;
	}
	
	public void setHotelAddress(String address){
		this.hotelAddress = address;
	}
	public String getHotelAddress(){
		return this.hotelAddress;
	}
	
	public void setDistrict(String district){
		this.district = district;
	}
	public String getDistrict(){
		return this.district;
	}
	
	public void setStarLevel(String starLevel){
		this.starLevel = starLevel;
	}
	public String getStarLevel(){
		return this.starLevel;
	}
	
	public void setGrade(String grade){
		this.grade = grade;
	}
	public String getGrade(){
		return this.grade;
	}
	
	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
	public String getIntroduction(){
		return this.introduction;
	}
	
	public void setFacility(String facility){
		this.facility = facility;
	}
	public String getFacility(){
		return this.facility;
	}
	
	public void setHotelRoomPO(HotelRoomInfoPO hotelRoom){
		this.hotelRoomPO = hotelRoom;
	}
	public HotelRoomInfoPO getHotelRoomPO(){
		return this.hotelRoomPO;
	}
	
}
