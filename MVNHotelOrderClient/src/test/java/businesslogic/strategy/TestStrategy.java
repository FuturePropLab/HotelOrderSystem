package businesslogic.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.OrderInputCalVO;
/**
 * 
 * @author LinWenye
 *
 */
public class TestStrategy {

	@Test
	public void test() {
		
		
		//LocalDateTime time= LocalDateTime.now();原定用LocalDateTime,由于与朱俊毅的冲突，暂改
		OrderInputCalVO orderInput = new OrderInputCalVO(0, "0001", "00", null, null, null, null, 0);
		Strategy str=new Strategy();
		
//		MockDiscount disW = new MockDiscount("web");
//		MockDiscount disH = new MockDiscount("hotel");
//		disW.getSuitableDiscount(orderInput);
//		disW.getSuitableDiscount(orderInput);
		//(以上部分不得不放在正常程序类里面，不需要的时候注释掉）
		
		assertEquals(0,str.CalculateBestStrategy(orderInput).price,0.00001);
	}
	

}
