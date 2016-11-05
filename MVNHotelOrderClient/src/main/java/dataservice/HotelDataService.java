package dataservice;

import java.util.List;

import po.HotelInfoPO;
import tools.ResultMessage2;
import tools.SearchHotel;

public interface HotelDataService {
	public ResultMessage2 addHotelInfo (HotelInfoPO hotelInfo);
	public  ResultMessage2 modifyHotelInfo(HotelInfoPO hotelInfoPO);
	public HotelInfoPO getHotelInfo (String hotel_id);
	public List<HotelInfoPO> searchHotelList(SearchHotel searchhotel);
	
}
