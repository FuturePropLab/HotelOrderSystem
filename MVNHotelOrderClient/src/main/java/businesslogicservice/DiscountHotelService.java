package businesslogicservice;

import java.rmi.RemoteException;
import java.util.List;

import tools.DiscountState;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
import tools.Strategy_hotelType;
import vo.DiscountVO_hotel;

public interface DiscountHotelService {
	/**
	 * 
	 * @param hotelID
	 * @param discountVO_hotel
	 * @return 增加酒店策略
	 * @throws RemoteException 
	 */
	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID,DiscountVO_hotel discountVO_hotel) ;
	
	/**
	 * 
	 * @param discountID
	 * @param discountVO_hotel
	 * @return 編輯酒店策略，返回是否成功
	 * @throws RemoteException 
	 */
	public ResultMessage_Discount editHotelDiscount (String discountID,DiscountVO_hotel discountVO_hotel) ;
	
	/**
	 * 
	 * @param hotelID
	 * @param discountID
	 * @return 是否成功刪除
	 * @throws RemoteException 
	 */
	public ResultMessage_Discount deleteHotelDiscount(String hotelID,String discountID) ;
	
	/**
	 * 
	 * @param hotelID
	 * @return 得到所有酒店促銷策略
	 * @throws RemoteException 
	 */
	public List<DiscountVO_hotel> getHotelDiscount (String hotelID) ;
	
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
	 * @throws RemoteException 
	 */
	public ResultMessage_Discount invalidDiscount(String hotelID,String discount_id);
	
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
