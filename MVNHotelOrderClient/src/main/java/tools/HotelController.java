package tools;

import java.net.URI;
import java.util.List;

import businesslogic.hotel.Hotel;
import businesslogicservice.HotelDealService;
import businesslogicservice.ManageHotelInfoService;
import vo.CommentVO;
import vo.DiscountVO_hotel;
import vo.HotelAssessVO;
import vo.HotelDetailsVO;
import vo.HotelFacilityVO;
import vo.HotelInputVO;
import vo.HotelbriefVO;
import vo.SearchHotelVO;
/**
 * 
 * @author chenyuyan
 *ί�и�hotel
 */
public class HotelController implements HotelDealService,ManageHotelInfoService{
	Hotel hotel=new Hotel();
	
	public ResultMessage_Hotel addHotel(HotelInputVO vo) {
		return hotel.addHotel(vo);
	}


	public List<HotelbriefVO> SearchHotel(SearchHotelVO searchhotel) {
		return hotel.SearchHotel(searchhotel);
	}

	public List<HotelbriefVO> SortHotel(List<HotelbriefVO> hotelInfo, SortType sortType) {
		return hotel.SortHotel(hotelInfo, sortType);
	}

	public HotelbriefVO getHotelInfo(String hotel_id) {
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


	public ResultMessage_Hotel saveHotelInfo(HotelInputVO hotelInputVO) {
		// TODO Auto-generated method stub
		return null;
	}




	public ResultMessage_Hotel modifyHotelPicture(String hotelID, URI uri) {
		// TODO Auto-generated method stub
		return null;
	}




	public List<String> getAllCity() {
		// TODO Auto-generated method stub
		return null;
	}




	public List<String> getAllDistrictByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}




	public List<String> getBusineeCircleByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}




	public List<HotelbriefVO> searchHotelListFuzzy(String input) {
		// TODO Auto-generated method stub
		return null;
	}


	public HotelAssessVO gethotelAssessVO(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}


	public HotelFacilityVO gethotelFacilityVO(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}


	public HotelDetailsVO getHotelDetailsVO(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

}
