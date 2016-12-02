package businesslogicservice;

import java.util.List;

import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelbriefVO;
import vo.SearchHotelVO;

public interface HotelDealService {
	
	public List<HotelbriefVO> SearchHotel (SearchHotelVO searchhotel);
	
	public List<HotelbriefVO> SortHotel (List<HotelbriefVO>hotelInfo ,SortType sortType);
	
	public HotelbriefVO getHotelInfo (String hotel_id);
	
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id);
	
	public List<CommentVO> getComment(String hotel_id);
	
	
	
}
