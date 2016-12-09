package businesslogic.hotel;

import vo.HotelbriefVO;

public class OrderHotelInfoImpl implements businesslogic.order.HotelInfo{
	
	
	@Override
	public HotelbriefVO getHotelInfo(String hotelID) {
		Hotel hotel = new Hotel();
		return hotel.getHotelInfo(hotelID);
	}

}
