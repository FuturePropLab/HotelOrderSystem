package businesslogic.discount;

import businesslogicservice.DiscountWebService;
import tools.ResultMessage;
import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_web;

public class DiscountWebController implements DiscountWebService {

	public ResultMessage2 addWebDiscount(DiscountVO_web dis) {
		// TODO Auto-generated method stub
		WebDiscount web=new WebDiscount();
		
		return web.addWebDiscount(dis);
	}

	public DiscountVO_web editWebDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		WebDiscount web=new WebDiscount();
		
		return web.editWebDiscount(Discount_id);
		
	}

	public ResultMessage2 saveDiscount(DiscountVO discount) {
		// TODO Auto-generated method stub
		WebDiscount web=new WebDiscount();
		
		return web.saveDiscount(discount);
		
	}

	public DiscountVO_web getWebDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		WebDiscount web=new WebDiscount();
		return web.getWebDiscount(Discount_id);
	}


}
