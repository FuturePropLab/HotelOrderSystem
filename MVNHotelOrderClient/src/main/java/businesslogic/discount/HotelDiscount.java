package businesslogic.discount;

import java.util.List;

import po.DiscountPO_hotel;
import stub.Discount_stub;
import tools.DiscountState;
import tools.ResultMessageDiscount;
import tools.ResultMessage_strategy;
import vo.DiscountVO_hotel;

public class HotelDiscount extends Discount{

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
	
	public ResultMessageDiscount editHotelDiscount(String Discount_id,DiscountVO_hotel dis){
		
		Discount_stub test=new Discount_stub();
		return test.editHotelDiscount(Discount_id, dis);
		
	}
	/**
	 * 获取酒店优惠策略
	 * @param Discount_id
	 * @return
	 */
	/**
	 * 获取酒店全部优惠策略
	 * @param hotel_id
	 * @return
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id){
		
		Discount_stub test=new Discount_stub();
		return test.getHotelDiscount(hotel_id);
	
	}
	
	
//	public DiscountVO_hotel getSingleHotelDiscount(String Discount_id){
//		Discount_stub test=new Discount_stub();
//		return test.getSingleHotelDiscount(Discount_id);
//				
//		
//	}
	
}
