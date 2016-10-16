package dataservice.hotel;

import java.util.List;

import po.HotelInfoPO;
import po.ResultMessage;
import po.SearchHotelInfo;

//�ӿڣ�������
public interface HotelService {
		
		public ResultMessage addHotelInfo(HotelInfoPO hotelInfo);
		public ResultMessage modifyHotelInfo(HotelInfoPO hotelInfo);
		public HotelInfoPO getHotelInfo(String hotelID);
		public List<HotelInfoPO> searchHotelList(SearchHotelInfo searchInfo);
		
		
}
