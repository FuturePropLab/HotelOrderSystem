package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import tools.ResultMessage_Hotel;
import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelAssessVO;
import vo.HotelDetailsVO;
import vo.HotelFacilityVO;
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
	
	
	/**
	 * 
	 * @param hotelID
	 * @return
	 */
	public HotelAssessVO gethotelAssessVO(String hotelID);
	
	/**
	 * 
	 * @param hotelID
	 * @return
	 */
	public HotelFacilityVO  gethotelFacilityVO(String hotelID);
	
	/**
	 * 
	 * @param hotelID
	 * @return
	 */
	public HotelDetailsVO  getHotelDetailsVO(String hotelID);
	
	/**
	 * 
	 * @param customerID
	 * @param hotelID
	 * @return
	 */
	public  boolean isbooked(String customerID , String hotelID);
	
	/**
	 * 注册时候修改酒店的名字
	 * @param hotelID
	 * @param hotelName
	 * @return
	 */
	public ResultMessage_Hotel modifyHotelName(String hotelID , String hotelName);
	
}
