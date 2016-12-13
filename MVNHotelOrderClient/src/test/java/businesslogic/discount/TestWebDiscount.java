package businesslogic.discount;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Test;

import tools.DiscountState;
import tools.ResultMessage_Discount;

public class TestWebDiscount {

	@Test
	public void test() {
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		WebDiscount webDis =new WebDiscount();
		
//		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
		ResultMessage_Discount exp=ResultMessage_Discount.Success;
		WebDiscount test=new WebDiscount();
		String id="0000";
//		DiscountVO_web t=new DiscountVO_web(0, id, 0, t2, t2, 0);
//		t.discount=9.9;
//		assertEquals(exp,test.addWebDiscount(dis));
//		assertSame(dis.district,test.editWebDiscount(id).district);
//		assertEquals(ResultMessage_strategy.Success,test.saveDiscount(t));
		try {
			assertEquals(DiscountState.invalid,webDis.getWebDiscount().get(0).discountState);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testDelete(){
		WebDiscount webDis =new WebDiscount();
		try {
			assertEquals(ResultMessage_Discount.Success, webDis.deleteDiscount("001"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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