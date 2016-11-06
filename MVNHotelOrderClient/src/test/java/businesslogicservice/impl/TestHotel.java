package businesslogicservice.impl;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import Exception.OutOfBoundsException;
import businesslogic.discount.HotelDiscount;
import businesslogic.hotel.Hotel;
import businesslogic.hotel.MockHotelDiscount;
import businesslogic.hotel.MockOrder;
import stub.HotelDeal_Stub;
import stub.ManageHotelInfo_Stub;
import tools.DateRange;
import tools.PriceRange;
import tools.ResultMessage2;
import tools.RoomType;
import tools.SortType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.CommentVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.HotelRoomInfoVO;
import vo.SearchHotelVO;

public class TestHotel {

	@Test
	public void test() throws OutOfBoundsException {
		Hotel test=new Hotel();
		ResultMessage2 re=ResultMessage2.success
				;
		HotelInputVO t=new HotelInputVO("JINLINGDAJIUDIAN","xinjiekou","good",Star.five);
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","gg",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","gg",typeList);
		
		HotelInfoVO hotelInfo=new HotelInfoVO("0000","JINGLING","xinjiekou","nanjing","5","good","fantastic",hotelRoomInfoVO,Star.five);
		
		
		String hotelid="0000";
		List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		
		
		HotelInfoVO hotelinfo=new HotelInfoVO(hotelid,"gg", "nanjing","xinjiekou","good","good","room",hotelRoomInfoVO,Star.five);
		hotelInfolist.add(hotelinfo);
		PriceRange rang=new PriceRange(100,200);
		DateRange drange=new DateRange(Time.valueOf("2016/11/3"), Time.valueOf("2016/11/4"));
		SearchHotelVO search=new SearchHotelVO("nanjing", "xinjiekou", "gg", RoomType.Single, rang,
				drange, Star.five, false);
		List<HotelInfoVO> te=new ArrayList();
		te.add(hotelInfo);
		
		MockHotelDiscount dis=new MockHotelDiscount();
		
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		ResultMessage2 expect=ResultMessage2.fail;
		
		String discountid="0001";
		HotelDiscount temp=new HotelDiscount();
		DiscountVO_hotel expect2=new DiscountVO_hotel("0000",9.9,t1,t2);
		List<DiscountVO_hotel> list=new LinkedList();
		
		List<CommentVO> clist=new ArrayList();
		CommentVO c=new CommentVO("GOOD");
		clist.add(c);
		
		MockOrder co=new MockOrder(null, null, null, null);
		
		
		assertEquals(re,test.addHotel(t));
		assertEquals(t,test.editHotelInfo(hotelid));
		assertEquals(re,test.saveHotelInfo(hotelInfo));
		assertEquals(te,test.SearchHotel(search));
		assertEquals(te,test.SortHotel(hotelInfolist, SortType.grade));
		assertEquals(hotelinfo,test.getHotelInfo(hotelid));
		assertEquals(list,dis.getHotelDiscount(hotelid));
		assertEquals(clist,co.getComment());
		
		
	}

}
