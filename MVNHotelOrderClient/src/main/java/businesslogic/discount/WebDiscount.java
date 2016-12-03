package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import po.DiscountPO_web;
import stub.Discount_stub;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import vo.DiscountVO_web;
/**
 * 
 * @author LWY
 * 网站营销人员制作网站策略，增删改查
 */
public class WebDiscount {

	private dataservice.DiscountWebDataService dataService;

	private FactoryDiscount factory= new FactoryDiscount();
	
	public ResultMessage_strategy addWebDiscount(DiscountVO_web dis) {
		// TODO Auto-generated method stub
//		Discount_stub test = new Discount_stub();
//		return test.addWebDiscount(dis);

		
		return dataService.addWebDiscount(factory.conversion(dis));
		
	}

	public ResultMessageDiscount editWebDiscount(DiscountVO_web dis) {
//		Discount_stub test = new Discount_stub();
//
//		return test.editWebDiscount(Discount_id);
		// TODO Auto-generated method stub
		return dataService.editWebDiscount(factory.conversion(dis));
	}

	 public ResultMessageDiscount deleteDiscount(String  discountID) {
//	 // TODO Auto-generated method stub
//	 Discount_stub test=new Discount_stub();
//	
//	 return test.saveDiscount(dis);
		 
		return dataService.deleteWebDiscount(discountID);
	 }

	public List<DiscountVO_web> getWebDiscount() {
		// TODO Auto-generated method stub
//		Discount_stub test = new Discount_stub();
//		return test.getWebDiscount(discount_id);
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		List<DiscountPO_web> list = dataService.getWebDiscount();
		Iterator<DiscountPO_web> iterator = list.iterator();
		while(iterator.hasNext()){
			res.add(factory.converToVO(iterator.next()));
		}
		return res;
	}
	
	/**
	 * 
	 * @param discount_id
	 * @return 将策略设置为无效
	 */
	public ResultMessageDiscount invalidDiscount(String discountID){
		return dataService.invalidDiscount(discountID);
	}
}
