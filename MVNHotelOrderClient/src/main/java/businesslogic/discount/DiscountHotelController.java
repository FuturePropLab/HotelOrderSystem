package businesslogic.discount;

import java.util.List;

import businesslogicservice.DiscountHotelService;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import vo.DiscountVO_hotel;
/**
 * 
 * @author LWY
 *
 */
public class DiscountHotelController implements DiscountHotelService  {
	private static DiscountHotelController discountHotelController;
	
	private DiscountHotelController(){
		hotelDiscount=new HotelDiscount();
	}
	
	public static DiscountHotelController getInstance(){
		if(discountHotelController==null) {
			discountHotelController=new DiscountHotelController();
		}
			return discountHotelController;
	}
	
	private HotelDiscount hotelDiscount;
	
	public ResultMessage_strategy addHotelDiscount(String hotel_id,DiscountVO_hotel dis) {
		// TODO Auto-generated method stub
		 
		return hotelDiscount.addHotelDiscount(hotel_id, dis);
	}

	public ResultMessageDiscount editHotelDiscount(String discount_id, DiscountVO_hotel discountVO_hotel) {
		// TODO Auto-generated method stub
		return hotelDiscount.editHotelDiscount(discount_id,discountVO_hotel);
	}


	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		return hotelDiscount.getHotelDiscount(hotel_id);
	}

	public ResultMessage_strategy deleteHotelDiscount(String hotel_id, String discount_id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public DiscountVO_hotel getSingleHotelDiscount(String Discount_id) {
//		// TODO Auto-generated method stub
//		return hotelDiscount.getSingleHotelDiscount(Discount_id);
//	}


	
	
	
	

}
