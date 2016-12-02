package vo;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import Exception.OutOfBoundsException;
import po.HotelPO;
import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.PriceRange;
import tools.Star;
import tools.TypeRoomInfo;

/**
 * 
 * @author wshwbluebird
 *
 */
public class HotelbriefVO {
	public URI imageuri; //酒店首页图片 
	public PriceRange priceRange;  //价格区间
	public String hotelID;
	public String hotelName;
	public HotelAddress hotelAddress;
	public  double  mark;//评分  zjy改 2016.11.6
//	public  String introduction;//简介   wsw:我删了 因为没必要 搜索界面不显示酒店详情!!!!!!!!!
	public  HotelFacility facility;//设备
	public  HotelRoomInfo hotelRoom;//客房信息
	public  Star star;//星级
	
	

//	public HotelbriefVO(Image image,PriceRange priceRange,String hotelID,String hotelName, String hotelAddress,
//			String district,Mark mark,String introduction,String facility,HotelRoomInfoVO hotelRoomVO,Star star){
//	this.image=image;
//	this.priceRange=priceRange;
//	this.hotelID=hotelID;
//	this.hotelName=hotelName;
//	this.hotelAddress=hotelAddress;
//	this.ComeAddr=district;
//	this.star=star;
//	this. mark=mark;
//	this.introduction=introduction;
//	this.facility=facility;
//	this.hotelRoomVO=hotelRoomVO;
//	}
//	
//	public HotelbriefVO(String hotelID,String hotelName, String hotelAddress,String district,String introduction,String facility,HotelRoomInfoVO hotelRoomVO,Star star){
//	this.hotelID=hotelID;
//	this.hotelName=hotelName;
//	this.hotelAddress=hotelAddress;
//	this.ComeAddr=district;
//	this.star=star;
//	this. mark=mark;
//	this.introduction=introduction;
//	this.facility=facility;
//	this.hotelRoomVO=hotelRoomVO;	
//}
	
	public HotelbriefVO(HotelPO hotelPO){
		super();
		this.facility = hotelPO.getFacility();
		this.hotelRoom = hotelPO.getHotelRoom();
		this.hotelAddress =hotelPO.getHotelAddress();
		this.hotelID = hotelPO.getHotelID();
		this.hotelName = hotelPO.getHotelName();
		this.mark = hotelPO.getGrade();
		this.star = hotelPO.getStar();
		
		List<TypeRoomInfo> typeRoomInfos =hotelRoom.getTypeRoomInfo();
		if(typeRoomInfos!=null  && typeRoomInfos.size()!=0){
			double least = typeRoomInfos.get(0).getPrice();
			double high = typeRoomInfos.get(0).getPrice();
			Iterator<TypeRoomInfo> it = typeRoomInfos.iterator();
			while(it.hasNext()){
				double price = it.next().getPrice();
				if(least > price)  least = price;
				if(high < price) high = price;
			}
			try {
				this.priceRange = new PriceRange(least, high);
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
			
		}		
	}
	
	
}
