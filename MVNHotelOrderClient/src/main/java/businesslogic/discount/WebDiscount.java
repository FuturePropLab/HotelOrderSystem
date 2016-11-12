package businesslogic.discount;

import stub.Discount_stub;
import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_web;

public class WebDiscount extends Discount{

	

public ResultMessage2 addWebDiscount(DiscountVO_web dis) {
	// TODO Auto-generated method stub
	Discount_stub test=new Discount_stub();
	return test.addWebDiscount(dis);
	
}

public DiscountVO_web editWebDiscount(String Discount_id) {
	Discount_stub test=new Discount_stub();
	
	
	return test.editWebDiscount(Discount_id);
	// TODO Auto-generated method stub
	

	
}

public ResultMessage2 saveDiscount(DiscountVO discount) {
	// TODO Auto-generated method stub
	Discount_stub test=new Discount_stub();
	
	return test.saveDiscount(discount);
	
}
}
