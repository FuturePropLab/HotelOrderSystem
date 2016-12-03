package dataservice;

import java.util.List;

import po.DiscountPO_hotel;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
/**
 * 
 * @author L'W'Y
 *
 */
public interface DiscountHotelDataService {
	
	public ResultMessage_strategy addHotelDiscount(String hotelID,DiscountPO_hotel dis);
	
	public ResultMessageDiscount editHotelDiscount(String hotelID,DiscountPO_hotel dis);
	
	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) ;
	
	public ResultMessageDiscount deleteHotelDiscount(String hotelID,String discountID);
	
	/**
	 * 将策略设为无效
	 */
	public ResultMessageDiscount invalidDiscount(String discountID) ;
}
