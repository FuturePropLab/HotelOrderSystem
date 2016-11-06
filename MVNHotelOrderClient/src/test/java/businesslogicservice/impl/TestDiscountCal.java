package businesslogicservice.impl;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
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
		DiscountSearchVO t=new DiscountSearchVO();
		List<DiscountVO> expect2=new ArrayList();
		expect2.add(expect);
		OrderInputVO TE=new OrderInputVO("0001", "00", Time.valueOf("2016/11/3"), Time.valueOf("2016/11/4"), Time.valueOf("2016/11/5"), RoomType.Double, 1, 1, false);
		assertEquals(expect,test.invalidDiscount(discountid));
		assertEquals(expect2,test.CheckDiscount(t));
		assertEquals(expect,test.getSuitableDiscount(TE));
	}

}
/*

	public DiscountVO invalidDiscount(String discount_id) {
		DiscountCal_stub test=new DiscountCal_stub();
		return test.invalidDiscount(discount_id);
		
}
	
	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo){
		DiscountCal_stub test=new DiscountCal_stub();
		return test.CheckDiscount(dsvo);
	}
	public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput)
*/