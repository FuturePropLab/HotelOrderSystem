package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DiscountPO_hotel;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;
/**
 * 
 * @author L'W'Y
 *
 */
public interface DiscountHotelDataService extends Remote{
	/**
	 * 
	 * @param hotelID
	 * @param dis
	 * @return 增加酒店促銷策略，數據庫生成ID，傳過去的ID為空
	 */
	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID,DiscountPO_hotel dis)throws RemoteException;
	
	public ResultMessage_Discount editHotelDiscount(String hotelID,DiscountPO_hotel dis)throws RemoteException;
	
	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) throws RemoteException;
	
	public ResultMessage_Discount deleteHotelDiscount(String hotelID,String discountID)throws RemoteException;	
	/**
	 * 将策略设为无效
	 */
	public ResultMessage_Discount invalidDiscount(String discountID)throws RemoteException ;
}
