package businesslogic.discount;

import java.util.Date;

import org.junit.Test;

import tools.ResultMessage_Discount;

public class TestHotelDiscount {

	@Test
	public void test() {
		ResultMessage_Discount re=ResultMessage_Discount.Success;
		HotelDiscount test=new HotelDiscount();
		String hotel_id="0000";
		String discount_id="0000";
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
//		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
//		dvo.Discount_id=discount_id;
//		List<DiscountVO_hotel> list=new LinkedList();
//		list.add(dvo);
////		
//		assertEquals(re,test.addHotelDiscount(hotel_id));
//		assertEquals(dvo.EndDate,test.editHotelDiscount(discount_id).EndDate);
//		assertEquals(dvo.Discount_id,test.getSingleHotelDiscount(discount_id).Discount_id);
//		assertEquals(list.get(0).startDate,test.getHotelDiscount(hotel_id).get(0).startDate);
	}

}
