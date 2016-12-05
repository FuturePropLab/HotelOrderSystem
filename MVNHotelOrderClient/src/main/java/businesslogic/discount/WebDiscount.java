package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import po.DiscountPO_web;
import stub.Discount_stub;
import tools.ResultMessage_Discount;
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
		
		return dataService.addWebDiscount(factory.conversion(dis));
	}

	public ResultMessage_Discount editWebDiscount(DiscountVO_web dis) {
		
		return dataService.editWebDiscount(factory.conversion(dis));
	}

	 public ResultMessage_Discount deleteDiscount(String  discountID) {
		 
		return dataService.deleteWebDiscount(discountID);
	 }

	public List<DiscountVO_web> getWebDiscount() {
		
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
	public ResultMessage_Discount invalidDiscount(String discountID){
		return dataService.invalidDiscount(discountID);
	}
}
