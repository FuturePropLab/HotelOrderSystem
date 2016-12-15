package businesslogic.discount;
import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import businesslogic.strategy.Strategy;
import vo.DiscountVO_hotel;
import vo.OrderInputCalVO;

public class TestDiscountCal {

	@Test
	public void test() {
		
		/*String discountid="0001";
		DiscountVO_hotel test=new DiscountVO_hotel(null);
		DiscountVO_hotel expect=new DiscountVO_hotel(null);
		expect.discountID="0000";
		expect.discount=9.9;
		List<DiscountVO_hotel> expect2=new ArrayList();
		expect2.add(expect);*/
		LocalDate date1 = LocalDate.of(2016, 1, 1);
		LocalDate date2 = LocalDate.of(2016, 1, 2);
		OrderInputCalVO TE=new OrderInputCalVO(0, "0001", "00", date1,date2, date2, null, 0);
		Strategy test =new Strategy();
		try {
			assertEquals("002",test.CalculateBestStrategy(TE).web.discountID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		assertEquals(expect.Discount_id,test.invalidDiscount(discountid).Discount_id);
//		assertEquals(expect2.get(0).Discount_id,test.CheckDiscount(t).get(0).Discount_id);
//		assertEquals(expect2.get(0).Discount_id,test.getSuitableDiscount(TE).get(0).Discount_id);
	}

}
