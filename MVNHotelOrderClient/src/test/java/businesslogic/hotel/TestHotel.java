package businesslogic.hotel;


import static org.junit.Assert.*;

import java.net.URI;
import java.sql.Time;
import java.time.LocalDate;
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
import po.HotelPO;
import stub.HotelDeal_Stub;
import stub.ManageHotelInfo_Stub;
import stub.OrderDate_Stub;
import tools.DateRange;
import tools.HotelAddress;
import tools.HotelFacility;
import tools.HotelRoomInfo;
import tools.PriceRange;
import tools.ResultMessage_Hotel;
import tools.RoomType;
import tools.SortType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelDetailsVO;
import vo.HotelDiscribtionsVO;
import vo.HotelInputVO;
import vo.HotelRoomInfoVO;
import vo.HotelbriefVO;
import vo.OrderInputVO;
import vo.SearchHotelVO;

public class TestHotel {
	private Hotel hotel;
	@Test
	public void testadd() throws OutOfBoundsException {
		Hotel test=new Hotel();
		ResultMessage_Hotel re=ResultMessage_Hotel.success;
		HotelAddress address = new HotelAddress("南京", "秦淮区", "xinjiekou", "no123");
		HotelDiscribtionsVO dis = new HotelDiscribtionsVO(null, null);
		HotelInputVO hotelInputVO=new HotelInputVO(null, "001","金陵酒店", Star.five,address,dis);
		//List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		//TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","gg",RoomType.Single,5,180.0);
		//typeList.add(typeRoomInfo1);
		//HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","gg",typeList);
		
		//HotelInfoVO hotelInfo=new HotelInfoVO("0000","JINGLING","xinjiekou","nanjing","5","good","fantastic",hotelRoomInfoVO,Star.five);
		
		
		
//		List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		hotel = new Hotel();
		assertEquals(ResultMessage_Hotel.fail,hotel.addHotel(hotelInputVO));
	}
		
		
	@Test
	public void testSearchHotel(){
		hotel = new Hotel();
		SearchHotelVO searchVO = new SearchHotelVO("南京",null,"夫子庙",null,null,null,null,false);
		assertEquals("003",hotel.SearchHotel(searchVO).get(0).hotelID);
	}
	@Test
	public void testSearchHotel2(){
		hotel = new Hotel();
		SearchHotelVO searchVO = new SearchHotelVO("南京",null,null,"rujia",null,null,null,false);
		assertEquals("003",hotel.SearchHotel(searchVO).get(0).hotelID);
	}
	@Test
	public void testSearch3(){
		hotel = new Hotel();
		SearchHotelVO searchVO = new SearchHotelVO("上海",null,null,null,null,null,null,false);
		assertEquals("004",hotel.SearchHotel(searchVO).get(0).hotelID);
	}
	@Test
	public void testSort(){
		hotel = new Hotel();
		
		HotelAddress add = new HotelAddress("南京", "秦淮区","新街口","aa");
		HotelInputVO hotelInputVO = new HotelInputVO(null,"001","jinling",Star.five,add,null);
		HotelPO hotel1  = new HotelPO(hotelInputVO);
		HotelFacility facility = new HotelFacility();
		hotel1.setFacility(facility);
		 List<TypeRoomInfo> typeRoomInfo = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("001", RoomType.Double,10,100.0));
		hotel1.setHotelRoom(new HotelRoomInfo("001","jinling",typeRoomInfo));
		hotel1.setGrade(1.2);
		HotelbriefVO brief = new HotelbriefVO(hotel1);
		
		
		HotelAddress add2 = new HotelAddress("南京", "秦淮区","新街口","aa");
		HotelInputVO hotelInputVO2 = new HotelInputVO(null,"002","jinjiang",Star.five,add,null);
		HotelPO hotel2  = new HotelPO(hotelInputVO2);
		
		HotelFacility facility2 = new HotelFacility();
		hotel2.setFacility(facility2);
		 List<TypeRoomInfo> typeRoomInfo2 = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("002", RoomType.Double,10,100.0));
		hotel2.setHotelRoom(new HotelRoomInfo("002","jinling",typeRoomInfo));
		hotel2.setGrade(3.0);
		HotelbriefVO brief2 = new HotelbriefVO(hotel1);
		
		
		
		
		HotelAddress add3 = new HotelAddress("南京", "秦淮区","夫子庙","aa");
		HotelInputVO hotelInputVO3= new HotelInputVO(null,"003","rujia",Star.five,add,null);
		HotelPO hotel3  = new HotelPO(hotelInputVO3);
		HotelFacility facility3= new HotelFacility();
		hotel3.setFacility(facility3);
		 List<TypeRoomInfo> typeRoomInfo3 = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("003", RoomType.Double,10,100.0));
		hotel3.setHotelRoom(new HotelRoomInfo("003","jinling",typeRoomInfo));
		hotel3.setGrade(4.0);
		HotelbriefVO brief3 = new HotelbriefVO(hotel1);
		
		
		HotelAddress add4 = new HotelAddress("上海", "xx","xx","aa");
		HotelInputVO hotelInputVO4= new HotelInputVO(null,"004","rujia",Star.five,add,null);
		HotelPO hotel4  = new HotelPO(hotelInputVO4);
		HotelFacility facility4 = new HotelFacility();
		hotel4.setFacility(facility4);
		 List<TypeRoomInfo> typeRoomInfo4 = new ArrayList<TypeRoomInfo>();
		 typeRoomInfo.add(new TypeRoomInfo("004", RoomType.Double,10,100.0));
		hotel4.setHotelRoom(new HotelRoomInfo("004","jinling",typeRoomInfo));
		hotel4.setGrade(2.0);
		HotelbriefVO brief4 = new HotelbriefVO(hotel1);
		
		ArrayList<HotelbriefVO> list = new ArrayList<HotelbriefVO>();
		list.add(brief);
		list.add(brief2);
		list.add(brief3);
		list.add(brief4);
		assertEquals("001", hotel.SortHotel(list, SortType.grade).get(0).hotelID);
		
		
	}
		@Test
		public void testGetHotelDiscount(){
			hotel = new Hotel();
			LocalDate date2 = LocalDate.of(2015, 5, 1);
			assertEquals(date2, hotel.getHotelDiscount("001").get(0).endDate);
			
			
		}
		
		@Test
		public void testGetHotelDiscription(){
			hotel =new Hotel();
			assertEquals(hotel.getHotelDiscribtionsVO("001").discribes.get(0), "环境好");
		}
		/*List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
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
		
		MockOrder co=new MockOrder(new OrderInputVO("customerID", "hotelID", new Time(0), new Time(0), new Time(0), RoomType.EluxeSuite, 1, 1, false,100), 
				new MockCustomerInfo(), new MockHotelInfo(), new OrderDate_Stub());
		
		
		assertEquals(re,test.addHotel(t));
		assertEquals(hotelinfo.ComeAddr,test.editHotelInfo(hotelid).ComeAddr);
		assertEquals(re,test.saveHotelInfo(hotelinfo));
		assertEquals(te.get(0).ComeAddr,test.SearchHotel(search).get(0).ComeAddr);
		assertEquals(te.get(0).facility,test.SortHotel(hotelInfolist, SortType.grade).get(0).facility);
		assertEquals(hotelinfo.ComeAddr,test.getHotelInfo(hotelid).ComeAddr);
		assertEquals(list.get(0).Discount_id,dis.getHotelDiscount(hotelid).get(0).Discount_id);
		assertEquals(clist.get(0).comment,co.getComment().get(0).comment);
		
		*/
	}

