package dataservice;

import java.util.List;

import po.DiscountPO_hotel;
import tools.ResultMessage2;
import tools.ResultMessage_strategy;
import vo.DiscountVO_hotel;
/**
 * 
 * @author L'W'Y
 *
 */
public interface DiscountHotelDataService {
	
	public ResultMessage_strategy addHotelDiscount(String hotel_id,DiscountPO_hotel dis);
	
	public ResultMessage_strategy editHotelDiscount(String hotel_id,String discount_id, DiscountPO_hotel dis);
	
	public List<DiscountPO_hotel> getHotelDiscount(String hotel_id) ;
	
	public ResultMessage_strategy deleteHotelDiscount(String hotel_id,String discount_id);
}
