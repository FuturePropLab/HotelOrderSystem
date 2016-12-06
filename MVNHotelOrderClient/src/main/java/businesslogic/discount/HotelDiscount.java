package businesslogic.discount;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import po.DiscountPO_hotel;
import rmi.RemoteHelper;
import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import vo.DiscountVO_hotel;
/**
 * 
 * @author LWY
 * 酒店工作人员对酒店促销策略的增删改查
 */
public class HotelDiscount {

	private dataservice.DiscountHotelDataService dataService;
	
	public  HotelDiscount(){
		this.dataService = RemoteHelper.getInstance().getDiscountHotelDataService();
	}
	
	/**
	 * 增加酒店优惠策略
	 * @param hotel_id
	 * @return 添加成功
	 * @throws RemoteException 
	 */
	
	public ResultMessage_DiscountDetail addHotelDiscount(String hotel_id,DiscountVO_hotel dis) throws RemoteException {
		
		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel(dis);
		discountPO_hotel.setDiscountState(DiscountState.valid);
		return dataService.addHotelDiscount(hotel_id, discountPO_hotel);
		
	}
	/**
	 * 修改编辑酒店优惠策略
	 * @param Discount_id
	 * @return 修改后信息
	 * @throws RemoteException 
	 */
	
	public ResultMessage_Discount editHotelDiscount(String hotel_id,DiscountVO_hotel dis) throws RemoteException{
		DiscountPO_hotel discountPO_hotel = new DiscountPO_hotel(dis);
		return dataService.editHotelDiscount(hotel_id, discountPO_hotel);
		
	}

	/**
	 * 获取酒店全部优惠策略
	 * @param hotel_id
	 * @return
	 * @throws RemoteException 
	 */
	public List<DiscountVO_hotel> getHotelDiscount(String hotel_id) throws RemoteException{
		
		List<DiscountPO_hotel> get = dataService.getHotelDiscount(hotel_id);
		List<DiscountVO_hotel> res = new LinkedList<DiscountVO_hotel>();
		Iterator<DiscountPO_hotel> iterator = get.iterator();
		while(iterator.hasNext()){
			res.add(  new DiscountVO_hotel(  iterator.next() )   );
		}
		return res;
	}
	
	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) throws RemoteException {
		// TODO Auto-generated method stub
		return dataService.deleteHotelDiscount(hotelID, discountID);
	}
 
	/**
	 * 将策略设为无效
	 * @throws RemoteException 
	 */
	public ResultMessage_Discount invalidDiscount(String hotelID, String discountID) throws RemoteException {
		// TODO Auto-generated method stubS
		return dataService.invalidDiscount(discountID);
	}
	
}
