package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import tools.DiscountState;
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
	
	private String hotelID;
	
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

/**
 * 得到所有该酒店的促销策略，必须先被调用
 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotelID) {
		
		return hotelDiscount.getHotelDiscount(hotelID);
	}
	
	public ResultMessage_strategy addHotelDiscount(String hotelID, DiscountVO_hotel dis) {
		
		return hotelDiscount.addHotelDiscount(hotelID, dis);
	}

	public ResultMessageDiscount editHotelDiscount(String discountID, DiscountVO_hotel discountVO_hotel) {
		
		return hotelDiscount.editHotelDiscount(discountID, discountVO_hotel);
	}


	public ResultMessageDiscount deleteHotelDiscount(String hotelID, String discountID) {
		
		return hotelDiscount.deleteHotelDiscount(hotelID, discountID);
	}

	public List<DiscountVO_hotel> getHotelDiscountByType(String hotelID,Strategy_hotelType type) {
		
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel =  iterator.next();
			if(discountVO_hotel.type==type) res.add(discountVO_hotel);
		}
		return res;
	}
	/**
	 * 
	 * @param hotelID
	 * @param type
	 * @param discountState
	 * @return 根据策略状态和策略类型来得到符合条件的
	 */
	public List<DiscountVO_hotel> getHotelDiscountByState(String hotelID,Strategy_hotelType type,DiscountState discountState){
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel =  iterator.next();
			if(discountVO_hotel.type==type&&discountVO_hotel.discountState==discountState) res.add(discountVO_hotel);
		}
		return res;
	}
	
	public ResultMessageDiscount invalidDiscount(String hotelID,String discountID) {
		Iterator<DiscountVO_hotel> iterator = list.iterator();
		while (iterator.hasNext()) {
			DiscountVO_hotel discountVO_hotel = (DiscountVO_hotel) iterator.next();
			if(discountVO_hotel.discountID.equals(discountID)){
				discountVO_hotel.discountState=DiscountState.invalid;
			}
		}
		return hotelDiscount.invalidDiscount(hotelID, discountID);
	}


	
	
	
	

}
