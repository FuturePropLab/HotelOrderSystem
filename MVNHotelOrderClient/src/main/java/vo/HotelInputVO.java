package vo;

import tools.Star;

/**
 * 这个写的非常好
 * 那个初始注册信息就这些 其他我都置为空
 * @author ？？？
 *
 */
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
