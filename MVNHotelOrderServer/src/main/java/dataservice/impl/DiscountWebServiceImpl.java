package dataservice.impl;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.DiscountWebDataService;
import dataservice.datahelper.DiscountWebDataHelper;
import po.DiscountPO_web;
import tools.ResultMessage_Discount;
import tools.ResultMessage_DiscountDetail;

/**
 * 
 * @author wshwbluebird
 *
 */
public class DiscountWebServiceImpl implements DiscountWebDataService {
	
	private DiscountWebDataHelper discountDataHelper;
	
	public DiscountWebServiceImpl(){
		discountDataHelper = DataFactory.DataHelperUtils
				.getDiscountWebDataHelper();
	}
	
	public ResultMessage_DiscountDetail addWebDiscount(DiscountPO_web discountPO_web) throws RemoteException {
		return discountDataHelper.addDiscountPO(discountPO_web);
	}

	public ResultMessage_Discount editWebDiscount(DiscountPO_web discountPO_web) throws RemoteException {
		return discountDataHelper.modifyDiscountPO(discountPO_web);
	}

	public List<DiscountPO_web> getWebDiscount() throws RemoteException {
		return discountDataHelper.getALLDiscountPOList();
	}

	public ResultMessage_Discount deleteWebDiscount(String discountID) throws RemoteException {
		return discountDataHelper.deleteDiscount(discountID);
	}

	public ResultMessage_Discount invalidDiscount(String discountID) throws RemoteException {
		return discountDataHelper.invalidDisCount(discountID);
	}

	

}
