package driver;

import java.util.LinkedList;
import java.util.List;

import tools.ResultMessage;
import vo.DiscountVO;

public class DiscountService_Driver {
	public static void main(String[] args) {
		stub.Discount_stub dis = new stub.Discount_stub();
		DiscountService_Driver driver = new DiscountService_Driver();
		driver.drive(dis);
	}

	public void drive(stub.Discount_stub dis) {
		DiscountVO disvo = new DiscountVO();
		disvo.discount = 7;
		disvo.Discount_id = "0050";
		disvo = dis.addHotelDiscount("005");
		System.out.println(disvo.discount);
		
		disvo = dis.getSingleHotelDiscount("001");
		System.out.println(disvo.Discount_id);
		
		List<DiscountVO> list = new LinkedList<DiscountVO>();
		list = dis.getHotelDiscount("001");
		System.out.println(list.get(0).Discount_id);
		
		disvo = dis.editHotelDiscount("000");
		System.out.println(disvo.Discount_id);
		
		ResultMessage res = dis.saveDiscount(disvo);
		if (res != ResultMessage.Exist)
			System.out.println("Success");
		else
			System.out.println("False");
		
		disvo=dis.getAHotelDiscount("000");
		System.out.println(disvo.discount);
		
		res=dis. addWebDiscount(disvo);
		if (res != ResultMessage.Exist)
			System.out.println("Success");
		else
			System.out.println("False");
		
	}
}
