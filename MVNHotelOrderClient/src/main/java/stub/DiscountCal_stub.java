package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogicservice.DiscountGetService;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputVO;

public class DiscountCal_stub implements DiscountGetService{

	public List<DiscountVO> getSuitableDiscount(OrderInputVO orderInput) {
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

	public List<DiscountVO_hotel> getSuitableDiscount_hotel(OrderInputVO orderInput) {
		// TODO Auto-generated method stub
		List<DiscountVO_hotel> dis=new ArrayList();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
		dis.add(dvo);
		
		return dis;
		
		
	}

	public List<DiscountVO_web> getSuitableDiscount_web(OrderInputVO orderInput) {
		// TODO Auto-generated method stub
		List<DiscountVO_web> dis=new ArrayList();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		
		DiscountVO_web dvo=new DiscountVO_web(2,"nanjing",9.0,t1,t2,2);
		dis.add(dvo);
		
		return dis;
	}

}
