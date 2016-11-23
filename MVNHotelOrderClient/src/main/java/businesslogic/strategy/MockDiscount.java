package businesslogic.strategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.Discount;
import businesslogicservice.DiscountGetService;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;
/**
 * 
 * @author LWY
 *
 */
public class MockDiscount implements DiscountGetService {
	private String type;

	//constructor
	public MockDiscount(String str) {
		type = str;
	}

	
	public List<DiscountVO_hotel> getSuitableDiscount_hotel(OrderInputVO orderInput) {
	
		// 应该根据type 和 orderInput来get
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		DiscountVO dv = new DiscountVO_hotel(type, 0, null, null);
		dv.discount = 0.9;
		dv.Discount_id = "0001";
		res.add((DiscountVO_hotel) dv);
		return res;
	}

	public List<DiscountVO_web> getSuitableDiscount_web(OrderInputVO orderInput) {
		
		// 应该根据type 和 orderInput来get
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		DiscountVO dv = new DiscountVO_web(0, type, 0, null, null, 0);
		dv.discount = 0.9;
		dv.Discount_id = "0001";
		res.add((DiscountVO_web) dv);
		return res;
	}
	
//	
//	// 无须调用的方法
//	public DiscountVO invalidDiscount(String discount_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
