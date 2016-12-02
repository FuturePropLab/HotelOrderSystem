package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.OutOfBoundsException;
import businesslogicservice.HotelDealService;
import tools.Mark;
import tools.RoomType;
import tools.SortType;
import tools.Star;
import tools.TypeRoomInfo;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelInfoVO;
import vo.HotelRoomInfoVO;
import vo.SearchHotelVO;

public class HotelDeal_Stub implements HotelDealService {

	
	public List<HotelInfoVO> SearchHotel(SearchHotelVO searchhotel) {
		// TODO Auto-generated method stub
		List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		try {
			HotelInfoVO hotelinfo = new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou",new Mark(4.5),
					"good","room",hotelRoomInfoVO,Star.five);
			hotelInfolist.add(hotelinfo);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}

		return hotelInfolist;
		
	}

	
	public List<HotelInfoVO> SortHotel(List<HotelInfoVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		
		List<HotelInfoVO> hotelInfolist = new ArrayList<HotelInfoVO>();
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelInfoVO hotelinfo=new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou",null,"good","room",hotelRoomInfoVO,Star.five);
		hotelInfolist.add(hotelinfo);

		return hotelInfolist;
	}

	
	public HotelInfoVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		List<TypeRoomInfo> typeList = new ArrayList<TypeRoomInfo>();
		TypeRoomInfo typeRoomInfo1= new TypeRoomInfo("001","�ٻ���Ƶ�",RoomType.Single,5,180.0);
		typeList.add(typeRoomInfo1);
		HotelRoomInfoVO hotelRoomInfoVO = new HotelRoomInfoVO("001","�ٻ���Ƶ�",typeList);
		
		HotelInfoVO hotelinfo=new HotelInfoVO("001","�ٻ���Ƶ�", "nanjing","xinjiekou",null,"good","room",hotelRoomInfoVO,Star.five);
		
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
	

}
