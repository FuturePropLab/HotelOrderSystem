package dataservice;

import java.util.List;

import po.HotelInfoPO;
import tools.ResultMessage_Hotel;
import tools.SearchHotel;

public interface HotelDataService {
	public ResultMessage_Hotel addHotelInfo (HotelInfoPO hotelInfo);
	public  ResultMessage_Hotel modifyHotelInfo(HotelInfoPO hotelInfoPO);
	public HotelInfoPO getHotelInfo (String hotel_id);
	public List<HotelInfoPO> searchHotelList(SearchHotel searchhotel);
	
	
}
