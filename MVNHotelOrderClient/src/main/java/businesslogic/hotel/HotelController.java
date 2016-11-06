package businesslogic.hotel;

import java.util.List;

import businesslogicservice.HotelDealService;
import businesslogicservice.ManageHotelInfoService;
import tools.ResultMessage2;
import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.HotelInfoVO;
import vo.HotelInputVO;
import vo.SearchHotelVO;
/**
 * 
 * @author chenyuyan
 *Î¯ÍÐ¸øhotel
 */
public class HotelController implements HotelDealService,ManageHotelInfoService{
	Hotel hotel=new Hotel();
	
	public ResultMessage2 addHotel(HotelInputVO vo) {
		// TODO Auto-generated method stub
		
		return hotel.addHotel(vo);
	}

	public HotelInfoVO editHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		
		return hotel.editHotelInfo(hotel_id);
	}

	public ResultMessage2 saveHotelInfo(HotelInfoVO hotelInfo) {
		// TODO Auto-generated method stub
		
		return hotel.saveHotelInfo(hotelInfo);
	}

	public List<HotelInfoVO> SearchHotel(SearchHotelVO searchhotel) {
		// TODO Auto-generated method stub
		return hotel.SearchHotel(searchhotel);
	}

	public List<HotelInfoVO> SortHotel(List<HotelInfoVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		return hotel.SortHotel(hotelInfo, sortType);
	}

	public HotelInfoVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		return hotel.getHotelInfo(hotel_id);
	}

	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		return hotel.getHotelDiscount(hotel_id);
	}

	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		return hotel.getComment(hotel_id);
	}

}
