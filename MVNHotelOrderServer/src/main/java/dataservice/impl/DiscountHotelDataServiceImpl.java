package dataservice.impl;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.DiscountHotelDataService;
import dataservice.datahelper.DiscountHotelDataHelper;
import po.DiscountPO_hotel;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;

public class DiscountHotelDataServiceImpl implements DiscountHotelDataService {
	
	private  DiscountHotelDataHelper discountHotelDataHelper;
	
	public DiscountHotelDataServiceImpl(){
		this.discountHotelDataHelper = DataFactory.DataHelperUtils.getDiscountHotelDataHelper();
	}
	

	public ResultMessage_DiscountDetail addHotelDiscount(String hotelID, DiscountPO_hotel dis) throws RemoteException {
		return discountHotelDataHelper.addHotelDiscount(hotelID, dis);
	}

	public ResultMessage_Discount editHotelDiscount(String hotelID, DiscountPO_hotel dis) throws RemoteException {
		return discountHotelDataHelper.modifyHotelDiscount(hotelID, dis);
	}

	public List<DiscountPO_hotel> getHotelDiscount(String hotelID) throws RemoteException {
		return discountHotelDataHelper.getHotelDiscount(hotelID);
	}

	public ResultMessage_Discount deleteHotelDiscount(String hotelID, String discountID) throws RemoteException {
		return discountHotelDataHelper.deleteHotelDiscount(hotelID, discountID);
	}

	public ResultMessage_Discount invalidDiscount(String discountID) throws RemoteException {
		return discountHotelDataHelper.invalidDiscount(discountID);
	}

}
