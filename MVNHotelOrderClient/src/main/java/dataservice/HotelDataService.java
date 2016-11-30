package dataservice;

import java.util.List;

import po.HotelPO;
import tools.ResultMessage_Hotel;
import tools.SearchHotel;

public interface HotelDataService {
	public ResultMessage_Hotel addHotelInfo (HotelPO hotelInfo);
	public  ResultMessage_Hotel modifyHotelInfo(HotelPO hotelInfoPO);
	public HotelPO getHotelInfo (String hotel_id);
	public List<HotelPO> searchHotelList(SearchHotel searchhotel);
	
	
}
