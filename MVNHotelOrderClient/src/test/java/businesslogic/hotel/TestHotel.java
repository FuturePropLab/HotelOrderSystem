package businesslogic.hotel;


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
import businesslogic.order.MockCustomerInfo;
import businesslogic.order.MockHotelInfo;
import stub.HotelDeal_Stub;
import stub.ManageHotelInfo_Stub;
import stub.OrderDate_Stub;
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
import vo.OrderInputVO;
import vo.SearchHotelVO;

public class TestHotel {

	@Test
	public void test() throws OutOfBoundsException {
		Hotel test=new Hotel();
		ResultMessage2 re=ResultMessage2.success
				;
		HotelInputVO t=new HotelInputVO("JINLINGDAJIUDIAN","xinjiekou","good",Star.five);
		//List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		//TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","gg",RoomType.Single,5,180.0);
		//typeList.add(typeRoomInfo1);
		//HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","gg",typeList);
		
		//HotelInfoVO hotelInfo=new HotelInfoVO("0000","JINGLING","xinjiekou","nanjing","5","good","fantastic",hotelRoomInfoVO,Star.five);
		
		
		String hotelid="0000";
		List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		
		
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelInfoVO hotelinfo=new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou",null,"good","room",hotelRoomInfoVO,Star.five);
		
		
		
		
		
		//HotelInfoVO hotelinfo=new HotelInfoVO(hotelid,"gg", "nanjing","xinjiekou","good","good","room",hotelRoomInfoVO,Star.five);
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		hotelInfolist.add(hotelinfo);
		PriceRange rang=new PriceRange(100,200);
		DateRange drange=new DateRange(t1, t2);
		SearchHotelVO search=new SearchHotelVO("nanjing", "xinjiekou", "gg", RoomType.Single, rang,
				drange, Star.five, false);
		List<HotelInfoVO> te=new ArrayList();
		te.add(hotelinfo);
		
		
		
		//List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		//List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		//TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		//typeList.add(typeRoomInfo1);
		//HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		//HotelInfoVO hotelinfo=new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou",null,"good","room",hotelRoomInfoVO,Star.five);
		//hotelInfolist.add(hotelinfo);
		
		
		
		MockHotelDiscount dis=new MockHotelDiscount();
		
		//Date t1=new Date(2016,9,1);
		//Date t2=new Date(2016,9,2);
		ResultMessage2 expect=ResultMessage2.fail;
		
		String discountid="0001";
		HotelDiscount temp=new HotelDiscount();
		DiscountVO_hotel expect2=new DiscountVO_hotel("0000",9.9,t1,t2);
		List<DiscountVO_hotel> list=new LinkedList();
		list.add(expect2);
		
		List<CommentVO> clist=new ArrayList();
		CommentVO c=new CommentVO("GOOD");
		clist.add(c);
		
		MockOrder co=new MockOrder(new OrderInputVO("customerID", "hotelID", new Time(0), new Time(0), new Time(0), RoomType.EluxeSuite, 1, 1, false), 
				new MockCustomerInfo(), new MockHotelInfo(), new OrderDate_Stub());
		
		
		assertEquals(re,test.addHotel(t));
		assertEquals(hotelinfo.ComeAddr,test.editHotelInfo(hotelid).ComeAddr);
		assertEquals(re,test.saveHotelInfo(hotelinfo));
		assertEquals(te.get(0).ComeAddr,test.SearchHotel(search).get(0).ComeAddr);
		assertEquals(te.get(0).facility,test.SortHotel(hotelInfolist, SortType.grade).get(0).facility);
		assertEquals(hotelinfo.ComeAddr,test.getHotelInfo(hotelid).ComeAddr);
		assertEquals(list.get(0).Discount_id,dis.getHotelDiscount(hotelid).get(0).Discount_id);
		assertEquals(clist.get(0).comment,co.getComment().get(0).comment);
		
		
	}

}