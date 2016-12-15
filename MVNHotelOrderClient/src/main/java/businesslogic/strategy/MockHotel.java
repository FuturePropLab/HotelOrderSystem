package businesslogic.strategy;

import tools.HotelAddress;
import vo.HotelbriefVO;

public class MockHotel {
  public HotelbriefVO getHotelInfo (String hotel_id){
	  HotelbriefVO hotelVO =new HotelbriefVO();
	  HotelAddress add = new HotelAddress("ÄÏ¾©" , "xinjiekou","xinjiekou","number123");
	  hotelVO.hotelAddress=add;
	  return hotelVO;
	  
  }
}
