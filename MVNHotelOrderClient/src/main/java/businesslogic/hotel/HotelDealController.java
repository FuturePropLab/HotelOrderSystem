package businesslogic.hotel;

import java.util.List;

import businesslogicservice.HotelDealService;
import tools.SortType;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelbriefVO;
import vo.SearchHotelVO;

public class HotelDealController implements HotelDealService {
	
	private static HotelDealController hotelDealController = null;
	private  Hotel hotel  ;
	private HotelDealController(){
		hotel = new Hotel();
	}
	
	public static HotelDealController getInstance(){
		if(hotelDealController ==null)
			hotelDealController = new HotelDealController();
		return hotelDealController;
	}

	public List<String> getAllCity() {
		return hotel.getAllCity();
	}

	public List<String> getAllDistrictByCity(String city) {
		return hotel.getAllDistrictByCity(city);
	}

	public List<String> getBusineeCircleByDistrict(String district) {
		return hotel.getBusineeCircleByDistrict(district);
	}

	public List<HotelbriefVO> SearchHotel(SearchHotelVO searchhotel) {
		return hotel.SearchHotel(searchhotel);
	}

	public List<HotelbriefVO> SortHotel(List<HotelbriefVO> hotelInfo, SortType sortType) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelbriefVO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CommentVO> getComment(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HotelbriefVO> searchHotelListFuzzy(String input) {
		return hotel.searchHotelListFuzzy(input);
	}
		
}
