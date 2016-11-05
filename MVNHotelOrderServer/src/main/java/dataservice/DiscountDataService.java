package dataservice;


import java.util.List;

import po.DiscountPO;
import tools.DiscountSearch;
import tools.ResultMessage;
public interface DiscountDataService {
	public ResultMessage add(DiscountPO discount);

	public ResultMessage modify(DiscountPO discount);

	public DiscountPO find(String Discount_id);

	public List<DiscountPO> CheckDiscount(DiscountSearch discountSearch);

}
