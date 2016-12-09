//package stub;
//
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
//import businesslogicservice.DiscountHotelService;
//import businesslogicservice.DiscountWebService;
//import tools.DiscountState;
//import tools.ResultMessage_Discount;
//import tools.ResultMessage_DiscountDetail;
//import tools.Strategy_hotelType;
//import tools.Strategy_webType;
//import vo.DiscountVO_hotel;
//import vo.DiscountVO_web;
//
//public class Discount_stub implements DiscountWebService,DiscountHotelService{
//
//	
//	public ResultMessage_Discount addHotelDiscount(String hotel_id) {
//		// TODO Auto-generated method stub
////		DiscountVO dvo=new DiscountVO();
////		dvo.Discount_id=hotel_id;
//		return ResultMessage_Discount.Success;
//	}
//
//	
////	public DiscountVO_hotel getSingleHotelDiscount(String discount_id) {
////		// TODO Auto-generated method stub
////		Date t1=new Date(2016,9,1);
////		Date t2=new Date(2016,9,2);
////		DiscountVO_hotel dvo=new DiscountVO_hotel("0000",9.9,t1,t2);
////		dvo.Discount_id=discount_id;
////		return dvo;
////	}
//
//	
//	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
//		// TODO Auto-generated method stub
//		
//		Date t1=new Date(2016,9,1);
//		Date t2=new Date(2016,9,2);
//		DiscountVO_hotel dvo=new DiscountVO_hotel(null);
//		List<DiscountVO_hotel> list=new LinkedList();
//		list.add(dvo);
//		return list;
//		
//	}
//
//
//	
//	public ResultMessage_Discount editHotelDiscount(String discount_id,DiscountVO_hotel dis) {
//		// TODO Auto-generated method stub
//		LocalDate t1=LocalDate.of(2016,9,01);
//		LocalDate t2=LocalDate.of(2016,9,02);
//		DiscountVO_hotel dvo= new DiscountVO_hotel(null);
//		dvo.discountID=discount_id;
//		return ResultMessage_Discount.Success;
//	}
//
////	
////	public ResultMessage_strategy saveDiscount(DiscountVO_hotel disvo) {
////		// TODO Auto-generated method stub
////		if(disvo!=null)return ResultMessage_strategy.Success;
////		else
////		return ResultMessage_strategy.Conflict;
////	}
//
//
//	/*public DiscountVO getAHotelDiscount(String Discount_id) {
//		// TODO Auto-generated method stub
//		DiscountVO dis=new DiscountVO();
//		if(dis.Discount_id=="0000"){
//			dis.Discount_id="0000";
//			dis.discount=6;
//			return dis;
//		}
//		else return dis;
//		
//	}*/
//
//
//	public ResultMessage_DiscountDetail addWebDiscount(DiscountVO_web dis) {
//		// TODO Auto-generated method stub
//		if(dis!=null)return ResultMessage_DiscountDetail.Success;
//		else
//			return ResultMessage_DiscountDetail.Existed;
//		
//	}
//
//
//
//	public ResultMessage_Discount editWebDiscount(String Discount_id) {
//		// TODO Auto-generated method stub
////		Date t1=new Date(2016,9,1);
////		Date t2=new Date(2016,9,2);
////		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
//		
//		return ResultMessage_Discount.Success;
//	}
//
//
//	public DiscountVO_web getWebDiscount(String Discount_id) {
//		// TODO Auto-generated method stub
//		Date t1=new Date(2016,9,1);
//		Date t2=new Date(2016,9,2);
////		DiscountVO_web dis=new DiscountVO_web(10,"新街口",9.9,t1,t2,10);
//		DiscountVO_web dis = new DiscountVO_web();
//		return dis;
//	}
//
//
//
//
//	public ResultMessage_DiscountDetail addHotelDiscount(String hotel_id, DiscountVO_hotel discountVO_hotel) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
////	public ResultMessage_strategy deleteDiscount(DiscountVO discount) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//
//	public ResultMessage_Discount editWebDiscount(DiscountVO_web dis) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public List<DiscountVO_web> getWebDiscount() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public ResultMessage_Discount deleteDiscount(String discountID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public List<DiscountVO_hotel> getHotelDiscountByType(String hotelID, Strategy_hotelType type) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public ResultMessage_Discount invalidDiscount(String hotelID, String discount_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public List<DiscountVO_hotel> getHotelDiscountByState(String hotelID, Strategy_hotelType type,
//			DiscountState discountState) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public List<DiscountVO_web> getWebDiscount(Strategy_webType type) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public ResultMessage_Discount invalidDiscount(String discount_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//}
