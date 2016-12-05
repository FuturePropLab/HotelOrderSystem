package businesslogicservice.impl;

import java.util.Date;

import org.junit.Test;

import businesslogic.discount.WebDiscount;
import tools.ResultMessage_Discount;

public class TestWebDiscount {

	@Test
	public void test() {
		ResultMessage_Discount expect=ResultMessage_Discount.Success;
		WebDiscount test=new WebDiscount();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
//		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
		String discountid="0001";
		
//		assertEquals(expect,test.addWebDiscount(dis));
//		assertEquals(t2,test.editWebDiscount(discountid).enddate);
//		assertEquals(expect,test.saveDiscount(dis));
		
	}

}
/*public ResultMessage2 addWebDiscount(DiscountVO_web dis) {
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

}*/
