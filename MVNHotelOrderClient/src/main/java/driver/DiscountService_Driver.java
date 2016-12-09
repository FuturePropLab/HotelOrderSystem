//package driver;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import tools.ResultMessage_Discount;
//import vo.DiscountVO_hotel;
//
//public class DiscountService_Driver {
//	public static void main(String[] args) {
//		stub.Discount_stub dis = new stub.Discount_stub();
//		DiscountService_Driver driver = new DiscountService_Driver();
//		driver.drive(dis);
//	}
//
//	public void drive(stub.Discount_stub dis) {
//		DiscountVO_hotel disvo = new DiscountVO_hotel(null);
//		disvo.discount = 7;
//		disvo.discountID = "0050";
//		
//		
//		ResultMessage_Discount re;
//		re=dis.addHotelDiscount("005");
//		System.out.println(disvo.discount);
//		
////		disvo = dis.getSingleHotelDiscount("001");
//		System.out.println(disvo.discountID);
//		
//		List<DiscountVO_hotel> list = new LinkedList<DiscountVO_hotel>();
//		
//		list=dis.getHotelDiscount("330");
//		System.out.println(list.get(0).discountID);
//		
////		disvo = dis.editHotelDiscount("000", null);
//		System.out.println(disvo.discountID);
//		
////		ResultMessage_strategy res = dis.saveDiscount(disvo);
////		if (res != ResultMessage_strategy.Success)
////			System.out.println("Success");
//////		else
//////			System.out.println("False");
////		
////		
////		DiscountVO_web webvo=new DiscountVO_web(2,"nanjing",9.0,Time.valueOf("2016/11/3"), Time.valueOf("2016/11/4"),2);
////		
////		res=dis. addWebDiscount(webvo);
////		if (res != ResultMessage_strategy.Success)
////			System.out.println("Success");
////		else
////			System.out.println("False");
//		
//	}
//}
