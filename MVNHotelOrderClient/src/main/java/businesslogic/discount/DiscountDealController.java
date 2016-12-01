package businesslogic.discount;

import businesslogicservice.DiscountDealService;
import tools.ResultMessageDiscount;

public class DiscountDealController implements DiscountDealService{

	private Discount discount;
	
	private static DiscountDealController dealController;
	
	private DiscountDealController(){
		discount = new Discount();
	}
	
	public static DiscountDealController getInstance(){
		if(dealController==null) dealController=new DiscountDealController();
		return dealController;
	}
	public ResultMessageDiscount invalidDiscount(String discount_id) {
		// TODO Auto-generated method stub
		return discount.invalidDiscount(discount_id);
	}

//	public List<DiscountVO> checkDiscount(DiscountSearchVO dsvo) {
//		// TODO Auto-generated method stub
//		return discount.CheckDiscount(dsvo);
//	}

}
