package stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businesslogicservice.DiscountDealService;
import vo.DiscountSearchVO;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
import vo.OrderInputVO;

public class DiscountCal_stub implements DiscountDealService{

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
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
		return dvo;
	}

	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo) {
		// TODO Auto-generated method stub
		List<DiscountVO> dis=new ArrayList();
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
		dis.add(dvo);
		
		return dis;
	}

}
