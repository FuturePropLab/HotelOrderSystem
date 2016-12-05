package dataservice.datahelper;

import java.rmi.RemoteException;
import java.util.List;

import po.DiscountPO_hotel;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;

public interface DiscountHotelDataHelper {
	
	/***
	 * 
	 * @param hotelID
	 * @param dis
	 * @return
	 */
	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID,DiscountPO_hotel dis);
	
	
	/**
	 * 
	 * @param hotelID
	 * @param dis
	 * @return
	 */
	public ResultMessage_Discount modifyHotelDiscount(String hotelID,DiscountPO_hotel dis);
	
	/**
	 * 
	 * @param hotelID
	 * @return
	 */
	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) ;
	
	
	/**
	 * 
	 * @param hotelID
	 * @param discountID
	 * @return
	 */
	public ResultMessage_Discount deleteHotelDiscount(String hotelID,String discountID);	
	
	
	/**
	 * 
	 * @param discountID
	 * @return
	 */
	public ResultMessage_Discount invalidDiscount(String discountID);
}
