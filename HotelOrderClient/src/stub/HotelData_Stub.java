package stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.HotelDataService;
import po.HotelInfoPO;
import po.HotelRoomInfoPO;
import po.SearchHotel;
import tools.ResultMessage2;
import tools.Star;

public class HotelData_Stub implements HotelDataService{

	@Override
	public ResultMessage2 addHotelInfo(HotelInfoPO hotelInfo) {
		// TODO Auto-generated method stub
		return ResultMessage2.fail;
	}

	@Override
	public ResultMessage2 modifyHotelInfo(HotelInfoPO hotelInfoPO) {
		// TODO Auto-generated method stub
		return ResultMessage2.fail;
	}

	@Override
	public HotelInfoPO getHotelInfo(String hotel_id) {
		// TODO Auto-generated method stub
		HotelInfoPO hotelinfo=new HotelInfoPO();
		hotelinfo.setComeAddr("xinjiekou");
		hotelinfo.setFacility("room1");
		hotelinfo.setGrade("good");
		hotelinfo.setHotelAddress("nanjing");
		hotelinfo.setHotelID("100");
		hotelinfo.setHotelName("ronghua");
		
		
		HotelRoomInfoPO hotelroom=new HotelRoomInfoPO();
		hotelroom.setHotelID("100");
		hotelroom.setHotelName("ronghua");
		
		
		hotelinfo.setHotelRoomPO(hotelroom);
		
		hotelinfo.setIntroduction("good");
		hotelinfo.setStar(Star.five);
		return hotelinfo;
	}

	@Override
	public List<HotelInfoPO> searchHotelList(SearchHotel searchhotel) {
		// TODO Auto-generated method stub
		HotelInfoPO hotelinfo=new HotelInfoPO();
		hotelinfo.setComeAddr("xinjiekou");
		hotelinfo.setFacility("room1");
		hotelinfo.setGrade("good");
		hotelinfo.setHotelAddress("nanjing");
		hotelinfo.setHotelID("100");
		hotelinfo.setHotelName("ronghua");
		
		
		HotelRoomInfoPO hotelroom=new HotelRoomInfoPO();
		hotelroom.setHotelID("100");
		hotelroom.setHotelName("ronghua");
		
		
		hotelinfo.setHotelRoomPO(hotelroom);
		
		hotelinfo.setIntroduction("good");
		hotelinfo.setStar(Star.five);
		
		List<HotelInfoPO> hotellist=new ArrayList<HotelInfoPO>();
		 hotellist.add(hotelinfo);
		
		return  hotellist;
	}

}
