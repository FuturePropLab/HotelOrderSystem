package businesslogic.hotel;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.HotelDiscount;
import tools.ResultMessage_Discount;
import tools.Strategy_hotelType;
import vo.DiscountVO_hotel;



public class MockHotelDiscount implements getDiscountInfo{


	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		LocalDate date1 = LocalDate.of(2015, 4, 1);
		LocalDate date2 = LocalDate.of(2015, 5, 1);
		ResultMessage_Discount expect=ResultMessage_Discount.Fail;
			
//		String discountid="0001";
//		HotelDiscount temp=new HotelDiscount();
		DiscountVO_hotel discountVO=new DiscountVO_hotel(8.8,date1,date2,"aa",false,Strategy_hotelType.Birthday,null);
		List<DiscountVO_hotel> list=new LinkedList();
		list.add(discountVO);
		return list;
	}

}
