package vo;

import tools.Star;

public class HotelInputVO {
	public String HotelName;
	public String HotelAddr;//��ַ
	public String ComeAddr;//��Ȧ
	
	public Star star;
	
	
	public HotelInputVO(String HotelName,String HotelAddr,String ComeAddr,Star star){
		this.HotelName=HotelName;
		this.HotelAddr=HotelAddr;
		this.ComeAddr=ComeAddr;
		this.star=star;
	}
	
}
