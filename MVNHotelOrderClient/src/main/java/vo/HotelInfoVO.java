package vo;

import tools.Mark;
import tools.Star;

public class HotelInfoVO {
	
	public String hotelID;
	public String hotelName;
	public  String hotelAddress;
	public  String ComeAddr;
	public  Mark mark;//评分  zjy改 2016.11.6
	public  String introduction;//简介
	public  String facility;//设备
	public  HotelRoomInfoVO hotelRoomVO;//客房信息
	public Star star;//星级
	

	public HotelInfoVO(String hotelID,String hotelName, String hotelAddress,String district,Mark mark,String introduction,String facility,HotelRoomInfoVO hotelRoomVO,Star star){
	this.hotelID=hotelID;
	this.hotelName=hotelName;
	this.hotelAddress=hotelAddress;
	this.ComeAddr=district;
	this.star=star;
	this. mark=mark;
	this.introduction=introduction;
	this.facility=facility;
	this.hotelRoomVO=hotelRoomVO;
	
}
	
	
}
