package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountWebService;
import tools.DiscountState;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import tools.Strategy_webType;
import vo.DiscountVO_web;

/**
 * 
 * @author LWY
 *
 */
public class DiscountWebController implements DiscountWebService {

	private WebDiscount web;
	
	private static DiscountWebController discountWebController;
	
	private List<DiscountVO_web> list;
	
	private DiscountWebController (){
		web=new WebDiscount();
	}
	
	/**
	 * 單件
	 * @return
	 */
	public static DiscountWebController getInstance(){
		if(discountWebController==null) discountWebController=new DiscountWebController();
		return discountWebController;
	}
	
	public ResultMessage_strategy addWebDiscount(DiscountVO_web dis) {
		
		return web.addWebDiscount(dis);
	}

	public ResultMessageDiscount editWebDiscount(DiscountVO_web dis) {
		
		return web.editWebDiscount(dis);
		
	}


	public List<DiscountVO_web> getWebDiscount() {
		// TODO Auto-generated method stub
		List<DiscountVO_web> res = web.getWebDiscount();
		list = res;
		return res;
	}

	public ResultMessageDiscount deleteDiscount(String discountID) {
		// TODO Auto-generated method stub
		return web.deleteDiscount(discountID);
	}

	public List<DiscountVO_web> getWebDiscount(Strategy_webType type) {
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		Iterator<DiscountVO_web> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_web discountVO_web = (DiscountVO_web) iterator.next();
			if(discountVO_web.type==type){
				res.add(discountVO_web);
			}
		}
		return res;
	}

	/**
	 * 
	 * @param type
	 * @param discountState
	 * @return 根据策略状态和策略类型来得到符合条件的
	 */
	public List<DiscountVO_web> getWebDiscount(Strategy_webType type,DiscountState discountState) {
		
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		Iterator<DiscountVO_web> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_web discountVO_web = (DiscountVO_web) iterator.next();
			if(discountVO_web.type==type&&discountVO_web.discountState==discountState){
				res.add(discountVO_web);
			}
		}
		return res;
	}
	
	
	public ResultMessageDiscount invalidDiscount(String discountID) {
		
		return web.invalidDiscount(discountID);
	}




}
