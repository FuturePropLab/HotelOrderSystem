package businesslogic.discount;

import java.util.List;

import businesslogicservice.DiscountHotelService;

import tools.ResultMessage2;
import vo.DiscountVO;
import vo.DiscountVO_hotel;
/**
 * 
 * @author LWY
 *
 */
public class DiscountHotelController implements DiscountHotelService  {

	private HotelDiscount hotelDiscount;
	
	public DiscountHotelController(){
		hotelDiscount= new HotelDiscount();
	}
	
	public ResultMessage2 addHotelDiscount(String hotel_id,DiscountVO_hotel dis) {
		// TODO Auto-generated method stub
		 
		return hotelDiscount.addHotelDiscount(hotel_id, dis);
	}

	public ResultMessage2 editHotelDiscount(String discount_id, DiscountVO_hotel discountVO_hotel) {
		// TODO Auto-generated method stub
		return hotelDiscount.editHotelDiscount(discount_id,discountVO_hotel);
	}


	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		return hotelDiscount.getHotelDiscount(hotel_id);
	}

//	public DiscountVO_hotel getSingleHotelDiscount(String Discount_id) {
//		// TODO Auto-generated method stub
//		return hotelDiscount.getSingleHotelDiscount(Discount_id);
//	}


	
	
	
	

}
