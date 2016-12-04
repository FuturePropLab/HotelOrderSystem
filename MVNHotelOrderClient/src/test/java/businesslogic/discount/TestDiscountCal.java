package businesslogic.discount;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vo.DiscountVO_hotel;
import vo.OrderInputCalVO;

public class TestDiscountCal {

	@Test
	public void test() {
		
		String discountid="0001";
		DiscountVO_hotel test=new DiscountVO_hotel(null);
		DiscountVO_hotel expect=new DiscountVO_hotel(null);
		expect.discountID="0000";
		expect.discount=9.9;
		List<DiscountVO_hotel> expect2=new ArrayList();
		expect2.add(expect);
		OrderInputCalVO TE=new OrderInputCalVO(0, "0001", "00", null, null, null, null, 0);
//		assertEquals(expect.Discount_id,test.invalidDiscount(discountid).Discount_id);
//		assertEquals(expect2.get(0).Discount_id,test.CheckDiscount(t).get(0).Discount_id);
//		assertEquals(expect2.get(0).Discount_id,test.getSuitableDiscount(TE).get(0).Discount_id);
	}

}
