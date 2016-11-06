package businesslogic.discount;

import java.util.List;

import businesslogicservice.DiscountHotelService;

import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
/**
 * 
 * @author chenyuyan
 *
 */
public class DiscoountHotelController implements DiscountHotelService  {

	public ResultMessage2 addHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		 HotelDiscount hoteldiscount=new HotelDiscount();
		 
		return hoteldiscount.addHotelDiscount(hotel_id);
	}

	public DiscountVO_hotel editHotelDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		HotelDiscount hoteldiscount=new HotelDiscount();
		return hoteldiscount.editHotelDiscount(Discount_id);
	}

	public DiscountVO_hotel getSingleHotelDiscount(String Discount_id) {
		// TODO Auto-generated method stub
		HotelDiscount hoteldiscount=new HotelDiscount();
		return hoteldiscount.getSingleHotelDiscount(Discount_id);
	}

	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		HotelDiscount hoteldiscount=new HotelDiscount();
		return null;
	}
	
	
	
	

}
