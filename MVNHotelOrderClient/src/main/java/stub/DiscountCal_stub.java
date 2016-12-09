//package stub;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import businesslogic.strategy.StrategyGetService;
//import vo.DiscountVO_hotel;
//import vo.DiscountVO_web;
//import vo.OrderInputCalVO;
//import vo.OrderInputVO;
//import vo.StrategyVO_hotel;
//
//public class DiscountCal_stub implements StrategyGetService{
//
//	public List<DiscountVO_hotel> getSuitableDiscount(OrderInputVO orderInput) {
//		// TODO Auto-generated method stub
//		List<DiscountVO_hotel> dis=new ArrayList();
//		Date t1=new Date(2016,9,1);
//		Date t2=new Date(2016,9,2);
//		DiscountVO_hotel dvo=new DiscountVO_hotel(null);
//		dis.add(dvo);
//		
//		return dis;
//	}
//
//	public DiscountVO_hotel invalidDiscount(String discount_id) {
//		// TODO Auto-generated method stub
//		
//		DiscountVO_hotel dvo=new DiscountVO_hotel(null);
//		dvo.discount=9;
//		dvo.discountID="0000";
//		return dvo;
//	}
//
////	public List<DiscountVO> CheckDiscount(DiscountSearchVO dsvo) {
////		// TODO Auto-generated method stub
////		List<DiscountVO> dis=new ArrayList();
////		Date t1=new Date(2016,9,1);
////		Date t2=new Date(2016,9,2);
////		DiscountVO dvo=new DiscountVO();
////		dvo.discount=9;
////		dvo.Discount_id="0000";
////		dis.add(dvo);
////		
////		return dis;
////	}
//
//	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) {
//		// TODO Auto-generated method stub
//		List<StrategyVO_hotel> dis=new ArrayList();
//		Date t1=new Date(2016,9,1);
//		Date t2=new Date(2016,9,2);
//		StrategyVO_hotel dvo=new StrategyVO_hotel(null);
//		dis.add(dvo);
//		
//		return dis;
//		
//		
//	}
//
//	public List<DiscountVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) {
//		// TODO Auto-generated method stub
//		List<DiscountVO_web> dis=new ArrayList();
//		Date t1=new Date(2016,9,1);
//		Date t2=new Date(2016,9,2);
//		
//		DiscountVO_web dvo=new DiscountVO_web();
//		dis.add(dvo);
//		
//		return dis;
//	}
//
//}
