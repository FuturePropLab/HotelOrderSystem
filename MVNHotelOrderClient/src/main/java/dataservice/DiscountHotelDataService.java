package dataservice;

import java.util.List;

import po.DiscountPO_hotel;
import tools.ResultMessage_Discount;
import tools.ResultMessage_strategy;
/**
 * 
 * @author L'W'Y
 *
 */
public interface DiscountHotelDataService {
	/**
	 * 
	 * @param hotelID
	 * @param dis
	 * @return 增加酒店促銷策略，數據庫生成ID，傳過去的ID為空
	 */
	public ResultMessage_strategy addHotelDiscount(String hotelID,DiscountPO_hotel dis);
	
	public ResultMessage_Discount editHotelDiscount(String hotelID,DiscountPO_hotel dis);
	
	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) ;
	
	public ResultMessage_Discount deleteHotelDiscount(String hotelID,String discountID);
	
	/**
	 * 将策略设为无效
	 */
	public ResultMessage_Discount invalidDiscount(String discountID) ;
}
