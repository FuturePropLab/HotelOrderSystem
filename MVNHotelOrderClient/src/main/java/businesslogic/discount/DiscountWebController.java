package businesslogic.discount;

import java.util.List;

import businesslogicservice.DiscountWebService;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
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

	public ResultMessageDiscount editWebDiscount(DiscountVO_web dis) {
		// TODO Auto-generated method stub
		
		return web.editWebDiscount(dis);
		
	}

//	public ResultMessage_strategy saveDiscount(DiscountVO_web discount) {
//		// TODO Auto-generated method stub
//		
//		return web.saveDiscount(discount);
//		
//	}

	public List<DiscountVO_web> getWebDiscount() {
		// TODO Auto-generated method stub
		return web.getWebDiscount();
	}

	public ResultMessageDiscount deleteDiscount(String discountID) {
		// TODO Auto-generated method stub
		return web.deleteDiscount(discountID);
	}




}
