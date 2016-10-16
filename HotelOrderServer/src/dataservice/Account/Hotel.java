package dataservice.Account;

import java.util.List;

import po.HotelAccountPO;
import po.SearchCondition;
import stub.ResultMessage;

public interface Hotel {
	public ResultMessage addHotel(HotelAccountPO hotelAccPO);

	public ResultMessage modifyHotel(HotelAccountPO hotelAccPO);

	public HotelAccountPO getHotel(String hotel_id);

	public ResultMessage deleteHotel(String hotel_id);

	public List<HotelAccountPO> searchHotelList(SearchCondition searchCondition);
}
