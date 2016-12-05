package businesslogic.discount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import po.DiscountPO_hotel;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_strategy;
import vo.DiscountVO_hotel;
/**
 * 
 * @author LWY
 * 酒店工作人员对酒店促销策略的增删改查
 */
public class HotelDiscount {

	private dataservice.DiscountHotelDataService dataService;
	
	/**
	 * 增加酒店优惠策略
	 * @param hotel_id
	 * @return 添加成功
	 */
	
	public ResultMessage_strategy addHotelDiscount(String hotel_id,DiscountVO_hotel dis) {
		
		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel(dis);
		discountPO_hotel.setDiscountState(DiscountState.valid);
		return dataService.addHotelDiscount(hotel_id, discountPO_hotel);
		
	}
	/**
	 * 修改编辑酒店优惠策略
	 * @param Discount_id
	 * @return 修改后信息
	 */
	
	public ResultMessage_Discount editHotelDiscount(String hotel_id,DiscountVO_hotel dis){
		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel(dis);
		return dataService.editHotelDiscount(hotel_id, discountPO_hotel);
		
	}

	/**
	 * 获取酒店全部优惠策略
	 * @param hotel_id
	 * @return
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id){
		
		List<DiscountPO_hotel> get = dataService.getHotelDiscount(hotel_id);
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		Iterator<DiscountPO_hotel> iterator = get.iterator();
		while(iterator.hasNext()){
			res.add(  new DiscountVO_hotel(  iterator.next() )   );
		}
		return res;
	}
	
	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) {
		// TODO Auto-generated method stub
		return dataService.deleteHotelDiscount(hotelID, discountID);
	}
 
	/**
	 * 将策略设为无效
	 */
	public ResultMessage_Discount invalidDiscount(String hotelID, String discountID) {
		// TODO Auto-generated method stubS
		return dataService.invalidDiscount(discountID);
	}
	
}
