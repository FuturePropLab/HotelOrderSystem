package businesslogic.credit;

import businesslogic.discount.DiscountWebController;
import businesslogic.discount.WebDiscount;

public class MockDiscount {
	
	
	public int[] getLevelCredit() {
		int[] res = new int[5];
		res[0] = 20;
		res[1] = 50;
		res[2] = 80;
		res[3] = 100;
		res[4] = 120;
		return res;
		
	}
}
