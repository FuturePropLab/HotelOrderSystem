package vo;

import tools.Star;

public class HotelInfoVO {
	
	public String hotelID;
	public String hotelName;
	public  String hotelAddress;
	public  String ComeAddr;
	public  String grade;//����
	public  String introduction;//���
	public  String facility;//�豸
	public  HotelRoomInfoVO hotelRoomVO;//�ͷ���Ϣ
	public Star star;//�Ǽ�
	

	public HotelInfoVO(String hotelID,String hotelName, String hotelAddress,String district,String grade,String introduction,String facility,HotelRoomInfoVO hotelRoomVO,Star star){
	this.hotelID=hotelID;
	this.hotelName=hotelName;
	this.hotelAddress=hotelAddress;
	this.ComeAddr=district;
	this.star=star;
	this. grade=grade;
	this.introduction=introduction;
	this.facility=facility;
	this.hotelRoomVO=hotelRoomVO;
	
}
	
	
}
