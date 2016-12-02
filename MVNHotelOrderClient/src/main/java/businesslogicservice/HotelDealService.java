package businesslogicservice;

import java.util.List;

import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelbriefVO;
import vo.SearchHotelVO;

public interface HotelDealService {
	/**
	 * 
	 * @return all city
	 */
	public List<String> getAllCity();
	
	/**
	 * 
	 * @param city
	 * @return
	 */
	public List<String> getAllDistrictByCity(String city);
	
	/**
	 * 
	 * @param district
	 * @return
	 */
	public List<String> getBusineeCircleByDistrict(String district);
	
	/**
	 * 
	 * @param searchhotel
	 * @return
	 */
	public List<HotelbriefVO> SearchHotel (SearchHotelVO searchhotel);
	
	public List<HotelbriefVO> SortHotel (List<HotelbriefVO>hotelInfo ,SortType sortType);
	
	public HotelbriefVO getHotelInfo (String hotel_id);
	
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id);
	
	public List<CommentVO> getComment(String hotel_id);
	
	
	
}
