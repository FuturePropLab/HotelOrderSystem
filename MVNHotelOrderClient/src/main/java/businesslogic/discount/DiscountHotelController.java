package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import tools.Strategy_hotelType;
import vo.DiscountVO_hotel;

/**
 * 
 * @author LWY
 *
 */
public class DiscountHotelController implements DiscountHotelService {
	
	private static DiscountHotelController discountHotelController;

	private HotelDiscount hotelDiscount;
	
	private List<DiscountVO_hotel> list;//缓存list，不需重复调用Data层
	
	private DiscountHotelController() {
		hotelDiscount = new HotelDiscount();
	}
	
	/**
	 * 单件
	 * @return
	 */
	public static DiscountHotelController getInstance() {
		if (discountHotelController == null) {
			discountHotelController = new DiscountHotelController();
		}
		return discountHotelController;
	}


	public ResultMessage_strategy addHotelDiscount(String hotelID, DiscountVO_hotel dis) {
		// TODO Auto-generated method stub
		
		return hotelDiscount.addHotelDiscount(hotelID, dis);
	}

	public ResultMessageDiscount editHotelDiscount(String discountID, DiscountVO_hotel discountVO_hotel) {
		// TODO Auto-generated method stub
		return hotelDiscount.editHotelDiscount(discountID, discountVO_hotel);
	}

	public List<DiscountVO_hotel> getHotelDiscount(String hotelID) {
		// TODO Auto-generated method stub
		return hotelDiscount.getHotelDiscount(hotelID);
	}

	public ResultMessageDiscount deleteHotelDiscount(String hotelID, String discountID) {
		// TODO Auto-generated method stub
		return hotelDiscount.deleteHotelDiscount(hotelID, discountID);
	}

	public List<DiscountVO_hotel> getHotelDiscount(String hotelID,Strategy_hotelType type) {
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel =  iterator.next();
			if(discountVO_hotel.type==type) res.add(discountVO_hotel);
		}
		return res;
	}

	public ResultMessageDiscount invalidDiscount(String hotelID,String discountID) {
		// TODO Auto-generated method stub
		return null;
	}

//	public DiscountVO_hotel getSingleHotelDiscount(String DiscountID) {
//		// TODO Auto-generated method stub
//		return hotelDiscount.getSingleHotelDiscount(DiscountID);
//	}


	
	
	
	

}
