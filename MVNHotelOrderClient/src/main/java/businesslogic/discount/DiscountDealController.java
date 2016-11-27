package businesslogic.discount;

import java.util.List;

import businesslogicservice.DiscountDealService;
import vo.DiscountSearchVO;
import vo.DiscountVO;

public class DiscountDealController implements DiscountDealService{

	private Discount discount;
	
	public DiscountDealController(){
		discount = new Discount();
	}
	public DiscountVO invalidDiscount(String discount_id) {
		// TODO Auto-generated method stub
		return discount.invalidDiscount(discount_id);
	}

	public List<DiscountVO> checkDiscount(DiscountSearchVO dsvo) {
		// TODO Auto-generated method stub
		return discount.CheckDiscount(dsvo);
	}

}
