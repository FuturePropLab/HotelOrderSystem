package businesslogic.discount;

import businesslogicservice.DiscountWebService;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import vo.DiscountVO;
import vo.DiscountVO_web;

public class DiscountWebController implements DiscountWebService {

	private WebDiscount web;
	
	private static DiscountWebController discountWebController;
	
	private DiscountWebController (){
		web=new WebDiscount();
	}
	public static DiscountWebController getInstance(){
		if(discountWebController==null) discountWebController=new DiscountWebController();
		return discountWebController;
	}
	
	public ResultMessage_strategy addWebDiscount(DiscountVO_web dis) {
		// TODO Auto-generated method stub
		
		return web.addWebDiscount(dis);
	}

	public ResultMessageDiscount editWebDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		
		return web.editWebDiscount(Discount_id);
		
	}

//	public ResultMessage_strategy saveDiscount(DiscountVO_web discount) {
//		// TODO Auto-generated method stub
//		
//		return web.saveDiscount(discount);
//		
//	}

	public DiscountVO_web getWebDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		return web.getWebDiscount(Discount_id);
	}

	public ResultMessage_strategy deleteDiscount(DiscountVO discount) {
		// TODO Auto-generated method stub
		return null;
	}


}
