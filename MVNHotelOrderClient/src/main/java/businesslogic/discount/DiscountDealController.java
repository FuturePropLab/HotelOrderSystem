package businesslogic.discount;

import businesslogicservice.DiscountDealService;
import tools.ResultMessage2;

public class DiscountDealController implements DiscountDealService{

	private Discount discount;
	
	public DiscountDealController(){
		discount = new Discount();
	}
	public ResultMessage2 invalidDiscount(String discount_id) {
		// TODO Auto-generated method stub
		return discount.invalidDiscount(discount_id);
	}

//	public List<DiscountVO> checkDiscount(DiscountSearchVO dsvo) {
//		// TODO Auto-generated method stub
//		return discount.CheckDiscount(dsvo);
//	}

}
