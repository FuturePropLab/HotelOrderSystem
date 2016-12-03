package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.OutOfBoundsException;
import businesslogicservice.HotelDealService;
import po.HotelPO;
import tools.Mark;
import tools.PriceRange;
import tools.RoomType;
import tools.SortType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelbriefVO;
import vo.HotelRoomInfoVO;
import vo.SearchHotelVO;

public class HotelDeal_Stub implements HotelDealService {

	
	public List<HotelbriefVO> SearchHotel(SearchHotelVO searchhotel) {
		// TODO Auto-generated method stub
		List<HotelbriefVO> hotelInfolist = new ArrayList<HotelbriefVO>();
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelbriefVO hotelinfo = new HotelbriefVO(new HotelPO("001"));
		HotelbriefVO hotelinfo2 = new HotelbriefVO(new HotelPO("002"));
		hotelInfolist.add(hotelinfo);
		hotelInfolist.add(hotelinfo2);
		hotelInfolist.add(hotelinfo2);
		hotelInfolist.add(hotelinfo2);
		hotelInfolist.add(hotelinfo2);
		hotelInfolist.add(hotelinfo2);
		hotelInfolist.add(hotelinfo2);

		return hotelInfolist;
		
	}

	
	public List<HotelbriefVO> SortHotel(List<HotelbriefVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		
		List<HotelbriefVO> hotelInfolist = new ArrayList<HotelbriefVO>();
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		HotelbriefVO hotelinfo = new HotelbriefVO(null);
		hotelInfolist.add(hotelinfo);

		return hotelInfolist;
	}

	
	public HotelbriefVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);	
		HotelbriefVO hotelinfo = null;
		hotelinfo = new HotelbriefVO(null);
		
		return hotelinfo;
	}

	
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		List<DiscountVO_hotel> discountList = new ArrayList<DiscountVO_hotel>();
		Date date1 = new Date(2016, 9, 23);
		Date date2 = new Date(2016,9,24);
		
		DiscountVO_hotel discount1=new DiscountVO_hotel(null);
		discountList.add(discount1);
		
		return discountList;
	}

	
	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		List<CommentVO> commentlist=new ArrayList<CommentVO>();
		CommentVO C1=new CommentVO("good");
		commentlist.add(C1);
		
		return commentlist;
	}


	public List<String> getAllCity() {
		List<String> cities=new ArrayList<String>();
		cities.add("nanjing");
		cities.add("beijing");
		return cities;
	}


	public List<String> getAllDistrictByCity(String city) {
		List<String> districts=new ArrayList<String>();
		districts.add("district1");
		districts.add("district2");
		return districts;
	}


	public List<String> getBusineeCircleByDistrict(String district) {
		List<String> busineeCircles=new ArrayList<String>();
		busineeCircles.add("busineeCircle1");
		busineeCircles.add("busineeCircle2");
		return busineeCircles;
	}


	public List<HotelbriefVO> searchHotelListFuzzy(String input) {
		List<HotelbriefVO> hotelList=new ArrayList<HotelbriefVO>();
		HotelPO hotelPO=new HotelPO("hotelID", "hotelName");
		hotelPO.setGrade(2.2);
		hotelPO.setStar(Star.two);
		hotelList.add(new HotelbriefVO(hotelPO));
		hotelPO.setGrade(2.4);
		hotelPO.setStar(Star.three);
		hotelList.add(new HotelbriefVO(hotelPO));
		return hotelList;
	}
	

}
