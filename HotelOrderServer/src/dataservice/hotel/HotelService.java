package dataservice.hotel;

import java.util.List;

import po.HotelInfoVO;
import po.ResultMessage;
import po.SearchHotelInfo;

//接口，供调用
public interface HotelService {
		
		public ResultMessage addHotelInfo(HotelInfoVO hotelInfo);
		public ResultMessage modifyHotelInfo(HotelInfoVO hotelInfo);
		public HotelInfoVO getHotelInfo(String hotelID);
		public List<HotelInfoVO> searchHotelList(SearchHotelInfo searchInfo);
		
		
}
