package businesslogicservice;

import java.util.List;

import tools.DiscountState;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import tools.Strategy_hotelType;
import vo.DiscountVO_hotel;

public interface DiscountHotelService {
	/**
	 * 
	 * @param hotelID
	 * @param discountVO_hotel
	 * @return 增加酒店策略
	 */
	public ResultMessage_strategy addHotelDiscount(String hotelID,DiscountVO_hotel discountVO_hotel);
	
	/**
	 * 
	 * @param discountID
	 * @param discountVO_hotel
	 * @return 編輯酒店策略，返回是否成功
	 */
	public ResultMessageDiscount editHotelDiscount (String discountID,DiscountVO_hotel discountVO_hotel);
	
	/**
	 * 
	 * @param hotelID
	 * @param discountID
	 * @return 是否成功刪除
	 */
	public ResultMessageDiscount deleteHotelDiscount(String hotelID,String discountID);
	
	/**
	 * 
	 * @param hotelID
	 * @return 得到所有酒店促銷策略
	 */
	public List<DiscountVO_hotel> getHotelDiscount (String hotelID);
	
	/**
	 * 
	 * @param hotelID
	 * @param type
	 * @return 根據類型得到酒店促銷策略
	 */
	public List<DiscountVO_hotel> getHotelDiscountByType(String hotelID,Strategy_hotelType type) ;
	
	/**
	 * 
	 * @param discount_id
	 * @return 将策略设置为无效
	 */
	public ResultMessageDiscount invalidDiscount(String hotelID,String discount_id);
	
	/**
	 * 
	 * @param hotelID
	 * @param type
	 * @param discountState
	 * @return 根据策略状态和策略类型来得到符合条件的
	 */
	public List<DiscountVO_hotel> getHotelDiscountByState(String hotelID,Strategy_hotelType type,DiscountState discountState);
	
//	public DiscountVO_hotel getSingleHotelDiscount (String discountID);
}
