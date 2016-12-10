package businesslogic.credit;

import businesslogic.discount.DiscountWebController;
import businesslogic.discount.WebDiscount;

public class MockDiscount extends WebDiscount {
	public int[] getLevelCredit() {
		int[] res = new int[2];
		res[0] = 20;
		res[1] = 40;
		return res;
		
	}
}
