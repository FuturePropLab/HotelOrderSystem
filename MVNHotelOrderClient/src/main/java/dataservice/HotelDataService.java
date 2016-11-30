package dataservice;

import java.util.List;

import po.HotelPO;
import tools.ResultMessage_Hotel;
import tools.SearchHotel;

public interface HotelDataService {
	/**
	 * 
	 * @param hotelInfo
	 * @return
	 */
	public ResultMessage_Hotel addHotelInfo (HotelPO hotelInfo);
	
	/**
	 * 
	 * @param hotelInfoPO
	 * @return
	 */
	public  ResultMessage_Hotel modifyHotelInfo(HotelPO hotelInfoPO);
	
	 /**
	  * 
	  * @param hotel_id
	  * @return
	  */
	public HotelPO getHotelInfo (String hotel_id);
	
	/**
	 * 
	 * @param searchhotel
	 * @return
	 */
	public List<HotelPO> searchHotelList(SearchHotel searchhotel);
	
	
}
