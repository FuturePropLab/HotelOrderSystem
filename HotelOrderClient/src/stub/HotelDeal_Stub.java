package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogicservice.HotelDealService;
import tools.RoomType;
import tools.SortType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.CommentVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.HotelInfoVO;
import vo.HotelRoomInfoVO;
import vo.SearchHotelVO;

public class HotelDeal_Stub implements HotelDealService {

	@Override
	public List<HotelInfoVO> SearchHotel(SearchHotelVO searchhotel) {
		// TODO Auto-generated method stub
		List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelInfoVO hotelinfo=new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou","good","good","room",hotelRoomInfoVO,Star.five);
		hotelInfolist.add(hotelinfo);

		return hotelInfolist;
		
	}

	@Override
	public List<HotelInfoVO> SortHotel(List<HotelInfoVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		
		List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelInfoVO hotelinfo=new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou","good","good","room",hotelRoomInfoVO,Star.five);
		hotelInfolist.add(hotelinfo);

		return hotelInfolist;
	}

	@Override
	public HotelInfoVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelInfoVO hotelinfo=new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou","good","good","room",hotelRoomInfoVO,Star.five);
		
		return hotelinfo;
	}

	@Override
	public List<DiscountVO> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		List<DiscountVO> discountList = new ArrayList<DiscountVO>();
		Date date1 = new Date(2016, 9, 23);
		Date date2 = new Date(2016,9,24);
		
		DiscountVO_hotel discount1=new DiscountVO_hotel("001",8,date1,date2);
		discountList.add(discount1);
		
		return discountList;
	}

	@Override
	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		List<CommentVO> commentlist=new ArrayList<CommentVO>();
		CommentVO C1=new CommentVO("good");
		commentlist.add(C1);
		
		return commentlist;
	}
	

}
