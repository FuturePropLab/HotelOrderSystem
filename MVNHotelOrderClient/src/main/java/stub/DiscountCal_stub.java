package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogicservice.DiscountGetService;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.OrderInputCalVO;
import vo.OrderInputVO;
import vo.StrategyVO_hotel;
import vo.StrategyVO_web;

public class DiscountCal_stub implements DiscountGetService{

	public List<DiscountVO> getSuitableDiscount(OrderInputCalVO orderInput) {
		// TODO Auto-generated method stub
		List<DiscountVO> dis=new ArrayList();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
		dis.add(dvo);
		
		return dis;
	}

	public DiscountVO invalidDiscount(String discount_id) {
		// TODO Auto-generated method stub
		
		DiscountVO dvo=new DiscountVO();
		dvo.discount=9;
		dvo.Discount_id="0000";
		return dvo;
	}

	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo) {
		// TODO Auto-generated method stub
		List<DiscountVO> dis=new ArrayList();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO dvo=new DiscountVO();
		dvo.discount=9;
		dvo.Discount_id="0000";
		dis.add(dvo);
		
		return dis;
	}

	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) {
		// TODO Auto-generated method stub
		List<StrategyVO_hotel> dis=new ArrayList();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		StrategyVO_hotel dvo=new StrategyVO_hotel(9.9, null, null, null);
		dis.add(dvo);
		
		return dis;
		
		
	}

	public List<StrategyVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) {
		// TODO Auto-generated method stub
		List<StrategyVO_web> dis=new ArrayList();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		
		StrategyVO_web dvo=new StrategyVO_web(2, null);
		dis.add(dvo);
		
		return dis;
	}

}
