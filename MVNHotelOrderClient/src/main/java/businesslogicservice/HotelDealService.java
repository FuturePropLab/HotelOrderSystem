package businesslogicservice;

import java.util.List;

import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.HotelInfoVO;
import vo.SearchHotelVO;

public interface HotelDealService {
	public List<HotelInfoVO> SearchHotel (SearchHotelVO searchhotel);
	public List<HotelInfoVO> SortHotel (List<HotelInfoVO>hotelInfo ,SortType sortType);
	public HotelInfoVO getHotelInfo (String hotel_id);
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id);
	public List<CommentVO> getComment(String hotel_id);
	
}
