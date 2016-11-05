package vo;

import tools.Star;

public class HotelInputVO {
	public String HotelName;
	public String HotelAddr;//酒店地址
	public String ComeAddr;//酒店商圈
	public Star star; 
	
	
	public HotelInputVO(String HotelName,String HotelAddr,String ComeAddr,Star star){
		this.HotelName=HotelName;
		this.HotelAddr=HotelAddr;
		this.ComeAddr=ComeAddr;
		this.star=star;
	}
	
}
