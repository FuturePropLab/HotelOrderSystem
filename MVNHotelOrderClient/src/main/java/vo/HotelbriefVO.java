package vo;

import javafx.scene.image.Image;
import tools.Mark;
import tools.PriceRange;
import tools.Star;
/**
 * 酒店简要信息，用于作为酒店搜索的返回信息
 * @author zjy
 *
 */
public class HotelbriefVO {
	public Image image; //酒店首页图片 
	public PriceRange priceRange;  //价格区间
	public String hotelID;
	public String hotelName;
	public  String hotelAddress;
	public  String ComeAddr;
	public  Mark mark;//评分  zjy改 2016.11.6
	public  String introduction;//简介
	public  String facility;//设备
	public  HotelRoomInfoVO hotelRoomVO;//客房信息
	public Star star;//星级
	

	public HotelbriefVO(Image image,PriceRange priceRange,String hotelID,String hotelName, String hotelAddress,
			String district,Mark mark,String introduction,String facility,HotelRoomInfoVO hotelRoomVO,Star star){
	this.image=image;
	this.priceRange=priceRange;
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
	
	public HotelbriefVO(String hotelID,String hotelName, String hotelAddress,String district,String introduction,String facility,HotelRoomInfoVO hotelRoomVO,Star star){
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
