package businesslogic.discount;

import java.util.Date;

public class Double11Discount extends DiscountType{

	@Override
	protected Object typeInfo() {
		return new Date();
	}

}
