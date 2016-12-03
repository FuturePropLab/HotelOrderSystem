package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import po.HotelPO;
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
	
	/**
	 * 
	 * @param hotelInfo
	 * @param sortType
	 * @return
	 */
	public List<HotelbriefVO> SortHotel (List<HotelbriefVO>hotelInfo ,SortType sortType);
	
	
	/**
	 * 
	 * @param hotel_id
	 * @return
	 */
	public HotelbriefVO getHotelInfo (String hotel_id);
	
	
	/**
	 * 
	 * @param hotel_id
	 * @return
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id);
	
	
	/**
	 * 
	 * @param hotel_id
	 * @return
	 */
	public List<CommentVO> getComment(String hotel_id);
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws RemoteException
	 */
	public List<HotelbriefVO> searchHotelListFuzzy(String input);
	
	
	
}
