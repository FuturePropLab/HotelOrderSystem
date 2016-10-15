package dataservice.Account;

import java.util.List;

public interface Hotel {
	public ResultMessage addHotel(HotelAccountPO);

	public ResultMessage modifyHotel(HotelAccountPO);

	public HotelAccountPO getHotel(String hotel_id);

	public ResultMessage deleteHotel(String hotel_id);

	public List<HotelAccountPO> searchHotelList(SearchCondition searchCondition);
}
