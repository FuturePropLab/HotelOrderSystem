package businesslogic.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Date;

import org.junit.Test;

import tools.ResultMessage2;
import tools.ResultMessage_strategy;
import vo.DiscountVO_web;

public class TestWebDiscount {

	@Test
	public void test() {
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
//		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
		ResultMessage2 exp=ResultMessage2.Success;
		WebDiscount test=new WebDiscount();
		String id="0000";
//		DiscountVO_web t=new DiscountVO_web(0, id, 0, t2, t2, 0);
//		t.discount=9.9;
//		assertEquals(exp,test.addWebDiscount(dis));
//		assertSame(dis.district,test.editWebDiscount(id).district);
//		assertEquals(ResultMessage_strategy.Success,test.saveDiscount(t));
		
		
	}

}
/*
public ResultMessage2 addWebDiscount(DiscountVO_web dis) {
// TODO Auto-generated method stub
Discount_stub test=new Discount_stub();
return test.addWebDiscount(dis);

}

public DiscountVO_web editWebDiscount(String Discount_id) {
Discount_stub test=new Discount_stub();


return test.editWebDiscount(Discount_id);
// TODO Auto-generated method stub



}

public ResultMessage2 saveDiscount(DiscountVO discount) {
// TODO Auto-generated method stub
Discount_stub test=new Discount_stub();

return test.saveDiscount(discount);

}
}
*/