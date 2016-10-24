package dataservice;

import java.util.List;

import po.HotelAccountPO;
import po.SearchCondition;
import tools.ResultMessage;

public interface AccountHotelDataService {
	public ResultMessage addHotel(HotelAccountPO hotelAccPO);

	public ResultMessage modifyHotel(HotelAccountPO hotelAccPO);

	public HotelAccountPO getHotel(String hotel_id);

	public ResultMessage deleteHotel(String hotel_id);

	public List<HotelAccountPO> searchHotelList(SearchCondition searchCondition);
}
