package data.discount;
import java.util.LinkedList;
import java.util.List;

import dataservice.discount.Discount;
import dataservice.discount.DiscountSearch;
import po.DiscountPO;
import tools.ResultMessage;
public class DiscountServiceImpl_stub implements Discount{

	@Override
	public ResultMessage add(DiscountPO discount) {
		// TODO Auto-generated method stub
		if(discount!=null) return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage modify(DiscountPO discount) {
		// TODO Auto-generated method stub
		if(discount!=null) return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}

	@Override
	public DiscountPO find(String Discount_id) {
		// TODO Auto-generated method stub
		DiscountPO disPO=new DiscountPO();
		return disPO;
	}

	@Override
	public List<DiscountPO> CheckDiscount(DiscountSearch discountSearch) {
		// TODO Auto-generated method stub
		List<DiscountPO> list=new LinkedList<>();
		return list;
	}
	
}
