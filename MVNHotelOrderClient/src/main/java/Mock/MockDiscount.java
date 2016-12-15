package Mock;

import java.util.LinkedList;
import java.util.List;

import businesslogicservice.DiscountHotelService;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_hotelType;
import vo.DiscountVO_hotel;
import vo.DiscountVO_web;
import vo.OrderInputCalVO;
import vo.StrategyVO_hotel;

/**
 * 
 * @author LWY
 *
 */
public class MockDiscount implements DiscountHotelService{
	private String type;

	// constructor
	public MockDiscount(String str) {
		type = str;
	}

	public List<StrategyVO_hotel> getSuitableDiscount_hotel(OrderInputCalVO orderInput) {

		// 应该根据type 和 orderInput来get
		List<StrategyVO_hotel> res = new LinkedList<StrategyVO_hotel>();
		StrategyVO_hotel dv = new StrategyVO_hotel(null);
		dv.discount = 0.9;
		res.add((StrategyVO_hotel) dv);
		return res;
	}

	public List<DiscountVO_web> getSuitableDiscount_web(OrderInputCalVO orderInput) {

		// 应该根据type 和 orderInput来get
		List<DiscountVO_web> res = new LinkedList<DiscountVO_web>();
		DiscountVO_web dv = new DiscountVO_web();
		dv.discount = 0.9;
		res.add((DiscountVO_web) dv);
		return res;
	}

	public ResultMessage_DiscountDetail addHotelDiscount(String hotel_id, DiscountVO_hotel discountVO_hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Discount editHotelDiscount(String discount_id, DiscountVO_hotel discountVO_hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountVO_hotel> getHotelDiscount(String hotelID, Strategy_hotelType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_Discount invalidDiscount(String hotelID, String discount_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountVO_hotel> getHotelDiscountByType(String hotelID, Strategy_hotelType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiscountVO_hotel> getHotelDiscountByState(String hotelID, Strategy_hotelType type,
			DiscountState discountState) {
		// TODO Auto-generated method stub
		return null;
	}



}
