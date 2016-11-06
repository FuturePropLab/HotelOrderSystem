package businesslogic.hotel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import businesslogic.discount.Discount;
import businesslogic.discount.HotelDiscount;
import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_hotel;


public class MockHotelDiscount extends Discount implements getDiscountInfo{

	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		Date t1=new Date(2016,9,1);
		Date t2=new Date(2016,9,2);
		ResultMessage2 expect=ResultMessage2.fail;
		
		String discountid="0001";
		HotelDiscount temp=new HotelDiscount();
		DiscountVO_hotel expect2=new DiscountVO_hotel("0000",9.9,t1,t2);
		List<DiscountVO_hotel> list=new LinkedList();
		list.add(expect2);
		return list;
	}

}
