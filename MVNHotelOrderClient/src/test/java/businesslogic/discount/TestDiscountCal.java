package businesslogic.discount;
import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import businesslogic.discount.Discount;
import stub.DiscountCal_stub;
import tools.RoomType;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.OrderInputVO;

public class TestDiscountCal {

	@Test
	public void test() {
		
		String discountid="0001";
		Discount test=new Discount();
		DiscountVO expect=new DiscountVO();
		expect.Discount_id="0000";
		expect.discount=9.9;
		DiscountSearchVO t=new DiscountSearchVO();
		List<DiscountVO> expect2=new ArrayList();
		expect2.add(expect);
		OrderInputVO TE=new OrderInputVO("0001", "00", new Time(0), new Time(0), new Time(0), RoomType.Double, 1, 1, false);
		assertEquals(expect.Discount_id,test.invalidDiscount(discountid).Discount_id);
		assertEquals(expect2.get(0).Discount_id,test.CheckDiscount(t).get(0).Discount_id);
		assertEquals(expect2.get(0).Discount_id,test.getSuitableDiscount(TE).get(0).Discount_id);
	}

}
