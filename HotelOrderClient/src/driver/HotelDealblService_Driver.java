package Driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.OutOfBoundsException;
import businesslogicservice.HotelDealService;
import tools.DateRange;
import tools.PriceRange;
import tools.RoomType;
import tools.SortType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.HotelInfoVO;
import vo.HotelRoomInfoVO;
import vo.SearchHotelVO;

public class HotelDealblService_Driver {
public void drive(HotelDealService hotelDealService) throws OutOfBoundsException{
	List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
	List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
	TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("002","荣华大酒店",RoomType.Single,5,180.0);
	typeList.add(typeRoomInfo1);
	HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("002","荣华大酒店",typeList);
	
	HotelInfoVO hotelinfo=new HotelInfoVO("002","荣华大酒店", "nanjing","xinjiekou","good","good","room",hotelRoomInfoVO,Star.five);
	hotelInfolist.add(hotelinfo);
	
	PriceRange range=new PriceRange(10,20);
	Date d1=new Date(2016,9,1);
	Date d2=new Date(2016,9,2);
	DateRange daterange=new DateRange(d1,d2);
	SearchHotelVO searchhotel=new SearchHotelVO("nanjing", "xinjiekou", "ronghua", RoomType.Single,range, daterange, Star.five, true);
	
	
	
	
	System.out.println(hotelDealService.SortHotel(hotelInfolist, null).get(0).facility);
	
	System.out.println(hotelDealService.getHotelInfo("123123").hotelAddress);
	
	System.out.println(hotelDealService.getHotelDiscount("2321").get(0).Discount_id);
	
	System.out.println(hotelDealService.getComment("123").size());
	
	System.out.println(hotelDealService.SearchHotel(searchhotel).get(0).facility);
//	List<HotelInfoVO> hotelInfolist2 = new ArrayList<HotelInfoVO>();
//	hotelInfolist2＝hotel.SortHotel(hotelInfolist, SortType.grade);

	
}
}
