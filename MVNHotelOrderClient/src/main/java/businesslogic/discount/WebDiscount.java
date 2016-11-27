package businesslogic.discount;

import stub.Discount_stub;
import tools.ResultMessage2;
import tools.ResultMessage_strategy;
import vo.DiscountVO;
import vo.DiscountVO_web;

public class WebDiscount extends Discount{

private dataservice.DiscountWebDataService dataService;


public ResultMessage_strategy addWebDiscount(DiscountVO_web dis) {
	// TODO Auto-generated method stub
	Discount_stub test=new Discount_stub();
	return test.addWebDiscount(dis);
	
}

public DiscountVO_web editWebDiscount(String Discount_id) {
	Discount_stub test=new Discount_stub();
	
	
	return test.editWebDiscount(Discount_id);
	// TODO Auto-generated method stub
	

	
}

//public ResultMessage_strategy saveDiscount(DiscountVO_web dis) {
//	// TODO Auto-generated method stub
//	Discount_stub test=new Discount_stub();
//	
//	return test.saveDiscount(dis);
//	
//}

public DiscountVO_web getWebDiscount(String discount_id) {
	// TODO Auto-generated method stub
	Discount_stub test=new Discount_stub();
	return test.getWebDiscount(discount_id);
}

}
