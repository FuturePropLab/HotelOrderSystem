package dataservice.discount;

import java.util.List;
import stub.ResultMessage;
import po.DiscountPO;
public interface Discount {
	public ResultMessage add(DiscountPO discount);

	public ResultMessage modify(DiscountPO discount);

	public DiscountPO find(String Discount_id);

	public List<DiscountPO> CheckDiscount(DiscountSearch discountSearch);

}
